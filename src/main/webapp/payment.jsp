<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Добавить платеж</title>
    </head>
    <body>
        <h1>Добавить платеж</h1>
        <hr>
        <jsp:useBean id="payment" type="ru.naissur.payments.model.Payment" scope="request"/>
        <form method="post" action="payments">
            <input type="hidden" name="id" value="${payment.id}">
            <dl>
                <dt>Тип платежа:</dt>
                <dd>
                    <select name="type">
                        <option selected>Арендная плата</option>
                        <option>Коммунальные услуги</option>
                        <option>Электричество</option>
                        <option>Капитальный ремонт</option>
                    </select>
                </dd>
            </dl>

            <dl>
                <dt>Размер платежа:</dt>
                <dd><input type="number" step="0.01" value="${payment.amount}" name="amount"></dd>
            </dl>

            <dl>
                <dt>Оплатить до:</dt>
                <dd><input type="date" value="${payment.dueDate}" name="dueDate"></dd>
            </dl>

            <button type="submit">Сохранить</button>
            <button onclick="window.history.back()">Отмена</button>
        </form>
    </body>
</html>