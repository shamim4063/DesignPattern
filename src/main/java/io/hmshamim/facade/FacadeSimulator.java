package io.hmshamim.facade;

public class FacadeSimulator {
    public static void simulate(){
        var service = new NotificationService();
        service.send("Hello World",  "target");
    }
}
