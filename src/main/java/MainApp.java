import ru.naissur.payments.model.Payment;
import ru.naissur.payments.model.PaymentType;

/**
 * naissur
 * 03.04.2017
 */
public class MainApp {
    public static void main(String[] args) {
        Payment payment = new Payment(PaymentType.RENTAL, 9000);
        System.out.println("Тип платежа: " + payment.getType());
        System.out.println("Размер платежа: " + payment.getAmount());
    }
}
