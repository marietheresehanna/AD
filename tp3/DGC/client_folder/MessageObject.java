import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageObject extends Remote, Serializable {
    int getNumberFromClass() throws RemoteException;
    int getNumberFromObject() throws RemoteException;
}
