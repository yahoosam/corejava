public abstract class Payment {
    void printReceipt() {
        System.out.println("\nReceipt Printed...");
    }

    abstract void processPayment();
}
