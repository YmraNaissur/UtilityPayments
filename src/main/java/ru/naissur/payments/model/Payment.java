package ru.naissur.payments.model;

import java.time.LocalDate;

/**
 * naissur
 * 03.04.2017
 */
public class Payment {
    private final PaymentType type; // тип
    private final double amount;   // размер в рублях
    private final LocalDate dueDate; // до какой даты следует оплатить

    private boolean payed; // оплачено ли?


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

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
