package io.hmshamim.state;

public class StateAction {
    public static void printResult(){

        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();


        canvas.setCurrentTool(new BrushTool());
        canvas.mouseUp();
        canvas.mouseDown();
    }
}
