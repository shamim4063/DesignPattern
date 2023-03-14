package io.hmshamim.template;

public class TemplateSimulation {
    public static void simulate(){
        var moneyTransfer = new TransferMoneyTask();
        moneyTransfer.execute();
    }
}
