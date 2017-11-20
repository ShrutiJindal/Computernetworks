import java.io.IOException;

public class ActualMessage {

	// protected static final long serialVersionUID = 1L;

	String msgType;
	int msgLength;
	byte[] messagePayload;

	// setter functions
	
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	public void setMsgLength(int msgLength) {
		this.msgLength = msgLength;
	}


	public void setMessagePayload(byte[] messagePayload) {
		this.messagePayload = messagePayload;
	}
	

	// getter functions

	public String getMsgType() {
		return msgType;
	}


	public int getMsgLength() {
		return msgLength;
	}


	public byte[] getMessagePayload() {
		return messagePayload;
	}

}
