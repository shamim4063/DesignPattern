package io.hmshamim.observer;

public class ObserverSimulation {
    public static void simulate(){
        var dataSource = new DataSource();
         var sheet1 = new SpreadSheet();
         var sheet2 = new SpreadSheet();
         var chart = new Chart();

         dataSource.addObserver(sheet1);
         dataSource.addObserver(sheet2);
         dataSource.addObserver(chart);

         dataSource.setValue(1);
    }
}
