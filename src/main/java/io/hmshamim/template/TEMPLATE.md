# The Template Pattern
The Template Method pattern is a behavioral design pattern that defines the skeleton of an algorithm in a superclass, but allows subclasses to override specific steps of the algorithm without changing its structure. The Template Method pattern follows the "Don't call us, we'll call you" principle, which means that the superclass calls the methods of the subclass and not the other way around.

**The Template pattern consists of the following key components:**

**Abstract Class:** An abstract class that defines the template method and provides the skeleton of the algorithm. The abstract class also defines abstract methods that represent steps of the algorithm that can be implemented differently by subclasses.

**Concrete Class:** A concrete class that extends the abstract class and provides the implementation of the abstract methods. The concrete class can also override the default implementation of the template method if necessary.

**Template Method:** A method in the abstract class that defines the overall algorithm and calls the abstract methods that represent the specific steps of the algorithm.

**Hook Method:** An optional method in the abstract class that is called from the template method but has an empty default implementation. Subclasses can override the hook method to provide additional behavior or leave it as is.

The Template Method pattern is a useful pattern for creating reusable code that follows a common structure but allows for customization in certain areas. By defining the overall algorithm in an abstract class and providing hooks for subclasses to provide specific behavior, the pattern promotes code reuse and reduces duplication.

**Here is an example of the Template pattern:**

```java
    public abstract class Task {
        private AuditTrial auditTrial;
        public Task(){
            this.auditTrial= new AuditTrial();
        }
        public void execute(){
            auditTrial.record();
            doExecute();
        }
        protected abstract void doExecute();
    }
```

```java
    public class AuditTrial {
        public void record(){
            System.out.println("Audit Recorded");
        }
   }
```

```java
    public class TransferMoneyTask extends Task{
        @Override
        protected void doExecute() {
            System.out.println("Money Transferred.");
        }
    }
```

```java
    public class Main {
        public static void main(String[] args) {
            var moneyTransfer = new TransferMoneyTask();
            moneyTransfer.execute();
        }
    }
```
In this scenario everytime a Banking application transfer, receive, and send money it keeps an Audit log.
Here, Task class is such an algorithm which has a template method name execute. This method calls the AuditTrial record 
and the abstract method which will be Override by all the subclasses, here TransferMoneyTask class.
TransferMoneyTask class have the actual operation of transferring money by following 
its parents templated algorithm.
