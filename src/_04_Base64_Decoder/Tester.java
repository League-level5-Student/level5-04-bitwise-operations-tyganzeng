package _04_Base64_Decoder;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		ArrayList<String> stringList = new ArrayList<String>();
		String copy = "adsflajehrtljaehltjae";
		String file = "adsflajehrtljaehltjae";
		for(int i = 0; i < file.length()/4 + 1; i++) {
			if(copy.length() >= 4) {
				stringList.add(copy.substring(0, 4));
				copy = copy.substring(4,copy.length());
			} else {
				stringList.add(copy);
			}
		}
		for(String s : stringList) {
			System.out.print(s + " ");
		}
	}
}
