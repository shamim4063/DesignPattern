package io.hmshamim.iterator;

public class IteratorSimulation {
    public static void simulate(){
        /*
        * Here BrowserHistory has List of String. It could be a any other type of collection like List of Object,
        * Array of String or Array of Object( If we need any fixed sized collection)
        * based on client requirement.
        * It might be possible they can change their mind frequently. So we will have to modify the BrowserHistory
        * class first and all the places where it has been implemented (Where we traverse the collection like following codes).
        * Our goal is to, we will change only the internal definition of BrowserHistory but it's implementations.
        *
        * For that we need an interface which will need some traverse methods like hasNext, next, current etc.
        * Here Iterator interface will provide those behaviors.
        *
        * Here in the BrowserHistory class, ListIterator class is an inner class as well as a Concrete class of Iterator
        * interface.
        * and createIterator method inside BrowserHistory create and provides the iterator object.
        *
        *
        * That means, by this mechanism we are getting way of accessing elements of an object without exposing its
        * underlying representation.
        * */
        var history = new BrowserHistory();
        history.push("a");
        history.push("b");
        history.push("c");

        var iterator = history.createIterator();
        while (iterator.hasNext()){
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        }
    }
}
