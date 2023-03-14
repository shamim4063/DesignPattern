package io.hmshamim.momento;

public class MomentoSimulation {
    public static void simulate(){
        /*
         * Editor class is our originator whose state needs to be saved.
         * And History is the Caretaker which will store and restore the state.
         * Let's set "a" as first content of Editor class and also save it's state by using push method of history object.
         * same way "b" and "c"
         */
        var editor = new Editor();
        var history = new Hisotry();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        /*
         * After setting "c", now we will restore it's previous state by pop method of history object.
         * now it should set "b" as current content of Editor.
         */
        editor.restoreState(history.pop());

        /*
         * It's should now print "b" as it's current content*/
        System.out.println(editor.getContent());
    }
}
