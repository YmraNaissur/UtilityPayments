import ru.naissur.payments.model.Payment;
import ru.naissur.payments.model.PaymentType;

import java.util.ArrayList;
import java.util.List;

/**
 * naissur
 * 03.04.2017
 */
public class MainApp {
    public static void main(String[] args) {
        List<Payment> monthlyPayments = new ArrayList<>();
        monthlyPayments.add(new Payment(PaymentType.RENTAL, 9000));
        monthlyPayments.add(new Payment(PaymentType.ELECTRICITY, 286));
        monthlyPayments.add(new Payment(PaymentType.UTILITY, 3256.75));
        monthlyPayments.add(new Payment(PaymentType.RENEWAL, 189.91));

        monthlyPayments.forEach(p -> System.out.printf("Тип: %s, сумма: %.2f%n", getTypeInLowerCase(p.getType().toString()), p.getAmount()));
    }

    private static String getTypeInLowerCase(String type) {
        return type.toLowerCase();
    }
}
