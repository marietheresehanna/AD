
import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject 
implements Hello, Unreferenced
{

   public HelloImpl() throws RemoteException
   {
      super();
   }

   public String sayHello() throws RemoteException
   {
     return "Hello!";

   }

   public MessageObject getMessageObject() throws RemoteException
   {
      MessageObject mo = new MessageObjectImpl();

      return mo;
   }

   public void unreferenced()
   {
      System.out.println( "HelloImpl: Unreferenced" );
   }

   public void finalize() throws Throwable
   {
      super.finalize();

      System.out.println( "HelloImpl: Finalize called" );
   }
}
