# The Composite Pattern


![problem-en](https://user-images.githubusercontent.com/20413644/235346968-84215099-8471-47d7-ba81-510e6f851b04.png)


The Composite design pattern is a structural pattern that allows you to compose objects into a tree-like structure to represent part-whole hierarchies. The pattern allows clients to treat individual objects and compositions of objects uniformly.

In this pattern, a composite object contains a collection of leaf objects or other composite objects, and all the objects in the hierarchy share a common interface or abstract class. The composite object is treated in the same way as a single object, regardless of whether it is a leaf or a composite object.

**This pattern consists of three main elements:**

**Component:** An abstract class or interface that represents the common operations that can be performed on both the leaf and composite objects. </br>
**Leaf:** A class that represents the individual objects in the composition. It implements the operations defined by the Component interface. <br>
**Composite:** A class that represents the composition of objects. It also implements the operations defined by the Component interface, but it does so by delegating the work to its child components. <br>

An example of the composite pattern can represent a company's organizational structure. We can have employees, who can either be individual contributors or managers who manage other employees. Managers can also be managed by other managers.

![4-types-of-organizational-chart](https://user-images.githubusercontent.com/20413644/235347113-ed9f7b17-fcc0-40c6-afca-905727c7860c.jpeg)

We can use the Composite design pattern to represent this hierarchy as follows:

```java
// Component interface
public interface Employee {
    public void showDetails();
}

// Leaf class
public class IndividualContributor implements Employee {
    private String name;

    public IndividualContributor(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Individual contributor: " + name);
    }
}

// Composite class
public class Manager implements Employee {
    private String name;
    private List<Employee> employees;

    public Manager(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void showDetails() {
        System.out.println("Manager: " + name);
        System.out.println("Employees:");
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }
}

```

In this example, we have the Employee interface as the Component, with two types of Concrete Components - IndividualContributor and Manager. The IndividualContributor is a leaf node, meaning it does not have any children. The Manager class, on the other hand, is a Composite node, which can have child employees (which can be either individual contributors or other managers).

```java
public class Mian{
    public static void main(String[] args){
        Employee jane = new IndividualContributor("Jane");
        Employee bob = new IndividualContributor("Bob");
        Employee alice = new IndividualContributor("Alice");

        Manager john = new Manager("John");
        Manager mike = new Manager("Mike");

        john.addEmployee(jane);
        john.addEmployee(mike);
        mike.addEmployee(bob);
        mike.addEmployee(alice);

        john.showDetails();
    }
}
```

In this example, we create a hierarchy where John is a manager who manages Jane (an individual contributor) and Mike (another manager), and Mike manages Bob and Alice (both individual contributors). When we call john.showDetails(), it will print out the details of the entire organizational hierarchy, starting from John and showing all the employees he manages (which includes Jane, Mike, Bob, and Alice).

This example demonstrates how the Composite design pattern allows us to treat individual employees and managers uniformly, regardless of whether they have subordinates or not.
