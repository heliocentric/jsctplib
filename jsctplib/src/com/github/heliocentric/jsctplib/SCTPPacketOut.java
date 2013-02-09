package com.github.heliocentric.jsctplib;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author helio
 */
public class SCTPPacketOut implements SCTPPacket {

	@Override
	public void Unpack(byte[] packet) {
		throw new UnsupportedOperationException("Not supported yet.");
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
	
}
