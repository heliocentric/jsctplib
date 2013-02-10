/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.heliocentric.jsctplib;

/**
 *
 * @author helio
 */
public class SCTPParameter {
	private int Type;
	public int getType() {
		return this.Type;
	}
	public void setType(int Type) {
		this.Type = Type;
	}
	
	private byte[] Data;
	public byte[] getData() {
		return this.Data;
	}
	public void setData(byte[] packet) {
		this.Data = packet;
	}
	
	
	public void Unpack(byte[] buffer) {
		
	}
	public byte[] Pack() {
		byte[] buffer;
		int headersize = 4;
		int payloadsize = this.Data.length;
		int excess = payloadsize % 4;
		int paddedpayloadsize;
		if (excess > 0) {
			paddedpayloadsize = (payloadsize / 4) + 1;
		} else {
			paddedpayloadsize = payloadsize / 4;
		}
		buffer = new byte[headersize + (paddedpayloadsize * 4)];
		int length = headersize + payloadsize;
		buffer[0] = (byte) (this.Type >> 8);
		buffer[1] = (byte) (this.Type);
		buffer[2] = (byte) (length >> 8);
		buffer[3] = (byte) (length);
		System.arraycopy(this.getData(), 0, buffer, 4, this.getData().length);
		return buffer;
	}
}
