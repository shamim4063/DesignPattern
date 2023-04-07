package io.hmshamim.chainOfresponsibility;

public class ChainOfResponsibilitySimulation {
    public static void simulate(){
        Handler juniorLoanOfficer = new JuniorLoanOfficer();
        Handler seniorLoanOfficer = new SeniorLoanOfficer();
        Handler loanManager = new LoanManager();

        juniorLoanOfficer.setSuccessor(seniorLoanOfficer);
        seniorLoanOfficer.setSuccessor(loanManager);


        // Generate and process requests
        CustomerRequest request1 = new CustomerRequest("John", 100000);
        juniorLoanOfficer.handleRequest(request1);

        CustomerRequest request2 = new CustomerRequest("Jane", 1000000);
        juniorLoanOfficer.handleRequest(request2);

        CustomerRequest request3 = new CustomerRequest("Bob", 100000000);
        juniorLoanOfficer.handleRequest(request3);
    }
}
