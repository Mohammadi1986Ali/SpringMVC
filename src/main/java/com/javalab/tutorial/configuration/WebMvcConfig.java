package com.javalab.tutorial.configuration;

import com.javalab.tutorial.web.interceptor.CustomInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.javalab.tutorial"})
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Logger logger = Logger.getLogger(WebMvcConfig.class.getName());

    private static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    private static final String RESOLVER_SUFFIX =".jsp";

    @Bean
    public InternalResourceViewResolver resolver() {
        logger.info("WebMvcConfig#resolver");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(RESOLVER_PREFIX);
        resolver.setSuffix(RESOLVER_SUFFIX);
        return resolver;
    }

    @Bean("messageSource")
    public MessageSource getMessageSource() {
        logger.info("WebMvcConfig#getMessageSource");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(60 * 60);
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("WebMvcConfig#addResourceHandlers");
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resource/")
                .setCachePeriod(60 * 60);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("WebMvcConfig#addInterceptors");
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor).addPathPatterns("/*");

        registry.addInterceptor(new CustomInterceptor());
    }

    @Bean("localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieDomain("myAppLocaleCookie");
        resolver.setCookieMaxAge(60 * 60);
        resolver.setDefaultLocale(new Locale("fa"));
        return resolver;
    }
}
