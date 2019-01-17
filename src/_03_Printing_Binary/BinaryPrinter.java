package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public void printByteBinary(byte b) {
		String bin = "";
		for(int i = 7 ; i >= 0; i--) {
			bin += (b & (byte) Math.pow((double) 2, (double) i )) >> i;
		}
		System.out.println(bin);
	}
	
	public void printShortBinary(short s) {
		String bin = "";
		for(int i = 15 ; i >= 0; i--) {
			bin += (s & (short) Math.pow((double) 2, (double) i )) >> i;
		}
		System.out.println(bin);
	}
	
	public void printIntBinary(int in) {
		String bin = "";
		for(int i = 31 ; i >= 0; i--) {
			bin += (in & (int) Math.pow((double) 2, (double) i )) >> i;
		}
		System.out.println(bin);
	}
	
	public void printLongBinary(long l) {
		String bin = "";
		for(int i = 63 ; i >= 0; i--) {
			bin += (l & (long) Math.pow((double) 2, (double) i )) >> i;
		}
		System.out.println(bin);
	}
	
	public static void main(String[] args) {
		BinaryPrinter bp = new BinaryPrinter();
		byte a = 12;
		short b = 13;
		int c = 12;
		long d = 128;
		bp.printByteBinary(a);
		bp.printShortBinary(b);
		bp.printIntBinary(c);
		bp.printLongBinary(d);
	}
}
