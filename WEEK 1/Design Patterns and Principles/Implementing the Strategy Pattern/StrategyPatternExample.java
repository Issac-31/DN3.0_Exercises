public class StrategyPatternExample {

    // Step 2: Define Strategy Interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Step 3: Implement Concrete Strategies

    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying $" + amount + " using Credit Card: " + cardNumber);
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying $" + amount + " using PayPal account: " + email);
        }
    }

    // Step 4: Implement Context Class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public PaymentContext(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Step 5: Test the Strategy Implementation
    public static void main(String[] args) {
        // Create different payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432");
        PaymentStrategy paypalPayment = new PayPalPayment("user@example.com");

        // Create context with CreditCardPayment strategy
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.executePayment(100.0);

        // Change strategy to PayPalPayment
        paymentContext = new PaymentContext(paypalPayment);
        paymentContext.executePayment(200.0);
    }
}
