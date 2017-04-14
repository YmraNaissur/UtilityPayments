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

    /**
     * Получим тип платежа по строке из выпадающего списка
     * @param str строка, из которой нужно получить тип
     * @return тип платежа по переданной строке
     */
    public static PaymentType getTypeFromString(String str) {
        switch (str) {
            case "Арендная плата":
                return RENTAL;
            case "Коммунальные услуги":
                return UTILITY;
            case "Электричество":
                return ELECTRICITY;
            case "Капитальный ремонт":
                return RENEWAL;
            default:
                return null;
        }
    }

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