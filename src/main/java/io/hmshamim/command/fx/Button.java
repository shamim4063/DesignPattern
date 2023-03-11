package io.hmshamim.command.fx;

public class Button {
    private String label;
    private Command command;
    public Button(Command command){
        this.command = command;
    }

    public void click(){
        this.command.execute();
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
