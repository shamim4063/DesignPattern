# Mediator Pattern

Mediator pattern is a behavioral design pattern that allows objects to communicate with each other through a mediator, instead of directly communicating with each other. The mediator acts as an intermediary between objects, decoupling them and promoting better scalability and maintainability of the codebase.

In this pattern, the objects do not communicate with each other directly. Instead, they send messages to the mediator, which in turn communicates with other objects. This way, the objects are isolated from each other, and they do not need to have any knowledge of each other's existence.

### Problem
Say you have a dialog for creating and editing customer profiles. It consists of various form controls such as text fields, checkboxes, buttons, etc.
![](../../../../../../../Desktop/problem1-en.png)

Some of the form elements may interact with others. For instance, selecting the “I have a dog” checkbox may reveal a hidden text field for entering the dog’s name. Another example is the submit button that has to validate values of all fields before saving the data.

### Solution
![](../../../../../../../Desktop/solution1-en.png)


### The Mediator pattern typically includes the following components:

The mediator pattern has the following components:

- **Mediator:** Defines an interface for communication between colleague objects.
- **Concrete Mediator:** Implements the mediator interface and coordinates communication between colleague objects.
- **Colleague:** Defines an interface for communication with other colleagues.
- **Concrete Colleague:** Implements the colleague interface and communicates with other colleagues through the mediator.

### Here's an example of Mediator pattern in Java:

Suppose we have a chat room application, where users can send messages to each other. In this case, the mediator would be the chat room object, which would receive messages from users and broadcast them to other users. The colleagues would be the user objects, which would send messages to the chat room object and receive messages from it.

```java
// Mediator interface
public interface ChatRoomMediator {
    public void sendMessage(String message, User user);
    public void addUser(User user);
}

// Concrete mediator
public class ChatRoom implements ChatRoomMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}

// Colleague interface
public interface User {
    public void send(String message);
    public void receive(String message);
}

// Concrete colleague
public class ChatUser implements User {
    private ChatRoomMediator chatRoom;
    private String name;

    public ChatUser(ChatRoomMediator chatRoom, String name) {
        this.chatRoom = chatRoom;
        this.name = name;
    }

    @Override
    public void send(String message) {
        System.out.println(name + " is sending message: " + message);
        chatRoom.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received message: " + message);
    }
}

    // Usage
public class Main{
    public static void main(String[] args) {
        ChatRoomMediator chatRoom = new ChatRoom();
        User user1 = new ChatUser(chatRoom, "John");
        User user2 = new ChatUser(chatRoom, "Mary");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        user1.send("Hi Mary!");
        user2.send("Hello John!");
    }
}
```

In this example, the ChatRoom object acts as a mediator between the ChatUser objects. The ChatUser objects send messages to the ChatRoom object, which broadcasts the messages to all the other ChatUser objects. The ChatUser objects do not have any knowledge of each other, and they only communicate with the ChatRoom object through the mediator interface.