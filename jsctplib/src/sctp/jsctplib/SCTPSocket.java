/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sctp.jsctplib;

/**
 *
 * @author helio
 */
public class SCTPSocket {

	private SCTPEngine master;

	private SCTPSocket() {
		if (sctp.jsctplib.Singleton.getEngine() == null)
		{
			sctp.jsctplib.Singleton.CreateEngine();
		}
		this.master = sctp.jsctplib.Singleton.getEngine();
	}
	public void bind(int Port) {
	}
	public static SCTPSocket listen(int Port) {
		SCTPSocket socket = new SCTPSocket();
		socket.bind(Port);
		return socket;
		
	}
	public void connect() {
		
	}
	public void recvmsg() {
		
	}
	public void sendmsg() {
		
	}
	public void accept() {
		
	}
	public void shutdown() {
		
	}
	public void getpeername() {
		
	}
	public void sendto() {
		
	}
	public void recvfrom() {
		
	}
	public void setsockopt() {
		
	}
	public void getsockopt() {
		
	}
	public byte[] read() {
		return null;
	}
	public SCTPPacket readp() {
		return null;
		
	}
	public void write(byte[] data) {
		
	}
	public void getsockname() {
		
	}
	public void sctp_opt_info() {
		
	}
	public void sctp_bindx() {
		
	}
	public void sctp_peeloff() {
		
	}
	public void sctp_getpaddrs() {
		
	}
	public void sctp_freepaddrs() {
		
	}
	public void sctp_getladdrs() {
		
	}
	public void sctp_freeladdrs() {
		
	}
	public void sctp_connectx() {
		
	}
	public void sctp_sendv() {
		
	}
	public void sctp_recvv() {
		
	}
}
