# Momento Pattern 
The Memento design pattern is a behavioral pattern that allows an object to capture its internal state 
at a specific moment and save it externally so that 
the object can be restored to that state later. 
The Memento pattern is used to implement undo/redo operations, 
or to provide a way to roll back to a previous state of an object.


## Here are some key characteristics of the Memento pattern:
- Originator class: The Originator class is the object whose state needs to be saved and restored.
- Memento class: The Memento class represents the saved state of the Originator object.
- Caretaker class: The Caretaker class is responsible for storing and restoring the Memento.

## Example:
```
class Originator {
  private String state;

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public Memento save() {
    return new Memento(state);
  }

  public void restore(Memento m) {
    state = m.getState();
  }
}

class Memento {
  private String state;

  public Memento(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }
}

class Caretaker {
  private List<Memento> mementos = new ArrayList<>();

  public void addMemento(Memento m) {
    mementos.add(m);
  }

  public Memento getMemento(int index) {
    return mementos.get(index);
  }
}
```

In this example, the Originator class is responsible for the object's internal state, which can be saved and restored using the Memento and Caretaker classes.
The Originator class has a setState() method to set the state, a getState() method to get the state,
and a save() method to create a Memento object that represents the saved state.
The Memento class stores the saved state of the Originator object, and the Caretaker class stores a list of Memento objects.
The addMemento() method adds a Memento to the list, and the getMemento() method retrieves a Memento from the list.
The restore() method of the Originator class restores the state from a Memento object.
The Memento pattern allows an object to be restored to a previous state by retrieving the appropriate Memento 
object from the Caretaker and restoring its state in the Originator.


