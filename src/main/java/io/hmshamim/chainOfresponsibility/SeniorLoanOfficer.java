package io.hmshamim.chainOfresponsibility;

public class SeniorLoanOfficer extends Handler{
    @Override
    public void handleRequest(CustomerRequest request) {
        if(request.getAmount()>1000 && request.getAmount()< 5000){
            System.out.println("Senior Loan officer have approved requested loan for "+ request.getName());
        }else if(successor !=null){
            successor.handleRequest(request);
        }
    }
}
