import java.io.*;
import java.util.*;

public class Peer {
	
	/**
	 * @param file_name
	 * @return
	 */
	
	// Read Common.cong file to retrieve values
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
					
					System.out.println(split_line);
					
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
	
	/**
	 * @param file_name
	 * @return
	 */
	public Map<Integer, ReadConfig> getPeerInfo(String file_name)
	{
		String line;
		Map<Integer, ReadConfig> peer_map = new HashMap<Integer, ReadConfig>();
		ReadConfig peerConfigObj = null;
		boolean T = true, F = false; 
		System.out.println(file_name);
		try {
				BufferedReader in = new BufferedReader(new FileReader(file_name));
				while((line = in.readLine())!=null)
				{
					String[] split_line = line.split(" ");
					System.out.println(split_line[0]);
					System.out.println(split_line[1]);
					peerConfigObj = new ReadConfig(split_line[1], Integer.parseInt(split_line[2]), ((Integer.parseInt(split_line[3])==1) ? T : F));
					peer_map.put(Integer.parseInt(split_line[0]), peerConfigObj);
					System.out.println("Reading PeerInfo file");
				}
				in.close();		
		}
		catch(Exception e)
		{
			System.out.println("Error reading Peer config file");
		}	
		return peer_map;	
	}
	
}
