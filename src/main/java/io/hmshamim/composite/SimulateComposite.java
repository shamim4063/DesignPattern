package io.hmshamim.composite;

public class SimulateComposite {
    /*
    * To simulate that we can imagine different types of shape class like square, circle etc.
    * We may need to render an individual shape (Square/Circle) or a group of shapes or a group of some shape groups,
    * then we can do that following way by using the composite pattern. */
    public static void simulate(){
        var group1 = new Group(); //Square Group. can have one or more square shape in this group.
        group1.add(new Shape()); //Shape is basic element of our hierarchy
        group1.add(new Shape());

        var group2  = new Group(); //Circle Group
        group2.add(new Shape());
        group2.add(new Shape());

        var group = new Group(); //Group of groups.
        group.add(group1);
        group.add(group2);

        group.render();
    }
}
