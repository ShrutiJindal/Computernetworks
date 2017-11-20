import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateLog {

	public static long timeStamp;

// Get Timestamp for logging 
	
	private String getTimeStamp() {
		String time;
		timeStamp = System.currentTimeMillis();

		// Convert the milliseconds java.util.Date object
		Date instant = new Date(timeStamp);

		// Format the Date object
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		time = sdf.format(instant);

		return time;
	}

	/**
	 * @param output
	 */
	private void writeToLogFile(String output) {
		// In FileIO String filename = "peer_" + peer1+"/log_peer_"+peer1+".log";
		// test for if file doesnot exist
		// For the time being
		String filename = "Peer.log";

		try {
			FileWriter fw = new FileWriter(filename, true); // the true will append the new data
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(output);// appends the string to the file
			bw.newLine();
			bw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// TCP Connection [Time]: Peer1 is connected from Peer2
	/**
	 * @param peer1
	 * @param peer2
	 */
	public void TcpConnection(String peer1, String peer2) {
		writeToLogFile(getTimeStamp() + ": Peer " + peer1 + " is connected from Peer " + peer2 + ".");
	}

	// change of preferred neighbors [Time]:Peer 1 has preferred neighbors[list]
	/**
	 * @param peer1
	 * @param prefPeerList
	 */
	public void changeOfPreferredNeighbours(String peer1, String prefPeerList) {
		writeToLogFile(getTimeStamp() + ": Peer " + peer1 + " has the Preferred neighbours " + prefPeerList + ".");
	}

	// Change of optimistic unchoked neighbor [Time]: Peer1 has optimistic neighbor unchoked neighbor
	/**
	 * @param peer1
	 * @param peer2
	 */
	public void optimisticallyUnchokedNeighbours(String peer1, String peer2) {
		writeToLogFile(
				getTimeStamp() + ": Peer " + peer1 + " has the optimistically unchoked neighbour Peer " + peer2 + ".");
	}

	// Unchoking [Time]: Peer1 is unchoked by Peer2
	/**
	 * @param peer1
	 * @param peer2
	 */
	public void Unchoked(String peer1, String peer2) {
		writeToLogFile(getTimeStamp() + ": Peer " + peer1 + " is unchoked by Peer " + peer2 + ".");
	}

	// Choking [Time]: Peer1 is choked by Peer2
	/**
	 * @param peer1
	 * @param peer2
	 */
	public void Choked(String peer1, String peer2) {
		writeToLogFile(getTimeStamp() + ": Peer " + peer1 + " is choked by Peer " + peer2 + ".");
	}

	// receiving "have" message [Time]: Peer1 received "have" message from peer2 for piece index P1
	/**
	 * @param peer1
	 * @param peer2
	 * @param index
	 */
	public void receivingHave(String peer1, String peer2, int index) {
		writeToLogFile(getTimeStamp() + ": Peer " + peer1 + " received the 'HAVE' message from Peer " + peer2
				+ " for the piece " + index + ".");
	}

	// receiving "interested" message [Time]:Peer1 received "interested" message from Peer2
	/**
	 * @param peer1
	 * @param peer2
	 */
	public void receivingInterested(String peer1, String peer2) {
		writeToLogFile(
				getTimeStamp() + ": Peer " + peer1 + " received the 'INTERESTED' message from Peer " + peer2 + ".");
	}

	// receiving "not interested"message [Time]:Peer1 received "not interested"message from Peer2
	/**
	 * @param peer1
	 * @param peer2
	 */
	public void receivingNotInterested(String peer1, String peer2) {
		writeToLogFile(
				getTimeStamp() + ": Peer " + peer1 + " received the 'NOT INTERESTED' message from Peer " + peer2 + ".");
	}

	// downloading a piece [Time]: Peer1has downloaded the [piece index] from Peer2
	/**
	 * @param peer1
	 * @param peer2
	 * @param index
	 * @param pieces
	 */
	public void downloadPiece(String peer1, String peer2, int index, int pieces) {
		writeToLogFile(getTimeStamp() + ": Peer " + peer1 + " has downloaded the piece " + index + " from Peer " + peer2
				+ ". Now the number of pieces is " + pieces + ".");
	}

	// completion [Time]: Peer 1 has downloaded the complete file
	/**
	 * @param peer1
	 */
	public void DownloadComplete(String peer1) {
		writeToLogFile(getTimeStamp() + ": Peer " + peer1 + " has downloaded the complete file.");
	}
}
