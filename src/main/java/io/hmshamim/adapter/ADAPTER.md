# Adapter Pattern
Adapter design pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces and allows them to collaborate. In other words, an adapter is a wrapper class that is used to convert one interface into another interface that the client is expecting.

![maxresdefault](https://user-images.githubusercontent.com/20413644/235412864-d0f4c333-8987-4f73-a66d-a2e474a63b28.jpeg)


**The adapter pattern consists of three main components:**

**Target Interface:** This is the interface that is expected by the client code.<br>
**Adaptee:** This is the interface that needs to be adapted to the target interface.<br>
**Adapter:** This is the class that implements the Target Interface and wraps the Adaptee object to translate its methods into the ones expected by the client.<br>


**Here's an example of adapter pattern in Java:**

Suppose we have a third-party library that provides a class called Rectangle that represents a rectangle using width and height. However, we need to use this rectangle in our code, which expects an interface called Shape that has a method draw(). To make this work, we can create an adapter that implements the Shape interface and wraps the Rectangle object.



```java
// Adaptee
class Rectangle {
    public void drawRectangle(int width, int height) {
        System.out.println("Rectangle drawn with width " + width + " and height " + height);
    }
}

// Target Interface
interface Shape {
    void draw();
}

// Adapter
class RectangleAdapter implements Shape {
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw() {
        int width = 10;
        int height = 20;
        rectangle.drawRectangle(width, height);
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Shape shape = new RectangleAdapter(rectangle);
        shape.draw();
    }
}

```


In this example, we have an Adaptee class Rectangle that draws a rectangle. We also have a Target Interface called Shape that has a draw() method. Finally, we have an Adapter class RectangleAdapter that implements the Shape interface and wraps the Rectangle object. The client code then creates an instance of RectangleAdapter and calls the draw() method, which in turn calls the drawRectangle() method of the Rectangle object via the adapter.
