import java.io.*;
import java.rmi.*;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            MessageObject message = (MessageObject) Naming.lookup("rmi://localhost:1099/MessageObject");

            // Display results
            System.out.println("Received: " + message);
            System.out.println("Class Number: " + message.getNumberFromClass());
            System.out.println("Object Number: " + message.getNumberFromObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
