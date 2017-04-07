<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="payments" type="java.util.List" scope="request"/>

<html>
    <head>
        <title>UtilityPayments</title>
    </head>
    <body>
        <h1>Utility Payments</h1>

        <c:forEach items="${payments}" var="payment">
            <jsp:useBean id="payment" type="ru.naissur.payments.model.Payment" scope="page" />
            <br>${payment.type}
        </c:forEach>
    </body>
</html>