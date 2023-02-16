package io.hmshamim.state;

public class StateAction {
    public static void printResult(){
        /*
        * Here Canvas is the object which should behave different based on its internal state (currentTool).
        * If currentTool is the SelectionTool object then mouseDown and mouseUp of canvas method should draw a rectangle.
        * and the same way will draw a line if currentTool of canvas takes BrushTool.
        * In this pattern we are applying Polymorphism features of OOP in Canvas class. It is sometime behaving like a
        * SelectionTool and sometime BrushTool without using any if/else condition.
        * and in future if any new tools get introduce we will just create a new class and implement Tools interface.
        */
        var canvas = new Canvas();

        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();


        canvas.setCurrentTool(new BrushTool());
        canvas.mouseUp();
        canvas.mouseDown();
    }


}
