
import java.io.*;
import java.net.*;
import java.rmi.server.*;

public class XorClientSocketFactory
    implements RMIClientSocketFactory, Serializable {

    private final byte pattern;

    public XorClientSocketFactory(byte pattern) {
	this.pattern = pattern;
    }
    
    public Socket createSocket(String host, int port)
	throws IOException
    {
	return new XorSocket(host, port, pattern);  //iciiiiiiiii
    }

    public int hashCode() {
	return (int) pattern;
    }

    public boolean equals(Object obj) {
	return (getClass() == obj.getClass() &&
		pattern == ((XorClientSocketFactory) obj).pattern);
    }

}

