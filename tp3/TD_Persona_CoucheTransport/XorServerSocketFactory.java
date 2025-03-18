
import java.io.*;
import java.net.*;
import java.rmi.server.*;

public class XorServerSocketFactory
    implements RMIServerSocketFactory {

    private final byte pattern;

    public XorServerSocketFactory(byte pattern) {
	this.pattern = pattern;
    }
    
    public ServerSocket createServerSocket(int port)
	throws IOException
    {
	return new XorServerSocket(port, pattern);
    }
    
    public int hashCode() {
	return (int) pattern;
    }

    public boolean equals(Object obj) {
	return (getClass() == obj.getClass() &&
		pattern == ((XorServerSocketFactory) obj).pattern);
    }

}
