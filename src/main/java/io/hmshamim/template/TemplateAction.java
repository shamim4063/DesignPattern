package io.hmshamim.template;

public class TemplateAction {
    public static void printResult(){
        var moneyTransfer = new TransferMoneyTask();
        moneyTransfer.execute();
    }
}
