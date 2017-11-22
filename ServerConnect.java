import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* Instantiates variables */

public class ServerConnect implements Runnable {

	private ServerSocket serverSocket;

	private String myHostName;

	private int myListeningPort;

	private Map<Integer, ReadConfig> peer_map;

	private ReadConfig myCommonConfig;

	private Integer myPeerID;

	private ConcurrentHashMap<Integer, ClientConnect> clientConnections_map;

	private static final int ACCEPT_TIMEOUT = 100000;
	/**
	 * @param myCommonConfig
	 * @param peer_map
	 * @param myPeerID
	 * @throws InterruptedException
	 * @throws IOException
	 */

	// Initializes the variables to start the socket
	public ServerConnect(ReadConfig myCommonConfig, Map<Integer, ReadConfig> peer_map, int myPeerID)
			throws InterruptedException, IOException {
		
//		this.myListeningPort = peer_map.get(myPeerID).getListeningPort();
//		this.peer_map = peer_map;
//		System.out.println("Peerid "+ myPeerID+ "Listening port" + myListeningPort);
//		
//		serverSocket = new ServerSocket(myListeningPort);
//		serverSocket.setSoTimeout(10000);
		
		
		System.out.println("IM IN THE SERVER CONNECTION CONSTRUCTOR :: hostname = " + myHostName + " port = " + myListeningPort);
		this.serverSocket = new ServerSocket(myListeningPort, 0, InetAddress.getByName(myHostName.trim()));
		this.serverSocket.setSoTimeout(ACCEPT_TIMEOUT);
		
		try{
			Thread.sleep(50);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Server socket ready to run");
	}

	/*
	 * Creates a TCP connection with client and send a handshake message after
	 * successful TCP connection establishment
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */

	// Sockets starts listening
	@Override
	public void run() {
		// TODO Auto-generated method stub

//		while (true) {
//			try {
//				System.out.println("Waiting for client on port ");
//
//				Socket server = this.serverSocket.accept();
//
//				System.out.println("Connected!!!....................... ");
//				// Connect to client and send data
//
//				System.out.println("Just connected to " + server.getRemoteSocketAddress());
//				DataInputStream in = new DataInputStream(server.getInputStream());
//
//				System.out.println(in.readUTF());
//				DataOutputStream out = new DataOutputStream(server.getOutputStream());
//				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
//				setUpConnectionWithPeers(server);
//	       
//				 
//				// Send data if client doesn't have the file
//				server.close();
//
//			} catch (SocketTimeoutException s) {
//				System.out.println("Socket timed out!");
//				break;
//			} catch (IOException e) {
//				e.printStackTrace();
//				break;
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		
		while(true)
		{
			Socket ClientSocket = null;
			// wait for connections forever
			try
			{
				ClientSocket = this.serverSocket.accept();
				(new Thread(new ClientConnect(myHostName,myListeningPort,myPeerID))).start();
				//(new Thread(new MessageHandler(new ClientConnection(ClientSocket, myConnection), myConnection))).start();
				System.out.println("Server has been requested by a client");
			}
			catch(InterruptedIOException iioex)
			{
				
					try
					{
						this.serverSocket.close();
						break;
					} catch (IOException e){}
				}
			
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}


	// Set up connection with the already existing peers
	// Send the handshake message to CLient
	public void setUpConnectionWithPeers(Socket server) throws InterruptedException, IOException {
		for (Integer peer_Id : this.peer_map.keySet()) {
			if (peer_Id < myPeerID) {
				System.out.println("Creating a client for " + myPeerID);

				ClientConnect newClient = new ClientConnect(this.peer_map.get(peer_Id).getHostName(),
						this.peer_map.get(peer_Id).getListeningPort(), peer_Id);
				sendHandshakeMessage(peer_Id, server);
				// this.peerConnectionMap.put(peer_Id, newClient);
			}
		}
	}

	public void sendData(Socket server ,int peer_Id) throws IOException {
		if (clientConnections_map.containsKey(peer_Id)) {
			String file_name  = new ReadConfig().getFileName();
//			FileResponse f = new FileResponse(server, file_name , peer_Id);
		}

	}

	/**
	 * @param peer_Id
	 * @param server
	 * @throws InterruptedException
	 * @throws IOException
	 */

	// Write handshake header message to Output Stream
	public void sendHandshakeMessage(int peer_Id, Socket server) throws InterruptedException, IOException {
		HandshakeMsg handshakeMsg = new HandshakeMsg();
		ByteArrayOutputStream handshakeHeader = Utilities.getStreamHandle();
//		handshakeHeader.write(handshakeMsg.getHANDSHAKE_HEADER().getBytes());
//		handshakeHeader.write(handshakeMsg.getZerobits()); // 10 bytes zero bits
		handshakeHeader.write(Utilities.getBytes(peer_Id));
		byte[] fullHandshakeMessage = handshakeHeader.toByteArray();
		Utilities.returnStreamHandle();
		OutputStream outToServer = server.getOutputStream();
		DataOutputStream out = new DataOutputStream(outToServer);
		out.write(fullHandshakeMessage);
	}
}
