package io.hmshamim.observer.pullstyle;

public class ObserverPullStyleAction {
    public static void printResult(){
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
