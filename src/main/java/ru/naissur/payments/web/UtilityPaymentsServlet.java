package ru.naissur.payments.web;

import ru.naissur.payments.repository.PaymentRepository;
import ru.naissur.payments.repository.mock.InMemoryPaymentRepository;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        req.setAttribute("payments", repository.getAll());
        req.getRequestDispatcher("/payments.jsp").forward(req, resp);
    }
}