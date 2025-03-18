
import java.rmi.*;

public interface Hello extends java.rmi.Remote
{
   public String        sayHello()         throws RemoteException;

   public MessageObject getMessageObject() throws RemoteException;

}
