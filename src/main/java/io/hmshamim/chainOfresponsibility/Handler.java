package io.hmshamim.chainOfresponsibility;

public abstract class Handler {
    protected Handler successor;
    public void setSuccessor(Handler successor){
        this.successor = successor;
    }
    public abstract void handleRequest(CustomerRequest request);
}
