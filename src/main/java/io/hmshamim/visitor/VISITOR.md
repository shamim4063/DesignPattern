# The Visitor Pattern

![tools](https://user-images.githubusercontent.com/20413644/230711531-fbcd2160-6046-4c8c-89f9-f1dacacc1a54.jpeg)

The Visitor pattern is a behavioral design pattern that allows you to separate the algorithm from the object structure on which it operates. It lets you define a new operation without changing the classes of the elements on which it operates.

In the Visitor pattern, you define a separate class (the Visitor) that visits the nodes of the object structure, performing operations on those nodes. The object structure classes (the Elements) then accept a Visitor object, which calls back to the appropriate methods on the Visitor to perform the operation.

### The key components of the Visitor pattern are:

**Visitor:** defines the interface for the operations that can be performed on the Elements.</br>
**ConcreteVisitor:** implements the operations defined in the Visitor interface. </br>
**Element:** defines the interface for accepting a Visitor object.</br>
**ConcreteElement:** implements the Element interface, and provides an implementation for accepting a Visitor object.</br>
**ObjectStructure:** represents the object structure on which the Visitor operates.

### Problem

![best-open-source-wysiwyg-editors](https://user-images.githubusercontent.com/20413644/230711654-38782b73-d63e-48cc-9921-3afe3f6e5cd2.jpeg)

Let us consider the development of HTML Document editor application, where we have different HTML elements like Head element, Anchor Element etc. In the editor we perform different operations like highlighting the nodes and extracting plain text from those nodes.
This system can be developed in a straightforward manner in following way:

```java
public interface HtmlNode {
    void highlight();
}


public class HeadingNode implements HtmlNode{
    @Override
    public void highlight() {
        System.out.println("Highlight Heading Node");
    }
}

public class AnchorNode implements HtmlNode{
    @Override
    public void highlight() {
        System.out.println("Highlight Anchor Node");
    }
}

public class HtmlDocument {
    private List<HtmlNode> nodes = new ArrayList<>();

    public void add(HtmlNode node){
        nodes.add(node);
    }

    public void highlight(){
        for(var node: nodes){
            node.highlight();
        }
    }
}

public class Main{
    public static void main(String[] args){
        var document = new HtmlDocument();

        document.add(new HeadingNode());
        document.add(new AnchorNode());

        document.highlight();
    }
}
```
In the above example we applied Highlighting operation on Html nodes, and it works perfectly. Consider tomorrow we need to perform another operation like extracting each node's text to convert the Html document into a plain text document. To do that we need to add another method(operation) in HtmlNode interface, and it will cause changing all classes which implemented the HtmlNode interface. This is violating the **Open Close Principle**. 

![no_change_but_children](https://user-images.githubusercontent.com/20413644/230711783-456e89f0-753f-41f2-9364-624ceae7720e.jpeg)


### Solution using Visitor Pattern
First we need the visitor (the Operation interface bellow) interface for the operations that can be performed on the HtmlNode.

We need a ConcreteVisitor class (the HighlightOperation interface bellow) implements the operations defined in the Visitor interface.

Then Element interface (the HtmlNode interface bellow) defines the interface for accepting a Visitor object.
 
Finally, AnchorNode and HeadingNode are our ConcreteElement component of visitor pattern and HtmlDocument class is the ObjectStructure.
```java
public interface Operation {
    void apply(HeadingNode heading);
    void apply(AnchorNode anchor);
}

public interface HtmlNode {
    void execute(Operation operation);
}

public class AnchorNode implements HtmlNode{
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}

public class HeadingNode implements HtmlNode{
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}

public class HighLightOperation implements Operation{
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("Highlighting heading");
    }
    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("Highlighting anchor");
    }
}

public class HtmlDocument {
    private List<HtmlNode> nodes = new ArrayList<>();

    public void add(HtmlNode node){
        nodes.add(node);
    }

    public void execute(Operation operation){
        for(var node: nodes){
            node.execute(operation);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        var document = new HtmlDocument();

        document.add(new HeadingNode());
        document.add(new AnchorNode());

        document.execute(new HighLightOperation());
    }
}

```

Now if we want to introduce another operation like PlaintextOperation we can do it simply by implementing Operation interface like bellow without modifying our current implementations.

```java
public class PlainTextOperation implements Operation{
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("Extracting Heading Node text.");
    }
    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("Extracting Anchor Node text.");
    }
}

public class Main {
    public static void main(String[] args) {
        var document = new HtmlDocument();

        document.add(new HeadingNode());
        document.add(new AnchorNode());

        document.execute(new PlainTextOperation());
    }
}
```
