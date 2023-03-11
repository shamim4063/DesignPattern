package io.hmshamim.observer.pushstyle;

public class SpreadSheet implements Observer {
    @Override
    public void update(int value) {
        System.out.println("Spreadsheet got notified with "+ value);
    }
}
