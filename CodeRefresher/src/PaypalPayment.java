public class PaypalPayment extends Payment {
    @Override
    void processPayment() {
        System.out.println("Payment processed through Paypal");
    }
}
