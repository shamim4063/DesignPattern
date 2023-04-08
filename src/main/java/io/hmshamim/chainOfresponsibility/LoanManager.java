package io.hmshamim.chainOfresponsibility;

public class LoanManager extends Handler{
    @Override
    public void handleRequest(CustomerRequest request) {
        if(request.getAmount()> 5000){
            System.out.println("Loan Manager have approved requested amount for "+ request.getName());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
