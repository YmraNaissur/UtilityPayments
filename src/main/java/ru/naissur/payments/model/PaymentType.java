package ru.naissur.payments.model;

/**
 * naissur
 * 03.04.2017
 */

public enum PaymentType {
    RENTAL, // арендная плата
    UTILITY, // коммунальные услуги
    ELECTRICITY, // электричество
    RENEWAL; // капитальный ремонт

    /*
     *  Вернем человеческое наименование вида платежа
     *  в зависимости от значения PaymentType
     */
    @Override
    public String toString() {
        switch (this) {
            case RENTAL:
                return "Арендная плата";
            case UTILITY:
                return "Коммунальные услуги";
            case ELECTRICITY:
                return "Электричество";
            case RENEWAL:
                return "Капитальный ремонт";
            default:
                return null;
        }
    }
}