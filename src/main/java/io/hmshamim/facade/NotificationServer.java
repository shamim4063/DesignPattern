package io.hmshamim.facade;

public class NotificationServer {
      public Connection connect(String ipAddress){
          System.out.println("Server Connected");
          return new Connection();
      }

      public AuthToken authenticates(String appID, String key){
          System.out.println("Request Authenticated");
          return new AuthToken();
      }

      public void send(AuthToken authToken, Message message, String text){
          System.out.println("Sending Message");
          System.out.println("Message Sent");
      }
}
