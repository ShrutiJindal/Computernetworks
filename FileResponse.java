import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class FileResponse {
	
	public FileResponse(Socket server, String fileName, int client_Id) throws IOException
	{
		DataOutputStream out = new DataOutputStream(server.getOutputStream());
		out.writeUTF(fileName);
	}
}
