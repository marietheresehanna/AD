
import java.util.Date;
import java.net.MalformedURLException;

import java.rmi.*;

/**
 * RMIClient will make a request for the remote "HelloService" service.
 *
 * A lot of requests are made, forcing activity by both the
 * Distributed Garbage Collector and the local GCs.
 *
 */

public class RMIClient
{
   private static final int    PORT        = 2018;

//
// -> Change the name to your own computer name
//
   private static final String HOST_NAME   = "localhost";


   // Instance of ourselves
   private static RMIClient  rmi;

   public static void main ( String[] args )
   {
      rmi = new RMIClient();
   }  // main


   // Constructor
   public RMIClient()
   {

      try
      {
         Hello hello = (Hello)Naming.lookup( "//" + HOST_NAME + ":" + Integer.toString( PORT ) + "/" + "Hello" );

         System.out.println( "HelloService lookup successful" );

         System.out.println( "Message from Server: " + hello.sayHello() );

         MessageObject mo;

         for ( int i = 0; i< 1000; i++ )
         {
            mo = hello.getMessageObject();
System.out.println( "MessageObject: Class Number is #" + mo.getNumberFromClass() + " Object Number is #" +  mo.getNumberFromObject() );
            mo = null;
         }

      }
      catch ( java.rmi.UnknownHostException uhe )
      {
         System.out.println( "The host computer name you have specified, " + HOST_NAME + " does not match your real computer name." );
      }
      catch ( RemoteException re )
      {
         System.out.println( "A Remote Exception was thrown when requesting the TimeService" );
         System.out.println( "" + re );
      }
      catch ( MalformedURLException mURLe )
      {
         System.out.println( "There is a problem with the rmi: URL you are using" );
         System.out.println( "" + mURLe );
      }
      catch ( NotBoundException nbe )
      {
         System.out.println( "" + nbe );
      }
   }

}  // class RMIClient

