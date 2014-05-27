/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sctp.jsctplib;

/**
 *
 * @author helio
 */
public class Singleton {
	private static SCTPEngine engine;
	public static SCTPEngine getEngine() {
		return sctp.jsctplib.Singleton.engine;
	}
	public static void CreateEngine() {
		sctp.jsctplib.Singleton.engine = new SCTPEngine();
		sctp.jsctplib.Singleton.engine.Start();
	}
}
