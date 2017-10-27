import java.io.*;
import java.util.*;

public class Peer {
	
	public ReadConfig getCommonInfo(String file_name)
	{
		String line;
		ReadConfig commonConfigObj = null;
		ArrayList<String> line_list = new ArrayList<String>(); 
		try {
				BufferedReader in = new BufferedReader(new FileReader(file_name));
				while((line = in.readLine())!=null)
				{
					String[] split_line = line.split(" ");
					line_list.add(split_line[1]);
				}
				in.close();
				commonConfigObj = new ReadConfig(Integer.parseInt(line_list.get(0)), 
												 Integer.parseInt(line_list.get(1)), 
									 			 Integer.parseInt(line_list.get(2)), 
									 			 line_list.get(3), 
									 			 Integer.parseInt(line_list.get(4)),
									 			 Integer.parseInt(line_list.get(5)));
				
		}
		catch(Exception e)
		{
			System.out.println("Error reading Common congif file");
		}
		return commonConfigObj;		
	}
	
	public Map<Integer, ReadConfig> getPeerInfo(String file_name)
	{
		String line;
		Map<Integer, ReadConfig> peer_map = new HashMap<Integer, ReadConfig>();
		ReadConfig peerConfigObj = null;
		boolean T = true, F = false; 
		try {
				BufferedReader in = new BufferedReader(new FileReader(file_name));
				while((line = in.readLine())!=null)
				{
					String[] split_line = line.split(" ");
					peerConfigObj = new ReadConfig(split_line[1],Integer.parseInt(split_line[1]),((Integer.parseInt(split_line[1])==1) ? T : F));
					peer_map.put(Integer.parseInt(split_line[0]), peerConfigObj);
				}
				in.close();		
		}
		catch(Exception e)
		{
			System.out.println("Error reading Peer config file");
		}	
		return peer_map;	
	}
	
	
	public static void main(String []args) throws IOException 
	{
		Integer myPeerID = Integer.parseInt(args[0]);
		Peer p = new Peer();
		ReadConfig commonConfig = p.getCommonInfo("Common.cfg");
		Map<Integer,ReadConfig> peer_map = p.getPeerInfo("PeerInfo.cfg");
		System.out.println("Setting up peer");
		if(peer_map.containsKey(myPeerID))
			new TCPConnect(commonConfig, peer_map, myPeerID);
		else
			System.out.println("Peer Id doesn't exist");
	}
}
