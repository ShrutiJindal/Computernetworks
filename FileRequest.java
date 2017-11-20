import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileRequest {

	
	public FileRequest(Socket server, String fileName, int client_Id) throws IOException
	{
		DataOutputStream out = new DataOutputStream(server.getOutputStream());
		out.writeUTF(" Pass request for a piece");
	}
}
