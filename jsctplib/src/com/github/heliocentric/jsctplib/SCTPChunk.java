/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.heliocentric.jsctplib;

/**
 *
 * @author helio
 */
public interface SCTPChunk {
	public byte[] Pack();
	public void Unpack(byte[] data);
}
