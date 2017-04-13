<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="payments" type="java.util.List" scope="request" />
<jsp:useBean id="totalUnpaidAmount" type="java.lang.Double" scope="request" />

<html>
    <head>
        <title>Коммунальные платежи</title>
        <style>
            th {
                font-weight: bold;
                text-align: left;
            }

            .paid {
                color: green;
            }
            .unpaid {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1 style="padding-left: 8px">Коммунальные платежи</h1>

        <table border="1" cellpadding="8">
            <tr>
                <th>Тип платежа</th>
                <th>Размер платежа, руб</th>
                <th>Оплатить до</th>
            </tr>

            <c:forEach items="${payments}" var="payment">
                <tr class="${payment.paid ? 'paid' : 'unpaid'}">
                    <jsp:useBean id="payment" type="ru.naissur.payments.model.Payment" scope="page"/>
                    <td>${payment.type.toString()}</td>
                    <td>${payment.amount}</td>
                    <td>${payment.dueDate}</td>
                    <td>
                        <c:if test="${!payment.paid}">
                            <a href="<c:out value="/payments?action=pay&id=${payment.id}" />">Оплатить</a>
                        </c:if>
                    </td>
                    <td><a href="<c:out value="/payments?action=delete&id=${payment.id}" />">Удалить</a></td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="2" style="text-align: right"><strong>Сумма неоплаченных счетов, руб:</strong></td>
                <td>${totalUnpaidAmount}</td>
            </tr>
        </table>
    </body>
</html>