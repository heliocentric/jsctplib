/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.heliocentric.jsctplib;

/**
 *
 * @author helio
 */
public interface SCTPPacket {
	public void Unpack(byte [] packet);
	public byte[] Pack();
	public int getSourcePort();
	public void setSourcePort(int Port);
	public int getDestinationPort();
	public void setDestinationPort(int Port);
	public long getVerificationTag();
	public void setVerificationTag(long Tag);
	public long getChecksum();
	public boolean checkChecksum();
}
