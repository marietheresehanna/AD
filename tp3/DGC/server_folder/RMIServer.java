import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class RMIServer {
   public static void main(String[] args) {
      try {
         // Create and export the remote object
         MessageObjectImpl message = new MessageObjectImpl(2995, 2994);

         // Serialize the object to a file
         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MessageObjectSer.ser"))) {
            oos.writeObject(message);
            System.out.println("Server: Object serialized and written to file.");
         }

         // Bind the object to the RMI registry
         Registry registry = LocateRegistry.createRegistry(1099);
         registry.rebind("MessageObject", message);

         System.out.println("Server: Ready.");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
