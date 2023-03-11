package io.hmshamim.observer.pullstyle;

public class Chart implements Observer {
    private DataSource dataSource;

    public Chart(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Chart got notified with "+ dataSource.getValue());
    }
}
