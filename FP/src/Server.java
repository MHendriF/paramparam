import java.io.*;
import java.net.*;
 
public class Server
{
    //final static String INET_ADDR = "224.0.0.3";
    public static void main(String args[]) throws UnknownHostException
    {
        DatagramSocket sock = null;
        String [][] Database = new String [10][10];
//        InetAddress addr = InetAddress.getByName("localhost");
        //InetAddress host = InetAddress.getByName("localhost");
        
        int i = 0, j = 0;
        try
        {
            //1. creating a server socket, parameter is local port number
            sock = new DatagramSocket(7777);
             
            //buffer to receive incoming data
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
             
            InetAddress IPAddress = incoming.getAddress();
            //2. Wait for an incoming data
            echo("Server socket created. Waiting for incoming data...");
             
            //communication loop
            while(true)
            {
                sock.receive(incoming);
                byte[] data = incoming.getData();
                String s = new String(data, 0, incoming.getLength());
                String[] words = s.split("#");
                
                if(Database[i][j] == null && i == 0 && j == 0)
                {
                    Database[i][j] = words[0];
                    Database[i][j+1] = words[1]; 
                    //echo("nilai i: "+i+" masuk");
                    echo("i: "+i);
                    echo("user: "+words[0]+" "+"score: "+words[1]);
                }
                    
                else if(Database[i][j] != null){
                    while(Database[i][j]!=null){
                      i++;  
                    }
                    Database[i][j] = words[0];
                    Database[i][j+1] = words[1]; 
                    //echo("nilai i: "+i+" ok");
                    echo("i: "+i);
                    echo("user: "+words[0]+" "+"score: "+words[1]);
                }
                //edit
                
                //echo the details of incoming data - client ip : client port - client message
                echo(incoming.getAddress().getHostAddress() + " : " + incoming.getPort() + " - " + s);
                 
                s = "OK : " + s;
                DatagramPacket dp = new DatagramPacket(s.getBytes() , s.getBytes().length , incoming.getAddress() , incoming.getPort());
                sock.send(dp);
            }
        }
         
        catch(IOException e)
        {
            System.err.println("IOException " + e);
        }
    }
     
    //simple function to echo data to terminal
    public static void echo(String msg)
    {
        System.out.println(msg);
    }
}
