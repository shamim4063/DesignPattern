# Observer Pattern
The Observer design pattern is a software design pattern that allows objects to subscribe and receive notifications from other objects (the "subject") when certain events occur. 

The pattern is used to establish a one-to-many relationship between objects, where the "one" object (the subject) keeps track of the "many" objects (the observers) and notifies them automatically of any state 
changes, without them having to constantly poll for updates.

### The key components of the Observer pattern are:

- **Subject:** The object that maintains a list of its observers and notifies them automatically of any state changes.
- **Observer:** The interface that defines the update method that the subject calls to notify its observers of any state changes.
- **ConcreteSubject:** The implementation of the subject, which maintains its state and sends notifications to its observers when the state changes.
- **ConcreteObserver:** The implementation of the observer, which registers with the subject and receives notifications when the state changes.

### In the Observer pattern, there are two common communication styles:

1. **Push Style:** In push style, the subject passes the updated data to its observers as part of the notification message. The observers receive the new data and update their own state accordingly. This style is used when the observers need to be notified of every change to the subject's state, and when the observers need to receive the new data immediately.

2. **Pull Style:** In pull style, the observers request the updated data from the subject when they need it. The subject does not send the updated data as part of the notification message, but instead waits for the observers to request it. This style is used when the observers only need to be notified of changes to the subject's state occasionally, and when the observers can afford to wait to receive the new data.

Both push and pull styles have their own advantages and disadvantages, and the choice between them depends on the specific requirements of the system being designed.

### Here is an example of the Observer pattern in Java:

```java
public interface Observer {
    void update();
}

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (var observer : observers){
            observer.update();
        }
    }

}

public class DataSource extends Subject{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}

public class SpreadSheet implements Observer{
    @Override
    public void update() {
        System.out.println("Spreadsheet got notified.");
    }
}

public class Chart implements Observer{
    @Override
    public void update() {
        System.out.println("Chart got notified.");
    }
}


public class Main {
    public static void main(String[] args){
        var dataSource = new DataSource();
        var sheet1 = new SpreadSheet();
        var sheet2 = new SpreadSheet();
        var chart = new Chart();

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);
    }
}
```

In this example, the Subject class that maintains a list of its observers and notifies them when its child DataSource class changes its data using the notifyObservers() method. The Chart and SpreadSheet class are two concrete implementation of the Observer interface, which define the update() method that is called by the subject to notify the observer of any changes. The Main class demonstrates how the subject and observers can be used together to maintain a one-to-many relationship and receive notifications of state changes.

**Example of Push Style observer**

```java 
public interface Observer {
    void update(int value);
}

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(int value){
        for (var observer : observers){
            observer.update(value);
        }
    }

}

public class DataSource extends Subject{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers(value);
    }
}

public class SpreadSheet implements Observer{
    @Override
    public void update(int value) {
        System.out.println("Spreadsheet got notified with "+ value);
    }
}

public class Chart implements Observer{
    @Override
    public void update(int value) {
        System.out.println("Chart got notified with "+ value);
    }
}


public class Main {
    public static void main(String[] args){
        var dataSource = new DataSource();
        var sheet1 = new SpreadSheet();
        var sheet2 = new SpreadSheet();
        var chart = new Chart();

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);
        dataSource.setValue(2);
    }
}
```

**Example of Pull Style observer**

```java

public interface Observer {
    void update();
}

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (var observer : observers){
            observer.update();
        }
    }

}

public class DataSource extends Subject{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}

public class SpreadSheet implements Observer{
    private DataSource dataSource;

    public SpreadSheet(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Spreadsheet got notified with "+ dataSource.getValue());
    }
}

public class Chart implements Observer{

    private DataSource dataSource;

    public Chart(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Spreadsheet got notified with "+ dataSource.getValue());
    }
}


public class Main {
    public static void main(String[] args){
        var dataSource = new DataSource();
        var sheet1 = new SpreadSheet();
        var sheet2 = new SpreadSheet();
        var chart = new Chart();

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);

        dataSource.setValue(1);
        dataSource.setValue(2);
    }
}

```