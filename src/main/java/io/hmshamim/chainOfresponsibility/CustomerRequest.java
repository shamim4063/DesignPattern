package io.hmshamim.chainOfresponsibility;

public class CustomerRequest {
    public String name;
    public double amount;

    public CustomerRequest(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}
