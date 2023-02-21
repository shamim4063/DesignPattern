# Iterator Pattern
The Iterator pattern is a behavioral pattern that provides a way to access the elements of an aggregate object (such as a collection) sequentially without exposing the underlying representation of the object. It allows you to traverse the collection without having to know its internal structure and provides a consistent interface for iterating over different types of collections.


### The Iterator pattern typically includes the following components:
- **Iterator:** An interface that defines the methods for accessing and traversing the elements of a collection.
- **Concrete Iterator:** An implementation of the Iterator interface for a specific collection. It keeps track of the current position in the collection and provides the methods for accessing the current and next elements. 
- **Aggregate:** An interface that defines the methods for creating an Iterator object. 
- **Concrete Aggregate:** An implementation of the Aggregate interface that creates an Iterator object for a specific collection.

### Here is an example of the Iterator pattern in Java:

```java
interface Iterator {
    boolean hasNext();
    Object next();
}

interface Aggregate {
    Iterator createIterator();
}

class ConcreteIterator implements Iterator {
    private String[] elements;
    private int position = 0;

    public ConcreteIterator(String[] elements) {
        this.elements = elements;
    }

    public boolean hasNext() {
        return position < elements.length;
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String element = elements[position];
        position++;
        return element;
    }
}

class ConcreteAggregate implements Aggregate {
    private String[] elements;

    public ConcreteAggregate(String[] elements) {
        this.elements = elements;
    }

    public Iterator createIterator() {
        return new ConcreteIterator(elements);
    }
}

public class Client {
    public static void main(String[] args) {
    ConcreteAggregate aggregate = new ConcreteAggregate(new String[]{"A", "B", "C"});
    Iterator iterator = aggregate.createIterator();
    
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
}
```


In this example, the Iterator interface defines the methods for accessing and traversing the elements of a collection. The ConcreteIterator class implements this interface and provides the methods for accessing the current and next elements of a specific collection (in this case, an array of strings).

The Aggregate interface defines the method for creating an Iterator object. The ConcreteAggregate class implements this interface and creates a ConcreteIterator object for a specific collection (in this case, the same array of strings).

Finally, the Client class creates a ConcreteAggregate object and uses it to create an Iterator object. It then uses the Iterator object to traverse the elements of the collection and print them to the console.

The Iterator pattern is useful when you want to iterate over the elements of a collection without having to know its internal structure, or when you want to provide a consistent interface for iterating over different types of collections.