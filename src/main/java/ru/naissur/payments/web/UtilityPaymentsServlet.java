package ru.naissur.payments.web;

import ru.naissur.payments.model.Payment;
import ru.naissur.payments.repository.PaymentRepository;
import ru.naissur.payments.repository.mock.InMemoryPaymentRepository;
import ru.naissur.payments.util.PaymentUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * naissur
 * 07.04.2017
 */
public class UtilityPaymentsServlet extends HttpServlet {
    private PaymentRepository repository;

    @Override
    public void init() throws ServletException {
        super.init();
        repository = new InMemoryPaymentRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // будем проверять, чему равен параметр action. Если он null, то просто показываем весь список
        String action = req.getParameter("action");

        switch (action == null ? "all" : action) {
            case "pay":
                int id = Integer.parseInt(req.getParameter("id"));
                repository.get(id).pay();
                resp.sendRedirect("payments");
                break;
            case "all":
                // извлечем список платежей из репозитория
                List<Payment> paymentList = repository.getAll();
                req.setAttribute("payments", paymentList);
                req.setAttribute("totalUnpaidAmount", PaymentUtil.getTotalUnpaidAmount(paymentList));
                req.getRequestDispatcher("/payments.jsp").forward(req, resp);
        }
    }
}