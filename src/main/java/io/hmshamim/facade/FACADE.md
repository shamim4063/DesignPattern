# Facade Pattern

![2019649607-wie-stelle-ich-mir-einen-rechner-zusammen-teil-1-begriffe-und-komponenten-thumbnail2-3fea](https://github.com/shamim4063/DesignPattern/assets/20413644/320424d4-7067-4060-8e86-24a2ba8e7dcc)

The Facade design pattern is a structural pattern that provides a simplified interface to a complex subsystem or a group of interfaces. It acts as a high-level interface that makes it easier for clients to interact with the underlying system by providing a unified interface.

The main purpose of the Facade pattern is to hide the complexity of the system and provide a simplified interface that abstracts away the details of the subsystem. It promotes loose coupling between clients and the subsystem by providing a single entry point to access its functionality.

**Key components of the Facade pattern are:**

***Facade:*** It is the main interface that clients interact with. It provides simplified methods that delegate the calls to the appropriate classes within the subsystem. The Facade acts as a mediator between the client and the subsystem.

***Subsystem Classes:*** These are the individual classes or components that make up the complex subsystem. They encapsulate the functionality and implement the operations required by the Facade.

**Here's an example in Java to illustrate the Facade pattern:**

```java
// Subsystem classes
class CPU {
    public void start() {
        System.out.println("CPU started");
    }

    public void execute() {
        System.out.println("CPU executing");
    }

    public void shutdown() {
        System.out.println("CPU shutdown");
    }
}

class Memory {
    public void load() {
        System.out.println("Memory loaded");
    }
}

class HardDrive {
    public void readData() {
        System.out.println("Reading data from hard drive");
    }
}

// Facade class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void start() {
        cpu.start();
        memory.load();
        hardDrive.readData();
        cpu.execute();
    }

    public void shutdown() {
        cpu.shutdown();
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
        // ... do some operations
        computer.shutdown();
    }
}

```


In this example, we have the CPU, Memory, and HardDrive classes as the subsystem classes that represent the complex operations of a computer system. The ComputerFacade class acts as the Facade, providing a simplified interface for starting and shutting down the computer. The client code interacts only with the ComputerFacade, which internally delegates the calls to the appropriate subsystem classes.

By using the Facade pattern, the client code doesn't need to directly interact with the complex subsystem. It only needs to call the appropriate methods on the Facade, which abstracts away the complexities and provides a simple interface. This improves code maintainability, reduces coupling between clients and subsystems, and enhances overall system usability.
