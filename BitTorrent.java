import java.io.IOException;
import java.util.Map;

public class BitTorrent {

	/**
	 * @param args
	 */
	
	//Passing the peerId as argument
	//Reading Config files
	// Initiating the TCP Connection
	public static void main(String []args) throws IOException, InterruptedException 
	{
		Integer myPeerID = Integer.parseInt(args[0]);
		Peer p = new Peer();
		ReadConfig commonConfig = p.getCommonInfo("Common.cfg");
		Map<Integer,ReadConfig> peer_map = p.getPeerInfo("PeerInfo.cfg");
		System.out.println("Setting up peer");
		if(peer_map.containsKey(myPeerID))
		{
			Thread serverThread = new Thread(new ServerConnect(commonConfig, peer_map, myPeerID));
			serverThread.start();
			for(Integer a : peer_map.keySet())
			{
				if(a < myPeerID)
				{
					System.out.println("Creating a client for " + myPeerID);

					ClientConnect newClient = new ClientConnect(peer_map.get(a).getHostName(),
							peer_map.get(a).getListeningPort(), myPeerID);
					//just one connection , pass connection object instead of myPerrid to connect to all

				}
			}
		}	
		else
			System.out.println("Peer Id doesn't exist");
		
		
	}

}
