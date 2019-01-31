package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		for(int i = 0; i < base64Chars.length; i++) {
			if(base64Chars[i] == c) {
				return (byte) i;
			}
		}
		return -1;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		byte[] byteList = new byte[3];
		
		
		byteList[0] = (byte) ((convertBase64Char(s.charAt(0)) << 2) + (convertBase64Char(s.charAt(1)) >> 4));
		byteList[1] = (byte) ((convertBase64Char(s.charAt(1)) << 4) + (convertBase64Char(s.charAt(2)) >> 2));
		byteList[2] = (byte) ((convertBase64Char(s.charAt(2)) << 6) + (convertBase64Char(s.charAt(3))));
		return byteList;
	}
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		ArrayList<Byte> byteList = new ArrayList<Byte>();
		ArrayList<String> stringList = new ArrayList<String>();
		String copy = file;
		for(int i = 0; i < file.length() + 1; i++) {
			if(copy.length() >= 4) {
				stringList.add(copy.substring(0, 4));
				copy = copy.substring(4,copy.length());
			} else {
				stringList.add(copy);
			}
		}
		
		for(int i = 0; i < stringList.size(); i++) {
			if(stringList.get(i).length() != 4) {
				if(stringList.get(i).length() > 0){
					byteList.add((byte) ((convertBase64Char(stringList.get(i).charAt(0)) << 2)));
				} else if(stringList.get(i).length() > 1){
					byteList.add((byte) ((convertBase64Char(stringList.get(i).charAt(0)) << 2) + (convertBase64Char(stringList.get(i).charAt(1)) >> 4)));
					byteList.add((byte) ((convertBase64Char(stringList.get(i).charAt(1)) << 4)));
				} else if(stringList.get(i).length() > 2){
					byteList.add((byte) ((convertBase64Char(stringList.get(i).charAt(0)) << 2) + (convertBase64Char(stringList.get(i).charAt(1)) >> 4)));
					byteList.add((byte) ((convertBase64Char(stringList.get(i).charAt(1)) << 4) + (convertBase64Char(stringList.get(i).charAt(2)) >> 2)));
					byteList.add((byte) ((convertBase64Char(stringList.get(i).charAt(1)) << 6)));
				} 
				
			} else {
				byte[] temp = convert4CharsTo24Bits(stringList.get(i));
				for(int j = 0; j < 3; j++) {
					byteList.add(temp[j]);
				}
			}
		}
		
		/*byte[] byteList = new byte[file.length() * 4 / 3 + file.length()%4];
		String[] stringList;
		if(file.length() % 4 == 0) {
			stringList = new String[file.length() / 4];
			for(int i = 0; i < file.length()/4; i++) {
				stringList[i] = file.substring(i, i+4);
				i+=3;
			}
		} else {
			stringList = new String[file.length() / 4 + 1];
			for(int i = 0; i < file.length()/4 + 1; i++) {
				stringList[i] = file.substring(i, i+4);
				i+=3;
			}
		}
		
		for(int i = 0; i < stringList.length; i++) {
			if(stringList[i].length() != 4) {
				
			} else {
				byte[] temp = convert4CharsTo24Bits(stringList[i]);
			
				for(int j = 0; j < 3; j++) {
					byteList[i*3 + j] = temp[j];
				}
			}
		}*/
		
		byte[] byteArr;
		byteArr = new byte[byteList.size()];
		for(int i = 0; i < byteList.size(); i++) {
			byteArr[i] = byteList.get(i);
		}
		return byteArr;
	}
	
	
}
