/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sctp.jsctplib;

import com.niftyengineering.util.Util;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
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
		this.constructor();
	}

	private void constructor() {
		this.Sockets = new LinkedList<DatagramChannel>();
	}

	public SCTP(int Port) {
		this.Port = Port;
		this.constructor();
	}
	private int Port = 0;
	private List<DatagramChannel> Sockets;
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
			DatagramChannel channel = DatagramChannel.open();
			channel.socket().bind(new InetSocketAddress(9989));
			channel.configureBlocking(false);
			this.Sockets.add(channel);
			channel = DatagramChannel.open();
			if (this.Port == 0) {
				channel.socket().bind(new InetSocketAddress(this.Port));
				channel.configureBlocking(false);
				this.Sockets.add(channel);
			}
		} catch (SocketException ex) {
			Logger.getLogger(SCTP.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
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
		Selector selector;

		public IOInputAgent(SCTP parent) {
			this.Parent = parent;
		}

		@Override
		public void run() {
			try {
				this.selector = Selector.open();
				for (DatagramChannel dg : Parent.Sockets) {
					dg.register(this.selector, SelectionKey.OP_READ);
				}
			} catch (IOException ex) {
				Logger.getLogger(SCTP.class.getName()).log(Level.SEVERE, null, ex);
			}


			while (true) {
				try {
					//If there's a packet available, fetch it:

					if (this.selector.selectNow() >= 1) {

						ByteBuffer packet = ByteBuffer.allocate(4096);
						for (DatagramChannel dg : Parent.Sockets) {
							dg.receive(packet);
							System.out.println("Packet Received");
						}
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
