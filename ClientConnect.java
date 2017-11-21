import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;


//Peer requests from other peers

public class ClientConnect implements Runnable {

	private String serverName;
	private int serverPort;
	private int peer_Id;

	/**
	 * @param serverName
	 * @param serverPort
	 * @param peer_Id
	 */
	public ClientConnect(String serverName, int serverPort, Integer peer_Id) {
		this.serverName = serverName;
		this.serverPort = serverPort;
		this.peer_Id = peer_Id;
	}

	/* Responds to inital TCP connnection request from server and send an handshake message after successful TCP connection establishment */
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			System.out.println("Connecting to " + serverName + " on port " + serverPort);
			Socket client = new Socket();
			
			
			client.connect(new InetSocketAddress(serverName, serverPort), 10000);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("Server says " + in.readUTF());
//			sendHandShakeMsg(client);
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}/* catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

	// Sends a Handshake message to server 
	// Writes the Handshake Message to the DataOutputstream
	/**
	 * @param client
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void sendHandShakeMsg(Socket client) throws InterruptedException, IOException {
		HandshakeMsg handshakeMsg = new HandshakeMsg();
		ByteArrayOutputStream handshakeHeader = Utilities.getStreamHandle();
		handshakeHeader.write(handshakeMsg.getHANDSHAKE_HEADER().getBytes());
		handshakeHeader.write(handshakeMsg.getZerobits()); // 10 bytes zero bits
		handshakeHeader.write(Utilities.getBytes(peer_Id));
		byte[] fullHandshakeMessage = handshakeHeader.toByteArray();
		Utilities.returnStreamHandle();
		OutputStream outToServer = client.getOutputStream();
		DataOutputStream out = new DataOutputStream(outToServer);
		out.write(fullHandshakeMessage);
	}

}
