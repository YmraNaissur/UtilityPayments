package ru.naissur.payments.model;

/**
 * naissur
 * 03.04.2017
 */
public class Payment {
    private final PaymentType type; // тип
    private final int amount;   // размер в рублях

    public Payment(PaymentType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public PaymentType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
