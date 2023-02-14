package io.hmshamim;

import io.hmshamim.momento.Editor;
import io.hmshamim.momento.Hisotry;

public class Main {
    public static void main(String[] args) {

        //Momento In Action
        var editor = new Editor();
        var hisotry = new Hisotry();

        editor.setContent("a");
        hisotry.push(editor.createState());

        editor.setContent("b");
        hisotry.push(editor.createState());

        editor.setContent("c");
        editor.restoreState(hisotry.pop());
        editor.restoreState(hisotry.pop());

        System.out.println(editor.getContent());
    }
}