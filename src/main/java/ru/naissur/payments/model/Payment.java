package ru.naissur.payments.model;

import java.time.LocalDate;

/**
 * naissur
 * 03.04.2017
 */
public class Payment extends BaseEntity {
    private final PaymentType type; // тип
    private final double amount;   // размер в рублях
    private final LocalDate dueDate; // до какой даты следует оплатить
    private boolean paid = false; // оплачено ли?


    public Payment(PaymentType type, double amount, LocalDate dueDate) {
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public PaymentType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Проверяем, заплатили ли мы уже по этому счету
     * @return true если заплатили, false если не заплатили
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Заплатить по счету. Операция необратима,
     * поэтому нет публичного сеттера setPayed()
     */
    public void pay() {
        this.paid = true;
    }
}
