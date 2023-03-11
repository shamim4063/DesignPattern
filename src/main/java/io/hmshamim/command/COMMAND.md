# Command Pattern

The Command pattern is a behavioral design pattern that decouples the sender of a request from its receiver by encapsulating the request as an object. It allows requests to be treated as first-class objects, which can be easily composed and manipulated.
### The pattern consists of several key components: 
- A Command interface or abstract class that defines the execute() method.
- Concrete Command classes that encapsulate specific requests and their parameters.
- A Receiver object that performs the actual work of the request.
- An Invoker object that sends the request to the Command object to execute.
- And optionally, an Undo operation that allows the previous state to be restored.

#### Using the Command pattern can provide a number of benefits, including:

1. Decoupling the sender and receiver of a request, which can simplify the design and maintenance of the code.

2. Enabling requests to be easily composed and manipulated, allowing complex behaviors to be created from simple building blocks.

3. Supporting the undoing of previous actions, which can improve the user experience and add robustness to the application.

4. Supporting the logging and auditing of requests, which can be useful for debugging and security purposes.

### Here is an example of the Command pattern in Java:

```java
public interface Command {
    void execute();
}

// Concrete Command
public class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.switchOn();
    }
}

// Receiver
public class Light {
    public void switchOn() {
        System.out.println("The light is on.");
    }
}

// Invoker
public class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        Command command = new LightOnCommand(light);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(command);
        remoteControl.pressButton();
    }
}
```

In this example, we have the Command interface that defines the execute() method, which the Concrete Command class LightOnCommand implements. The LightOnCommand class takes a Light object as a parameter and overrides the execute() method to call the switchOn() method on the Light object.

The Receiver class Light has a switchOn() method that actually performs the action when the execute() method is called.

The Invoker class RemoteControl has a setCommand() method that sets the Command object and a pressButton() method that calls the execute() method on the Command object.

Finally, the Client class creates a Light object, a LightOnCommand object with the Light object as a parameter, and a RemoteControl object. The LightOnCommand object is set as the Command object for the RemoteControl object, and the pressButton() method is called on the RemoteControl object to execute the LightOnCommand. When executed, the LightOnCommand calls the switchOn() method on the Light object to switch it on.