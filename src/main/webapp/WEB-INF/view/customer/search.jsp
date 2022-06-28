<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="customer.search.page.title"/></title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <label>
            <span><spring:message code="customer.search"/></span>
        </label>
    </div>
    <div class="col-md-12">
        <form action="list" method="GET">
            <div class="form-group">
                <input type="text" name="customerName" id="customerName" required="true"
                       placeholder='<spring:message code="customer.name"/>'>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-info">
                    <span><spring:message code="search"/></span>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
