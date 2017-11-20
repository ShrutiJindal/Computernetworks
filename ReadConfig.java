public class ReadConfig {


	private String hostName;

	private int listeningPort;

	private boolean hasCompleteFile;

	/**
	 * @param hostName
	 * @param listeningPort
	 * @param hasFile
	 */
	public ReadConfig(String hostName, int listeningPort, boolean hasFile)
	{
		this.hostName = hostName;
		this.listeningPort = listeningPort;
		this.hasCompleteFile = hasFile;
	}

	// Getter and setter methods
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

	    /**
	     * @param numPreferredNeighbours
	     * @param unchokingInterval
	     * @param optimisticUnchokingInterval
	     * @param fileName
	     * @param fileSize
	     * @param pieceSize
	     */
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
	    
	    public ReadConfig()
	    {
	    	
	    }
// Getter and setter methods
	    /**
	     * @param numPreferredNeighbours
	     */
	    public void setNumPreferredNeighbours(int numPreferredNeighbours)
	    {
	        this.numPreferredNeighbours = numPreferredNeighbours;
	    }

	    /**
	     * @param unchokingInterval
	     */
	    public void setUnchokingInterval(int unchokingInterval)
	    {
	        this.unchokingInterval = unchokingInterval;
	    }

	    /**
	     * @param optimisticUnchokingInterval
	     */
	    public void setOptimisticUnchokingInterval(
	            int optimisticUnchokingInterval)
	    {
	        this.optimisticUnchokingInterval = optimisticUnchokingInterval;
	    }

	    /**
	     * @param fileName
	     */
	    public void setFileName(String fileName)
	    {
	        this.fileName = fileName;
	    }

	    /**
	     * @param fileSize
	     */
	    public void setFileSize(int fileSize)
	    {
	        this.fileSize = fileSize;
	    }

	    /**
	     * @param pieceSize
	     */
	    public void setPieceSize(int pieceSize)
	    {
	        this.pieceSize = pieceSize;
	    }

	    /**
	     * @return
	     */
	    public int getNumPreferredNeighbours()
	    {
	        return numPreferredNeighbours;
	    }

	    /**
	     * @return
	     */
	    public int getUnchokingInterval()
	    {
	        return unchokingInterval;
	    }

	    /**
	     * @return
	     */
	    public int getOptimisticUnchokingInterval()
	    {
	        return optimisticUnchokingInterval;
	    }

	    /**
	     * @return
	     */
	    public String getFileName()
	    {
	        return fileName;
	    }

	    /**
	     * @return
	     */
	    public int getFileSize()
	    {
	        return fileSize;
	    }

	    /**
	     * @return
	     */
	    public int getPieceSize()
	    {
	        return pieceSize;
	    }
}


