/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import com.github.heliocentric.jsctplib.SCTP;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			Port = null;
		}
		
		SCTP engine;
		if (Port == null) {
			engine = new SCTP();
		} else {
			engine = new SCTP(Port);
		}
		
		engine.Start();
		boolean end = false;
		while (end == false) {
			
		}
	}
}
