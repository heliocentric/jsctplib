/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sctp.jsctplib;

import com.niftyengineering.util.IQueuePair;
import com.niftyengineering.util.QueuePair;
import com.niftyengineering.util.Util;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helio
 */
public class SCTP {

	public SCTP() {
		this(9899);
	}

	public SCTP(int Port) {
		this.Sockets = new LinkedList<DatagramSocket>();
		this.Port = Port;
	}
	private int Port;
	private List<DatagramSocket> Sockets;
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
		DatagramSocket sock;
		try {
			sock = new DatagramSocket(this.Port);
			this.Sockets.add(sock);
		} catch (SocketException ex) {
			Logger.getLogger(SCTP.class.getName()).log(Level.SEVERE, null, ex);
		}
		/*
		 this.IOInputAgentThread = new Thread(new IOInputAgent(this));
		 this.IOInputAgentThread.start();
		 */

		SCTPPacket packet = new SCTPPacketFromVars();
		packet.setSourcePort(65523);
		packet.setDestinationPort(80);
		packet.setVerificationTag(1231356912);

		Util.DisplayPacket(packet.Pack());

		SCTPParameter param = new SCTPParameter();
		param.setType(6);
		param.setData("Test Value123".getBytes());

		Util.DisplayPacket(param.Pack());

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
			while (end == false) {
				try {
					for (DatagramSocket dg : Parent.Sockets) {
						buffer = new byte[4096];
						DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
						dg.receive(packet);
						System.out.println("Packet Received");
					}
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
