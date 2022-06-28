# SpringMVC

- ## Spring Config
- Alternative option for SpringWebAppInitializer configuration:

        public class SpringWebAppInitializer implements WebApplicationInitializer {
            private static final Logger logger = Logger.getLogger(SpringWebAppInitializer.class.getName());
            private static final String DISPATCHER_SERVLET_NAME = "DispatcherServlet";

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
                context.register(WebMvcConfig.class);

                ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(context));
                dispatcher.setLoadOnStartup(1);
                dispatcher.addMapping("/");
            }
        }

- ## Hibernate Config 
- IP, PORT, SID, USERNAME and PASSWORD must be initialized.