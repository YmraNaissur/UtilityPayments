package ru.naissur.payments.repository.mock;

import ru.naissur.payments.model.Payment;
import ru.naissur.payments.model.PaymentType;
import ru.naissur.payments.repository.PaymentRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * naissur
 * 06.04.2017
 */
public class InMemoryPaymentRepository implements PaymentRepository {
    private Map<Integer, Payment> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new Payment(PaymentType.RENTAL, 9000, LocalDate.of(2017, 4, 10)));
        save(new Payment(PaymentType.ELECTRICITY, 286, LocalDate.of(2017, 4, 30)));
        save(new Payment(PaymentType.UTILITY, 3256.75, LocalDate.of(2017, 4, 20)));
        save(new Payment(PaymentType.RENEWAL, 189.91, LocalDate.of(2017, 4, 10)));
    }

    @Override
    public Payment save(Payment payment) {
        if (payment.isNew()) {
            payment.setId(counter.incrementAndGet());
        }
        repository.put(payment.getId(), payment);
        return payment;
    }

    @Override
    public Payment get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Payment> getAll() {
        return repository.values().stream().collect(Collectors.toList());
    }
}
