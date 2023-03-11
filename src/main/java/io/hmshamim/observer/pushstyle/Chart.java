package io.hmshamim.observer.pushstyle;

public class Chart implements Observer {
    @Override
    public void update(int value) {
        System.out.println("Chart got notified with "+ value);
    }
}
