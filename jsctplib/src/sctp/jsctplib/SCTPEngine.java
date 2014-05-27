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
public class SCTPEngine {

	public SCTPEngine() {
		this.constructor();
	}

	private void constructor() {
		this.Sockets = new LinkedList<DatagramChannel>();
	}

	public SCTPEngine(int Port) {
		this.Port = Port;
		this.constructor();
	}
	private int Port = 0;
	private List<DatagramChannel> Sockets;
	private Thread IOInputAgentThread;
	private Thread IOOutputAgentThread;
	private Thread MultiplexInputAgentThread;
	private Thread MultiplexOutputAgentThread;

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
			Logger.getLogger(SCTPEngine.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(SCTPEngine.class.getName()).log(Level.SEVERE, null, ex);
		}

		this.IOInputAgentThread = new Thread(new IOInputAgent(this));
		this.IOInputAgentThread.start();

/*
		SCTPPacket packet = new SCTPPacketFromVars();
		packet.setSourcePort(65523);
		packet.setDestinationPort(80);
		packet.setVerificationTag(1231356912);

		Util.DisplayPacket(packet.Pack());

		SCTPParameter param = new SCTPParameter();
		param.setType(6);
		param.setData("Test Value123".getBytes());

		Util.DisplayPacket(param.Pack());
*/
	}

	private class IOInputAgent implements Runnable {

		private SCTPEngine Parent;
		Selector selector;

		public IOInputAgent(SCTPEngine parent) {
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
				Logger.getLogger(SCTPEngine.class.getName()).log(Level.SEVERE, null, ex);
			}


			while (true) {
				try {
					if (this.selector.selectNow() >= 1) {

						ByteBuffer packet = ByteBuffer.allocate(8192);
						for (DatagramChannel dg : Parent.Sockets) {
							dg.receive(packet);
							this.processPacket(packet);
						}
					}
				} catch (IOException ex) {
					Logger.getLogger(SCTPEngine.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}

		private void processPacket(ByteBuffer packet) {
			Util.DisplayPacket(packet.array());
			SCTPPacket processedpacket = new SCTPPacketFromBytes(packet.array());
		}
	}

	private class IOOutputAgent implements Runnable {

		private SCTPEngine Parent;

		public IOOutputAgent(SCTPEngine parent) {
			this.Parent = parent;
		}

		@Override
		public void run() {
		}
	}

	public void Stop() {
	}
}
