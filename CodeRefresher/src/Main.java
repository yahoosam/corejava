import java.security.cert.X509Certificate;
import java.time.LocalTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Abstraction demo
        /*
        🚀 Explanation:
        Abstract Class: Payment provides a common interface.
        Concrete Classes: CreditCardPayment and PayPalPayment implement the processPayment() method.
        Abstraction in Action:
        Users call processPayment() without knowing the internal payment logic.
        The complexity of payment processing is hidden from the user.
         */
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        creditCardPayment.processPayment();
        creditCardPayment.printReceipt();

        PaypalPayment paypalPayment = new PaypalPayment();
        paypalPayment.processPayment();
        paypalPayment.printReceipt();

        //Encapsulation demo
        /*
        🛠️ Example of Encapsulation
        🧠 Scenario:

        Imagine you're building a Bank Account system. We want to:

        Prevent direct access to account balance.
        Allow safe deposits and withdrawals through methods.
         */
        BankAccount bankAccount = new BankAccount("Sam", 100);
        System.out.println(bankAccount.getAccountName());
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(3000);
        bankAccount.deposit(5000);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(3000);
        System.out.println(bankAccount.getBalance());


        //Streams API
        List<String> namelist = Arrays.asList("Sam", "tommy", "tim", "kim", "tim");
        List<String> filterednamelist = namelist.stream().filter(name -> name.length() <= 3).collect(Collectors.toList());
        //method reference
        filterednamelist.forEach(System.out::println);
        System.out.println(filterednamelist);
        //map
        List<String> namelist2 = Arrays.asList("Sam", "tommy", "tim", "kim", "tim");
        Map<String, Integer> namewithlength = namelist2.stream().collect(Collectors.toMap(name -> name, name -> name.length(), (existing, replacement) -> replacement));
        namewithlength.forEach((name, length) -> System.out.println(name + " : " + length));

        //functional interfaces - custom
        Calculator add = ((x, y) -> x + y);
        Calculator sub = ((x, y) -> x - y);
        Calculator mul = ((x, y) -> x * y);
        Calculator div = ((x, y) -> x / y);
        Calculator mod = ((x, y) -> x % y);

        System.out.println("Addition: " + add.operate(2, 4));
        System.out.println("Subtraction: " + sub.operate(2, 4));
        System.out.println("Multiplication: " + mul.operate(2, 4));
        System.out.println("Division: " + div.operate(2, 4));
        System.out.println("Modulo: " + mod.operate(2, 4));

        //functional interfaces - built in (predicate, function, consumer, supplier, unaryoperator and binaryoperator

        //Predicate - filters based on some condition
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("isEven: " + isEven.test(2));

        //Function - Represents: A function that takes one argument and returns a result
        Function<String, Integer> checkLength = x -> x.length();
        System.out.println("checkLength: " + checkLength.apply("123"));

        //Consumer - Represents: An operation that takes an argument and returns nothing
        Consumer<String> greet = msg -> System.out.println("Welcome " + msg + "!!");
        greet.accept("Sam");

        //Supplier - Represents: A supplier of results (takes no arguments and returns a value)
        Supplier<String> timesupplier = () -> LocalTime.now().toString();
        System.out.println(timesupplier.get());

        //BiPredicate<T, U> - Represents: A condition with two arguments

        //BiFunction<T, U, R> - Represents: A function that takes two arguments and produces a result

        //BiConsumer<T, U> - Represents: An operation with two inputs that returns no result

        //UnaryOperator - Represents: A function that takes and returns the same type
        UnaryOperator<String> uppercase = x -> x.toUpperCase();
        System.out.println(uppercase.apply("Sam"));

        //BinaryOperator<T> - Represents: A function that takes two arguments of the same type and returns a result of the same type
        BinaryOperator<Integer> getmax = (x, y) -> x > y ? x : y;
        System.out.println(getmax.apply(1, 2));
    }
}