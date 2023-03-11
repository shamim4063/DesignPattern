package io.hmshamim.command;

import io.hmshamim.command.fx.Button;

public class CommandAction {
    public static void printResult(){
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();
    }
}
