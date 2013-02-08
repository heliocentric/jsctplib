/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.heliocentric.jsctplib;

import java.net.DatagramSocket;


/**
 *
 * @author helio
 */
public class SCTP {
	public SCTP() {
	}
	private Thread MainAgent;
	private DatagramSocket Socket;
	public SCTPSocket socket(int domain, int type, int protocol) {
		return new SCTPSocket(this);
	}
	public void close(SCTPSocket socket) {
		
	}
}
