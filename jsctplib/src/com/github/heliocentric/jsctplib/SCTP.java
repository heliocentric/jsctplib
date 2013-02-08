/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.heliocentric.jsctplib;


/**
 *
 * @author helio
 */
public class SCTP {
	public SCTP() {
	}
	public Thread IOThread;
	public SCTPSocket socket(int domain, int type, int protocol) {
		return new SCTPSocket();
	}
	public void close(SCTPSocket socket) {
		
	}
}
