package sctp.jsctplib;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *
 * @author helio
 */
public class SCTPPacketFromBytes implements SCTPPacket {

	public SCTPPacketFromBytes(byte[] packet) {
		this.packet = packet;
	}

	@Override
	public boolean ReadOnly() {
		return true;
	}
	/*
	 * 
	 * Raw SCTP packet.
	 * Everything used here has to be converted/swapped/shifted at run time.
	 * Only used if this.ReadOnly() == true;
	 * 
	 */
	private byte[] packet;

	@Override
	public byte[] Pack() {
		return packet;
	}

	@Override
	public int getSourcePort() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void setSourcePort(int Port) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getDestinationPort() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void setDestinationPort(int Port) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public long getVerificationTag() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void setVerificationTag(long Tag) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getChunkNumber() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public SCTPChunk getChunk(int number) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void addChunk(SCTPChunk chunk) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public long getChecksum() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean checkChecksum() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}


}
