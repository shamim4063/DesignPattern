# Chain of Responsibility Pattern

![chain-of-responsibility-3x](https://user-images.githubusercontent.com/20413644/230666532-31afb707-c13a-4c00-803c-2c5343934049.png)

Chain of Responsibility is a behavioral design pattern that allows you to build a chain of objects that can handle requests, and pass the request along the chain until it is handled or until the end of the chain is reached.

In this pattern, each object in the chain has a reference to the next object in the chain, forming a linked list. When a request is received by the first object in the chain, it checks if it can handle the request. If it can, it handles the request and the chain ends. If it cannot handle the request, it passes the request to the next object in the chain, and so on, until the request is handled or until the end of the chain is reached.

**The chain of responsibility pattern has the following components:**

**Handler:** Defines an interface for handling requests.

**Concrete Handler:** Implements the handler interface and handles requests it is responsible for. If it cannot handle the request, it passes it to the next handler in the chain.

**Client:** Sends requests to the first object in the chain.

**Here's an example of Chain of Responsibility pattern in Java:**

![bank-management](https://user-images.githubusercontent.com/20413644/230667139-9800742c-a301-4583-b9d5-9176932ee248.jpeg)

Let us consider the development of a Loan Approval System for a Bank, where loan approval is categorised into three different roles:

1. **Junior Loan Officer:** The Junior Loan Officer handles all loan requests initially. If all the required information is correct and the requested loan amount is less than or equal to 1000/-, the loan is approved by the Junior Loan Officer. However, if the requested loan amount is more than 1000/-, the loan request is forwarded to the Senior Loan Officer.

2. **Senior Loan Officer:** The Senior Loan Officer approves loan requests that are less than 5000/-. If the requested loan amount is greater than or equal to 5000/-, the request is forwarded to the Loan Manager.

3. **Loan Manager:** The Loan Manager approves loan requests that are more than 5000/-.

We can design our application using Chain Of Responsibility in following way:

```java
public class CustomerRequest {
    private String name;
    private double amount;

    public CustomerRequest(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(CustomerRequest request);
}

public class JuniorLoanOfficer extends Handler {
    public void handleRequest(CustomerRequest request) {
        if (request.getAmount() < 1000) {
            System.out.println("Junior Loan officer approved the requested loan for "+ request.getName());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

public class SeniorLoanOfficer extends Handler {
    public void handleRequest(CustomerRequest request) {
        if (request.getAmount() >= 1000 && request.getAmount() < 5000) {
            System.out.println("Senior Loan officer have approved requested loan for "+ request.getName());            
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

public class LoanManager extends Handler {
    public void handleRequest(CustomerRequest request) {
        if (request.getAmount() >= 5000) {
            System.out.println("Loan Manager have approved requested amount for "+ request.getName());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

public class Client {
    public static void main(String[] args) {
        Handler juniorLoanOfficer = new JuniorLoanOfficer();
        Handler seniorLoanOfficer = new SeniorLoanOfficer();
        Handler loanManager = new LoanManager();
        
        juniorLoanOfficer.setSuccessor(h2);
        seniorLoanOfficer.setSuccessor(h3);

        // Generate and process requests
        CustomerRequest request1 = new CustomerRequest("John", 500);
        juniorLoanOfficer.handleRequest(request1);

        CustomerRequest request2 = new CustomerRequest("Jane", 2000);
        juniorLoanOfficer.handleRequest(request2);

        CustomerRequest request3 = new CustomerRequest("Bob", 10000);
        juniorLoanOfficer.handleRequest(request3);
    }
}

```
