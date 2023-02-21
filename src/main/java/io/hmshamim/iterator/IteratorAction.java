package io.hmshamim.iterator;

public class IteratorAction {
    public static void printResult(){
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
