package ru.naissur.payments.model;

/**
 * naissur
 * 03.04.2017
 */
public class Payment {
    private final PaymentType type; // тип
    private final double amount;   // размер в рублях

    public Payment(PaymentType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public PaymentType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
