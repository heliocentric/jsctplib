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
}
