import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloImpl extends UnicastRemoteObject implements Hello {

	protected HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello() throws RemoteException {
		return "Hello, RMI World!";
	}

	public static void main(String[] args) {
		try {
			// Create and export the remote object
			HelloImpl obj = new HelloImpl();

			// Get or create the RMI registry
			Registry registry;
			try {
				registry = LocateRegistry.getRegistry(2002);
				registry.list();
			} catch (RemoteException e) {
				System.out.println("RMI registry not found. Creating a new one...");
				registry = LocateRegistry.createRegistry(2002);
			}

			// Unbind if already bound
			try {
				registry.unbind("Hello");
				System.out.println("Existing binding removed.");
			} catch (NotBoundException e) {
				System.out.println("No existing binding found. Proceeding to bind.");
			}

			// Bind the object
			registry.rebind("Hello", obj);
			System.out.println("HelloImpl bound and ready!");

		} catch (Exception e) {
			System.err.println("HelloServer exception: " + e);
			e.printStackTrace();
		}
	}
}
