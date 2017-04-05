import ru.naissur.payments.model.Payment;
import ru.naissur.payments.model.PaymentType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * naissur
 * 03.04.2017
 */
public class MainApp {
    public static void main(String[] args) {
        List<Payment> monthlyPayments = new ArrayList<>();
        monthlyPayments.add(new Payment(PaymentType.RENTAL, 9000, LocalDate.of(2017, 4, 10)));
        monthlyPayments.add(new Payment(PaymentType.ELECTRICITY, 286, LocalDate.of(2017, 4, 30)));
        monthlyPayments.add(new Payment(PaymentType.UTILITY, 3256.75, LocalDate.of(2017, 4, 20)));
        monthlyPayments.add(new Payment(PaymentType.RENEWAL, 189.91, LocalDate.of(2017, 4, 10)));

        monthlyPayments.forEach(p -> System.out.printf("Тип: %s, сумма: %.2f, оплатить до %s%n",
                getTypeInLowerCase(p.getType().toString()), p.getAmount(), p.getDueDate()));
    }

    private static String getTypeInLowerCase(String type) {
        return type.toLowerCase();
    }
}
