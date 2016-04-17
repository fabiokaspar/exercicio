
public class Conversor {
	
	static String binToDec (String binary) {
		Integer v = Integer.parseInt(binary, 2);
		String dec = Integer.toString(v);
		return dec;
	}
	
	static String decToBin (String dec) {
		Integer v = Integer.parseInt(dec, 10);
		String bin = Integer.toString(v, 2);
		return bin;
	}
	
	static String hexToBin (String hexadec) {
		Integer v = Integer.parseInt(hexadec, 16);
		String bin = Integer.toString(v, 2);
		return bin;
	}
	
	static String binToHex (String binary) {
		Integer v = Integer.parseInt(binary, 2);
		String hex = Integer.toString(v, 16);
		return hex;
	}
}
