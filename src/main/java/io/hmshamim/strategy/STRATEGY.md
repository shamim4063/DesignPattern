# The Strategy Pattern

The Strategy Pattern is a behavioral design pattern that allows you to define a family of interchangeable algorithms and encapsulate each one as an object, and make them interchangeable at runtime. It allows you to separate the algorithm from the client that uses it, providing a way to select an appropriate algorithm dynamically based on the client's needs. This pattern is often used when you have a family of related algorithms and want to choose one of them at runtime depending on the situation.

**The Strategy pattern consists of the following key components:**

**Context:** The context is the object that will use one of the strategies to perform a task.

**Strategy:**  The strategy interface defines a common interface for all the concrete strategies to implement.

**Concrete Strategies:** The concrete strategies are the different algorithms that the context can use.

When the context needs to perform a task, it delegates the task to one of its concrete strategies, which implements the task using a specific algorithm. By encapsulating the algorithms as objects, you can easily switch between them at runtime without changing the context's code. This makes the Strategy Pattern a powerful tool for designing flexible and extensible systems.

In summary, the Strategy Pattern is a way to encapsulate a family of related algorithms as objects and make them interchangeable at runtime. It is useful when you have a set of related algorithms and want to select one of them dynamically based on the situation.

**Difference between the Strategy Pattern:**

Difference between the Strategy Pattern and State Pattern is their intent. The Strategy Pattern is concerned with selecting a behavior at runtime from a family of related algorithms, whereas the State Pattern is concerned with changing the behavior of an object as its internal state changes.

**Here is an example of the Strategy pattern:**

Suppose you have a payment processing system that needs to support multiple payment methods such as credit card, PayPal, and bank transfer. Each payment method has a different algorithm for processing the payment.

First, you define a strategy interface that specifies the contract for all payment strategies:
```java
public interface PaymentStrategy {
    void pay(double amount);
}
```

Then, you create concrete strategy classes that implement the strategy interface:

```java
public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String expirationDate;
    private int cvv;

    public CreditCardStrategy(String cardNumber, String expirationDate, int cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public void pay(double amount) {
        // process payment using credit card algorithm
        System.out.println(amount + " paid with credit card");
    }
}

public class PayPalStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount) {
        // process payment using PayPal algorithm
        System.out.println(amount + " paid with PayPal");
    }
}

public class BankTransferStrategy implements PaymentStrategy {
    private String accountNumber;
    private String routingNumber;

    public BankTransferStrategy(String accountNumber, String routingNumber) {
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    public void pay(double amount) {
        // process payment using bank transfer algorithm
        System.out.println(amount + " paid with bank transfer");
    }
}

```

Next, you create a context class that uses the payment strategies:

```java
    public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}

```

Finally, you can use the payment processor to process payments with different payment methods:

```java
  public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor(new CreditCardStrategy("1234 5678 9012 3456", "12/23", 123));
        paymentProcessor.processPayment(100.00);

        paymentProcessor.setPaymentStrategy(new PayPalStrategy("john@example.com", "password"));
        paymentProcessor.processPayment(50.00);

        paymentProcessor.setPaymentStrategy(new BankTransferStrategy("123456789", "987654321"));
        paymentProcessor.processPayment(200.00);
    }
}
```

In this example, the PaymentProcessor context uses different payment strategies to process payments dynamically at runtime. You can easily add new payment strategies by implementing the PaymentStrategy interface and creating a concrete strategy class. This makes the payment processing system extensible and flexible.

