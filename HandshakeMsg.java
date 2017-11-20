public class HandshakeMsg {

	final String HANDSHAKE_HEADER = "P2PFILESHARINGPROJ";
	byte[] zerobits;
	int peerId;

	public byte[] getZerobits() {
		return zerobits;
	}
	
	public void setZerobits(byte[] zerobits) {
		this.zerobits = new byte[10];
	}
	
	public int getPeerId() {
		return peerId;
	}
	
	public void setPeerId(int peerId) {
		this.peerId = peerId;
	}
	
	public String getHANDSHAKE_HEADER() {
		return HANDSHAKE_HEADER;
	}
	
}
