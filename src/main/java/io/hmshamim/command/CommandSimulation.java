package io.hmshamim.command;

import io.hmshamim.command.fx.Button;

public class CommandSimulation {
    public static void simulate(){
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();
    }
}
