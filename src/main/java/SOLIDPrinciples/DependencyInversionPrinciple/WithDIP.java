package SOLIDPrinciples.DependencyInversionPrinciple;

//- High-level modules should not depend on low-level modules. Both should depend on abstractions. This promotes loose coupling.

//High-Level module depends on abstraction
interface PaymentProcessor {
    void pay(double amount);
}

// ✅ Low-level modules depend on abstraction
class CreditCardPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class UPIPayment implements  PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using UPIPayment.");
    }
}

// ✅ PaymentService depends on abstraction, not implementation
class PaymentService {
    private PaymentProcessor paymentProcessor;

    public  PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    void makePayment(double amount) {
        paymentProcessor.pay(amount);
    }
}

public class WithDIP {
    public static void main(String[] args) {
        PaymentProcessor creditCard = new CreditCardPayment();
        PaymentService payment1 = new PaymentService(creditCard);
        payment1.makePayment(100.0);

        PaymentProcessor paypal = new PayPalPayment();
        PaymentService payment2 = new PaymentService(paypal);
        payment2.makePayment(200.0);

        PaymentProcessor upi = new UPIPayment();
        PaymentService payment3 = new PaymentService(upi);
        payment3.makePayment(50.0);
    }
}
