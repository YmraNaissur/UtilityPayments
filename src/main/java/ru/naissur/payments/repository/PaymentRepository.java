package ru.naissur.payments.repository;

import ru.naissur.payments.model.Payment;
import java.util.List;

/**
 * naissur
 * 06.04.2017
 */
public interface PaymentRepository {
    Payment save(Payment payment); // сохраняем платеж в хранилище

    /**
     * Получаем платеж из хранилища по id
     * @param id идентификационный номер платежа
     * @return платеж с указанным id или null, если такого id нет в хранилище
     */
    Payment get(int id);

    /**
     * Получаем все платежи из хранилища
     * @return список всех платежей, которые есть в хранилище
     */
    List<Payment> getAll();
}