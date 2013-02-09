package com.github.heliocentric.jsctplib;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 * Just In Time implementation of SCTPPacket.
 * There are private variables for all functions.
 * If someone calls Unpack(), the readonly boolean is set, and we use index's
 * into the byte[] for the variables.
 * 
 * DO NOT MODIFY THE byte[] AFTER CALLING Unpack(). For speed, this
 * implementation is zero-copy. It is also recommended to null the
 * variable, to eliminate undefined behavior.
 * 
 * 
 * @author helio
 */
public class SCTPPacketJIT implements SCTPPacket {
	public SCTPPacketJIT() {
		this._readonly = false;
	}
	
	private boolean _readonly;
	@Override
	public boolean ReadOnly() {
		return this._readonly;
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
	public void Unpack(byte[] packet) {
		this._readonly = true;
		this.packet = packet;
	}

	
	@Override
	public byte[] Pack() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/*
	 * 
	 * SCTP Source Port
	 * This is in host byte order, until we attempt to generate a
	 * byte array.
	 * 
	 */
	
	private int SourcePort;
	
	@Override
	public int getSourcePort() {
		return this.SourcePort;
	}

	@Override
	public void setSourcePort(int Port) {
		this.SourcePort = Port;
	}

	
	/* 
	 * 
	 * SCTP Destination port
	 * This is in host byte order, until we attempt to generate a
	 * byte array.
	 * 
	 */
	
	
	private int DestinationPort;
	
	@Override
	public int getDestinationPort() {
		return this.DestinationPort;
	}

	@Override
	public void setDestinationPort(int Port) {
		this.DestinationPort = Port;
	}

	/*
	 * 
	 * SCTP Verification tag.
	 * We DO NOT attempt to convert this, as all it is is a tag.
	 * 
	 */
	
	private long VerificationTag;
	@Override
	public long getVerificationTag() {
		return this.VerificationTag;
	}

	@Override
	public void setVerificationTag(long Tag) {
		this.VerificationTag = Tag;
	}

	@Override
	public long getChecksum() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean checkChecksum() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int getChunkNumber() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public SCTPChunk getChunk(int number) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void addChunk(SCTPChunk chunk) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
