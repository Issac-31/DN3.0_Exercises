public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of payment gateways
        PayPalPaymentGateway payPal = new PayPalPaymentGateway();
        StripePaymentGateway stripe = new StripePaymentGateway();

        // Create adapters for the payment gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);

        // Use the adapters to process payments
        payPalAdapter.processPayment(100.00);
        stripeAdapter.processPayment(200.00);
    }
}
