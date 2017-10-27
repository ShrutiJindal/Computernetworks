import java.io.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TCPConnect {
	
	private String myHostName;
	private int myListeningPort;
	private Map<Integer, ReadConfig> peer_map;
	private ReadConfig myCommonConfig;
	private Integer myPeerID;

	
	public TCPConnect(ReadConfig myCommonConfig, Map<Integer, ReadConfig> peer_map, int myPeerID) 
	{
		this.myHostName = peer_map.get(myPeerID).getHostName();
		this.myListeningPort = peer_map.get(myPeerID).getListeningPort();
		this.myPeerID = myPeerID;
		this.peer_map = peer_map;
		this.openConnection();
	}
	
	public void openConnection()
	{
		Thread serverThread = new Thread(new ServerConnect(myHostName, myListeningPort, this));
		serverThread.start();
//		this.myBitMap = new BitMap(myPeerID, myCommonConfig, peer_map.keySet(), this.peer_map.get(myPeerID).hasCompleteFile(), this,this.peer_map);

		this.setUpConnectionWithPeers();
		
	}
	
	public void setUpConnectionWithPeers()
	{
		for(Integer peer_Id : this.peer_map.keySet())
		{
			if(peer_Id < myPeerID)
			{
				System.out.println("Creating a client for " + myPeerID);

				ClientConnect newClient = new ClientConnect(this.peer_map.get(peer_Id).getHostName(),
															this.peer_map.get(peer_Id).getListeningPort(), this);
				MessageType aMessageHandler = new MessageType(newClient, this);
				(new Thread(aMessageHandler)).start();
//				 this.peerConnectionMap.put(peer_Id, newClient);
			}
		}
	}

}
