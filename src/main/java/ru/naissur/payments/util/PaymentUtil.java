package ru.naissur.payments.util;

import ru.naissur.payments.model.Payment;
import java.util.List;

/**
 * naissur
 * 11.04.2017
 */
public class PaymentUtil {
    /**
     * Рассчет полной стоимости неоплаченных счетов
     * @param paymentList список со счетами
     * @return стоимость неоплаченных счетов из списка paymentList
     */
    public static double getTotalUnpaidAmount(List<Payment> paymentList) {
        return paymentList
                .stream()
                .filter(payment -> !payment.isPaid())
                .mapToDouble(Payment::getAmount)
                .sum();
    }
}
