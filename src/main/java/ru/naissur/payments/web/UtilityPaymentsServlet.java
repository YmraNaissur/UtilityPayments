package ru.naissur.payments.web;

import ru.naissur.payments.model.Payment;
import ru.naissur.payments.model.PaymentType;
import ru.naissur.payments.repository.PaymentRepository;
import ru.naissur.payments.repository.mock.InMemoryPaymentRepository;
import ru.naissur.payments.util.PaymentUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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
                repository.get(getId(req)).pay();
                resp.sendRedirect("payments");
                break;
            case "delete":
                repository.delete(getId(req));
                resp.sendRedirect("payments");
                break;
            case "add":
                final Payment payment = (action != null && action.equals("add") ?
                    new Payment(PaymentType.RENTAL, 9000, LocalDate.now()) :
                    repository.get(getId(req)));
                req.setAttribute("payment", payment);
                req.getRequestDispatcher("/payment.jsp").forward(req, resp);
                break;
            case "all":
                // извлечем список платежей из репозитория
                List<Payment> paymentList = repository.getAll();
                req.setAttribute("payments", paymentList);
                req.setAttribute("totalUnpaidAmount", PaymentUtil.getTotalUnpaidAmount(paymentList));
                req.getRequestDispatcher("/payments.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");

        Payment payment = new Payment (PaymentType.getTypeFromString(req.getParameter("type")),
                Double.parseDouble(req.getParameter("amount")),
                LocalDate.parse(req.getParameter("dueDate")));
        repository.save(payment);
        resp.sendRedirect("payments");
    }

    // получаем id платежа, чтобы не писать постоянно Integer.parseInt(req.getParameter("id"))
    private int getId(HttpServletRequest req) {
        return Integer.parseInt(req.getParameter("id"));
    }
}