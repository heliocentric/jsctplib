/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.heliocentric.jsctplib;

/**
 *
 * @author helio
 */
public class SCTPPacketIn implements SCTPPacket {

	@Override
	public void Unpack(byte[] packet) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public byte[] Pack() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int getSourcePort() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setSourcePort(int Port) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int getDestinationPort() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setDestinationPort(int Port) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public long getVerificationTag() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setVerificationTag(long Tag) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public long getChecksum() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void calcChecksum() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean checkChecksum() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
