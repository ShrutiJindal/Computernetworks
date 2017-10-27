public class ReadConfig {

	private String hostName;
	private int listeningPort;
	private boolean hasCompleteFile;

	public ReadConfig(String hostName, int listeningPort, boolean hasFile)
	{
		this.hostName = hostName;
		this.listeningPort = listeningPort;
		this.hasCompleteFile = hasFile;
	}

	public String getHostName()
	{
		return hostName;
	}

	public int getListeningPort()
	{
		return listeningPort;
	}

	public boolean hasFile()
	{
		return hasCompleteFile;
	}

	public void setHostName(String hostName)
	{
		this.hostName = hostName;
	}

	public void setListeningPort(int listeningPort)
	{
		this.listeningPort = listeningPort;
	}

	public void setHasFile(boolean hasFile)
	{
		this.hasCompleteFile = hasFile;
	}
	
/************************************************* Read the CommonConfig File *****************************************************/	
	
	 	private int numPreferredNeighbours;
	    private int unchokingInterval;
	    private int optimisticUnchokingInterval;
	    private String fileName;
	    private int fileSize;
	    private int pieceSize;

	    public ReadConfig(int numPreferredNeighbours, int unchokingInterval,
	            int optimisticUnchokingInterval, String fileName, int fileSize,
	            int pieceSize)
	    {
	        this.numPreferredNeighbours = numPreferredNeighbours;
	        this.unchokingInterval = unchokingInterval;
	        this.optimisticUnchokingInterval = optimisticUnchokingInterval;
	        this.fileName = fileName;
	        this.fileSize = fileSize;
	        this.pieceSize = pieceSize;
	    }


	    public void setNumPreferredNeighbours(int numPreferredNeighbours)
	    {
	        this.numPreferredNeighbours = numPreferredNeighbours;
	    }

	    public void setUnchokingInterval(int unchokingInterval)
	    {
	        this.unchokingInterval = unchokingInterval;
	    }

	    public void setOptimisticUnchokingInterval(
	            int optimisticUnchokingInterval)
	    {
	        this.optimisticUnchokingInterval = optimisticUnchokingInterval;
	    }

	    public void setFileName(String fileName)
	    {
	        this.fileName = fileName;
	    }

	    public void setFileSize(int fileSize)
	    {
	        this.fileSize = fileSize;
	    }

	    public void setPieceSize(int pieceSize)
	    {
	        this.pieceSize = pieceSize;
	    }

	    public int getNumPreferredNeighbours()
	    {
	        return numPreferredNeighbours;
	    }

	    public int getUnchokingInterval()
	    {
	        return unchokingInterval;
	    }

	    public int getOptimisticUnchokingInterval()
	    {
	        return optimisticUnchokingInterval;
	    }

	    public String getFileName()
	    {
	        return fileName;
	    }

	    public int getFileSize()
	    {
	        return fileSize;
	    }

	    public int getPieceSize()
	    {
	        return pieceSize;
	    }
}


