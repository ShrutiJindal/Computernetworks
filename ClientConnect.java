import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientConnect implements Runnable {
	
	private String serverName;
	private int serverPort;
	
	public ClientConnect(String serverName, int serverPort, TCPConnect myConnection) 
	{
		this.serverName = serverName;
		this.serverPort = serverPort;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	      try {
	         System.out.println("Connecting to " + serverName + " on port " + serverPort);
			 Socket client = new Socket(serverName, serverPort);
	         
	         System.out.println("Just connected to " + client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         
	         out.writeUTF("Hello from " + client.getLocalSocketAddress());
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in = new DataInputStream(inFromServer);
	         
	         System.out.println("Server says " + in.readUTF());
	         client.close();
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
	}

}
