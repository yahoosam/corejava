public class CreditCardPayment extends Payment {
    @Override
    void processPayment() {
        System.out.println("Payment processed through credit card");
    }
}
