## The Decorator Pattern
he Decorator design pattern is a structural pattern that allows the addition of new functionality to an existing object without changing its structure. It is also known as the Wrapper pattern. The decorator pattern involves creating a decorator class that wraps the original class and provides additional functionality keeping the class methods signature intact.

In simple terms, it is like adding layers of decoration to an object without changing its original structure. Each decorator adds its own behavior to the object, and the object can have multiple decorators.

**The key components of the Decorator pattern are:**

**Component:** It is the interface or abstract class that defines the methods that will be implemented by the concrete components and decorators.<br>
**Concrete Component:** It is the base class or implementation of the component interface.<br>
**Decorator:** It is the abstract class that implements the component interface and contains a reference to the component object. It is responsible for adding additional functionality to the component.<br>
**Concrete Decorator:** It is the class that extends the decorator class and adds its own behavior to the component.<br>

**Here's an example in Java:**

Suppose we have a Coffee interface with a method getCost() that returns the cost of the coffee. We want to add the ability to add extra ingredients to the coffee like milk, sugar, etc. We can use the decorator pattern to achieve this.

```java
// Component interface
public interface Coffee {
    double getCost();
}

// Concrete Component
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.0;
    }
}

// Decorator abstract class
public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorators
public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}

public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2;
    }
}

```

We can now create a SimpleCoffee object and then wrap it with Milk and Sugar decorators to create a customized coffee with additional ingredients and cost.

```java
public class Main{
    public static void main(String[] args){
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee coffeeWithMilk = new Milk(simpleCoffee);
        Coffee coffeeWithMilkAndSugar = new Sugar(coffeeWithMilk);

        System.out.println(coffeeWithMilkAndSugar.getCost()); // output: 2.2
    }
}
```

In this example, we have the SimpleCoffee class as the concrete component, and the Milk and Sugar classes as concrete decorators. The CoffeeDecorator class is the decorator abstract class that contains a reference to the component object (Coffee), and each decorator adds its own behavior to the component by calling the component's getCost() method and adding its own cost to it.