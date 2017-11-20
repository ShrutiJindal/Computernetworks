public class MessageType {
	
	public void getMsgType()
	{
		ActualMessage actualMsg = new ActualMessage();
		switch(Integer.parseInt(actualMsg.getMsgType()))
		{
			case 0: 
				// Call Choke
				type_choke();
			case 1:
				// Call Unchoke
				type_Unchoke();
			case 2:
				// Call Interested
				type_Interested();
			case 3:
				// Call Not interested
				type_NotInterested();
			case 4:
				// Call have
				type_Have();
			case 5:
				// Call Bitfiled
				type_Bitfield();
			case 6:
				// Call request
				type_Request();
			case 7:
				// Call piece
				type_Piece();
			default:
				// Wrong type
				System.out.println("Incorrect message type");
		}
	}
	
	public void type_choke()
	{
		/* Check download rates of all peers 
		 * Select the top neighbours
		 * Choke the rest*/
	}
	
	public void type_Unchoke()
	{
		/* Check piece if available  
		 * optimistically unchoke
		 * */
	}
	
	public void type_Interested()
	{
		/* after checking piece available
		 * send interested message type
		 * along with the piece id
		 */
	}
	
	public void type_NotInterested()
	{
		/* If peer already has a piece
		 * send not interested
		 */
	}
	
	public void type_Have()
	{
		/* Server gets a request for the piece
		 * Sends a have message to inform 
		 * if piece is available
		 */
	}
	
	public void type_Bitfield()
	{
		/* For the first request from client
		 * Send the bitfield request 
		 * for a piece
		 */
	}
	
	public void type_Request()
	{
		/* Client sends a request for a piece id
		 * to the server
		 */
	}
	
	public void type_Piece()
	{
		/* Send the piece requested */
	}
}
