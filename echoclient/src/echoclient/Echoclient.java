/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoclient;

import java.util.Scanner;
import sctp.jsctplib.SCTPSocket;

/**
 *
 * @author helio
 */
public class Echoclient {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Starting Echo Client");
		System.out.print("Enter hostname: ");
		Scanner reader;
		reader = new Scanner(System.in);
		String HostString = reader.nextLine();
		System.out.println("Enter Port:");
		String PortString = reader.nextLine();
		Integer Port;
		try {
			Port = Integer.parseInt(PortString);
		} catch (Exception e) {
			Port = 5555;
		}

		SCTPSocket socket = SCTPSocket.listen(Port);
		/*
		 * Actual socket code.
		 */
	}
}
