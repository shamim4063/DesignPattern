package io.hmshamim.observer.pullstyle;

public class ObserverPullStyleSimulation {
    public static void simulate(){
        var dataSource = new DataSource();
         var sheet1 = new SpreadSheet(dataSource);
         var sheet2 = new SpreadSheet(dataSource);
         var chart = new Chart(dataSource);

         dataSource.addObserver(sheet1);
         dataSource.addObserver(sheet2);
         dataSource.addObserver(chart);

         dataSource.setValue(1);
    }
}
