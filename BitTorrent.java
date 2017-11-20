import java.io.IOException;
import java.util.Map;

public class BitTorrent {

	/**
	 * @param args
	 */
	
	//Passing the perrId as argument
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
		}	
		else
			System.out.println("Peer Id doesn't exist");
		
	}

}
