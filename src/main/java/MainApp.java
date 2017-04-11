import ru.naissur.payments.model.Payment;
import ru.naissur.payments.repository.PaymentRepository;
import ru.naissur.payments.repository.mock.InMemoryPaymentRepository;

import java.util.List;

/**
 * naissur
 * 03.04.2017
 */
public class MainApp {
    public static void main(String[] args) {
        PaymentRepository repository = new InMemoryPaymentRepository();
        List<Payment> monthlyPayments = repository.getAll();

        monthlyPayments.forEach(p -> System.out.printf("Тип: %s, сумма: %.2f, оплатить до %s, оплачено = %b%n",
                getTypeInLowerCase(p.getType().toString()), p.getAmount(), p.getDueDate(), p.isPaid()));
    }

    private static String getTypeInLowerCase(String type) {
        return type.toLowerCase();
    }
}
