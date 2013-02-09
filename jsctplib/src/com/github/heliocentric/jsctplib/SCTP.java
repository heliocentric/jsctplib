/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.heliocentric.jsctplib;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author helio
 */
public class SCTP {
	
	public SCTP() {
		this.Port = 9899;
	}
	
	public SCTP(int Port) {
		this.Port = Port;
	}
	
	private int Port;
	private DatagramSocket Socket;
	
	private Thread IOInputAgentThread;
	private Thread IOOutputAgentThread;
	private Thread MultiplexInputAgentThread;
	private Thread MultiplexOutputAgentThread;
	
	public SCTPSocket socket(int domain, int type, int protocol) {
		return new SCTPSocket(this);
	}
	
	public void close(SCTPSocket socket) {
		
	}
	
	public void Start() {
		try {
			this.Socket = new DatagramSocket(this.Port);
		} catch (SocketException ex) {
			Logger.getLogger(SCTP.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		this.IOInputAgentThread = new Thread(new IOInputAgent(this));
		this.IOInputAgentThread.start();
	}
	
	private class IOInputAgent implements Runnable {

		private SCTP Parent;
		public IOInputAgent(SCTP parent) {
			this.Parent = parent;
		}
		@Override
		public void run() {
			byte[] buffer;
			
			boolean end = false;
			while(end == false) {
				try {
					buffer = new byte[4096];
					DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
					Parent.Socket.receive(packet);
					System.out.println("Packet Received");
				} catch (IOException ex) {
					Logger.getLogger(SCTP.class.getName()).log(Level.SEVERE, null, ex);
				}
				
			}
		}
	}
	private class IOOutputAgent implements Runnable {
		private SCTP Parent;
		public IOOutputAgent(SCTP parent) {
			this.Parent = parent;
		}

		@Override
		public void run() {
		}
		
	}
	
	public void Stop() {
		
	}
}
