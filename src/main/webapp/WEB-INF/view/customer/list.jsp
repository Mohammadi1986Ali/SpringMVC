<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="customer.list.page.title"/></title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <table class="table">
            <thead>
            <tr style="background-color: lightgray; font-size: 13px;">
                <th class="text-center"><span><spring:message code="customer.id"/></span></th>
                <th class="text-center"><span><spring:message code="customer.name"/></span></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customers}" varStatus="loop">
                <tr>
                    <td class="text-center">${customer.id}</td>
                    <td class="text-center">${customer.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
