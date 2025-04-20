package SOLIDPrinciples.DependencyInversionPrinciple;

public class WithoutDIP {
//    🚨 Problem with Bad Design (Tightly Coupled)

    class CreditCardPayment {
        void pay(double amount) {
            System.out.println("Paid $" + amount + " using Credit Card.");
        }
    }

    class PaymentService {
        private final CreditCardPayment paymentProcessor; // ❌ Direct dependency

        public PaymentService() {
            this.paymentProcessor = new CreditCardPayment(); // ❌ Tightly coupled
        }

        void makePayment(double amount) {
            paymentProcessor.pay(amount);
        }
    }
}
