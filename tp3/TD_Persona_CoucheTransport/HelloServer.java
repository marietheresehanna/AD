import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class HelloServer {

    public static void main(String[] args) {
        try {
            // Create registry if not already running
            Registry registry;
            try {
                registry = LocateRegistry.getRegistry(2002);
                registry.list();  // Test connection
            } catch (RemoteException e) {
                System.out.println("RMI registry not found. Creating a new one...");
                registry = LocateRegistry.createRegistry(2002);
            }

            // Unbind previous instance if exists
            try {
                registry.unbind("Hello");
                System.out.println("Removed previous binding.");
            } catch (NotBoundException e) {
                System.out.println("No previous binding found.");
            }

            // Create and bind the HelloImpl object
            HelloImpl obj = new HelloImpl();  // Automatically exported
            registry.rebind("Hello", obj);    // Bind without manual export

            System.out.println("HelloServer is ready.");
        } catch (Exception e) {
            System.err.println("HelloServer exception: " + e);
            e.printStackTrace();
        }
    }
}
