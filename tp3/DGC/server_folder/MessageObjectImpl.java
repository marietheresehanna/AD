import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageObjectImpl extends UnicastRemoteObject implements MessageObject, Serializable {
    private static final long serialVersionUID = 1L;
    private final int classNumber;
    private final int objectNumber;

    public MessageObjectImpl(int classNumber, int objectNumber) throws RemoteException {
        super(); // Ensure RMI setup
        this.classNumber = classNumber;
        this.objectNumber = objectNumber;
    }

    @Override
    public int getNumberFromObject() throws RemoteException {
        return objectNumber;
    }

    @Override
    public int getNumberFromClass() throws RemoteException {
        return classNumber;
    }

    @Override
    public String toString() {
        return "MessageObject: Class Number is #" + classNumber + " Object Number is #" + objectNumber;
    }
}
