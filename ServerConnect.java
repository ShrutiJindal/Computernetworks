import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerConnect implements Runnable {
	
	private ServerSocket serverSocket;
	private String myHostName;
	private int myListeningPort;
	private Map<Integer, ReadConfig> peer_map;
	private ReadConfig myCommonConfig;
	private Integer myPeerID;
	private ConcurrentHashMap<Integer, ClientConnect> clientConnections_map;
	
	public ServerConnect(ReadConfig myCommonConfig, Map<Integer, ReadConfig> peer_map, int myPeerID) throws SocketException 
	{		
		this.myListeningPort = peer_map.get(myPeerID).getListeningPort();
		this.peer_map = peer_map;
		try {
			serverSocket = new ServerSocket(myListeningPort);
			serverSocket.setSoTimeout(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.setUpConnectionWithPeers();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		 while(true) {
	         try {
	            System.out.println("Waiting for client on port " );
	               
	            Socket server = this.serverSocket.accept();
	            
	            //call message Handler 
	            
	            System.out.println("Just connected to " + server.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
	               + "\nGoodbye!");
	            server.close();
	            
	         }catch(SocketTimeoutException s) {
	            System.out.println("Socket timed out!");
	            break;
	         }catch(IOException e) {
	            e.printStackTrace();
	            break;
	         }
	      }
	}
	
	
////	public void setUpConnectionWithPeers()
////	{
////		for(Integer peer_Id : this.peer_map.keySet())
////		{
////			if(peer_Id < myPeerID)
////			{
////				System.out.println("Creating a client for " + myPeerID);
////
////				ClientConnect newClient = new ClientConnect(this.peer_map.get(peer_Id).getHostName(),
////															this.peer_map.get(peer_Id).getListeningPort());
////				MessageType aMessageHandler = new MessageType(newClient, this);
////				(new Thread(aMessageHandler)).start();
//////				 this.peerConnectionMap.put(peer_Id, newClient);
////			}
////		}
//	}
//	
//	public void sendData(int peer_Id, byte[] data)
//	{
//		if(clientConnections_map.containsKey(peer_Id))
//		{
//			ClientConnect client_obj = clientConnections_map.get(peer_Id);
//			ClientConnect.sendDataToClient(data);
//		}
//			
//	}
}
