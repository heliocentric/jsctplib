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
	private Thread IOAgent;
	private Thread MultiPlexAgentIn;
	private Thread MultiPlexAgentOut;
	private DatagramSocket Socket;
	public SCTPSocket socket(int domain, int type, int protocol) {
		return new SCTPSocket(this);
	}
	public void Start() {
		
	}
	public void Stop() {
		
	}
	public void close(SCTPSocket socket) {
		
	}
}
