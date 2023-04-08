package io.hmshamim.chainOfresponsibility;

public class JuniorLoanOfficer extends Handler{

    @Override
    public void handleRequest(CustomerRequest request) {
        if(request.getAmount()<=1000){
            System.out.println("Junior Loan officer approved the requested loan for "+ request.getName());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
