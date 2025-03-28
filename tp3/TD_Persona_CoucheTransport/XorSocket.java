
import java.io.*;
import java.net.*;

class XorSocket extends Socket {
  
    /*
     * The pattern used to "encrypt" and "decrypt" each byte sent
     * or received by the socket.
     */
    private final byte pattern;
  
    /* The InputStream used by the socket. */
    private InputStream in = null;
  
    /* The OutputStream used by the socket */
    private OutputStream out = null;
  
    /* 
     * Constructor for class XorSocket. 
     */
    public XorSocket(byte pattern)
        throws IOException 
    {
        super();
        this.pattern = pattern;
    }
  
    /* 
     * Constructor for class XorSocket. 
     */
    public XorSocket(String host, int port, byte pattern)
        throws IOException
    {
        super(host, port);
        this.pattern = pattern;
    }
  
    /* 
     * Returns a stream of type XorInputStream. 
     */
    public synchronized InputStream getInputStream() throws IOException {
        if (in == null) {
            in = new XorInputStream(super.getInputStream(), pattern);
        }
        return in;
    }
  
    /* 
     *Returns a stream of type XorOutputStream. 
     */
    public synchronized OutputStream getOutputStream() throws IOException {
        if (out == null) {
            out = new XorOutputStream(super.getOutputStream(), pattern);
        }
        return out;
    }
}
