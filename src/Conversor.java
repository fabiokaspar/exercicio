
public class Conversor {
	// hexadecimal para binario
	// binario para decimal
	
	static String binToDec (String binary) {
		int v = Integer.parseInt(binary, 2);
		String dec = Integer.toString(v, 10);
		return dec;
	}
	
	static String decToBin (String dec) {
		int v = Integer.parseInt(dec);
		String bin = Integer.toString(v, 2);
		return bin;
	}
	
	static String hexToBin (String hexadec) {
		int v = Integer.parseInt(hexadec, 16);
		String bin = Integer.toString(v, 2);
		return bin;
	}
	
	static String binToHex (String binary) {
		int v = Integer.parseInt(binary, 2);
		String hex = Integer.toString(v, 16);
		return hex;
	}
}
