/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.heliocentric.jsctplib;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
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
		/*
		this.IOInputAgentThread = new Thread(new IOInputAgent(this));
		this.IOInputAgentThread.start();
		*/
		
		SCTPPacket packet = new SCTPPacketJIT();
		packet.setSourcePort(65523);
		packet.setDestinationPort(80);
		packet.setVerificationTag(1231356912);
		
		SCTP.DisplayPacket(packet.Pack());
		
		SCTPParameter param = new SCTPParameter();
		param.setType(6);
		param.setData("Test Value123".getBytes());
		
		SCTP.DisplayPacket(param.Pack());

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
	public static String bytesToHex(byte[] bytes) {
		final char[] hexArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] hexChars = new char[bytes.length * 2];
		int v;
		for ( int j = 0; j < bytes.length; j++ ) {
		    v = bytes[j] & 0xFF;
		    hexChars[j * 2] = hexArray[v >>> 4];
		 hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public static void DisplayPacket(byte[] bytes) {
		String bytestring = SCTP.bytesToHex(bytes);
		String[] chunks = bytestring.split("(?<=\\G.{8})");
		Integer offset = 0;
		for (String chunk : chunks) {
			System.out.println("0x" + String.format("%04d", offset) + " - " + chunk + "\t" + new String(SCTP.hexStringToByteArray(chunk)));
			offset += 4;
		}

	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}
}
