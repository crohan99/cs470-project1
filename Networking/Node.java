package Networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Client information of a single client
 * @author Carson Rohan, Lucas Steffens
 * @version 3-16-2021
 */

public class Node
{
    // set time to live to 30000ms or 30s for all objects
    private static final int TTL = 30000;
    private static final int defaultPort = 25565;

    private final InetAddress IP;
    private final int port;
    private Date lastSeen;


    public Node(InetAddress IP, int port)
    {
        this.IP = IP;
        this.port = port;
        this.lastSeen = new Date(System.currentTimeMillis());
    }

    public Node(String IP, int port) throws UnknownHostException
    {
        this.IP = InetAddress.getByName(IP);
        this.port = port;
        this.lastSeen = new Date(System.currentTimeMillis());
    }

    public Node(String IP) throws UnknownHostException
    {
        this.IP = InetAddress.getByName(IP);
        this.port = defaultPort;
        this.lastSeen = new Date(System.currentTimeMillis());
    }

    public InetAddress getIP()
    {
        return this.IP;
    }

    public int getPort()
    {
        return this.port;
    }

    public Date getLastSeen()
    {
        return this.lastSeen;
    }

    public void setLastSeen() {this.lastSeen = new Date(System.currentTimeMillis());}

    /**
     * Determine if the client is dead by checking if it has been greater than
     * 30 seconds since we've last seen this client
     * @return true if client is dead, false if otherwise
     */
    public boolean isDead()
    {
        Date currentTime = new Date(System.currentTimeMillis());
        return currentTime.getTime() - lastSeen.getTime() > TTL;
    }

    /**
     * String representation of a client
     * @return string representation of a client
     */
    public String toString()
    {
        return "Client IP: " + this.IP + "\n" + "Client port: " + this.port + "\n";
    }

}
