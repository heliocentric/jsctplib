/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import sctp.jsctplib.SCTPEngine;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sctp.jsctplib.SCTPPacket;
import sctp.jsctplib.SCTPSocket;

/**
 *
 * @author helio
 */
public class Echoserver {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Starting Echo Server");
		System.out.print("Enter port: ");
		
		Scanner reader = new Scanner(System.in);
		String PortString = reader.nextLine();
		System.out.println();
		Integer Port;
		try {
			Port = Integer.parseInt(PortString);
		} catch (Exception e) {
			Port = 5555;
		}
		
		/*
		 * Actual socket code.
		 */
		SCTPSocket socket = SCTPSocket.listen(Port);
		boolean end = false;
		while (end == false) {
			byte[] packet = socket.read();
			socket.write(packet);
		}
	}
}
