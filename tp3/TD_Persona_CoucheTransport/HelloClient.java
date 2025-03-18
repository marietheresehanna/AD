
import java.rmi.*;
import java.rmi.registry.*;


public class HelloClient {

    public static void main(String args[]) {

	
        try {
	    Registry registry = LocateRegistry.getRegistry(2002);
            Hello obj = (Hello) registry.lookup("Hello");
            String message = obj.sayHello();
            System.out.println(message);

        } catch (Exception e) {
	    System.out.println("HelloClient exception: " +
                               e.getMessage());
            e.printStackTrace();
        }
    }

}
