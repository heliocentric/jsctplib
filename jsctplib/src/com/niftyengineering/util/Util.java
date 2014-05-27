/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niftyengineering.util;

/**
 *
 * @author helio
 */
public class Util {

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public static String bytesToHex(byte[] bytes) {
		final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] hexChars = new char[bytes.length * 2];
		int v;
		for (int j = 0; j < bytes.length; j++) {
			v = bytes[j] & 255;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 15];
		}
		return new String(hexChars);
	}

	public static void DisplayPacket(byte[] bytes) {
		String bytestring = Util.bytesToHex(bytes);
		String[] chunks = bytestring.split("(?<=\\G.{8})");
		Integer offset = 0;
		for (String chunk : chunks) {
			System.out.println("0x" + String.format("%04d", offset) + " - " + chunk + "\t" + new String(Util.hexStringToByteArray(chunk)));
			offset += 4;
		}
	}
	
}
