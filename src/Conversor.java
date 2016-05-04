
public class Conversor {
	
	static String binToDec (String binary) {
		long v =  Long.parseLong(binary, 2);
		String dec = Long.toString(v);
		return dec;
	}
	
	static String decToBin (String dec) {
		long v = Long.parseLong(dec, 10);
		String bin = Long.toString(v, 2);
		return bin;
	}
	
	static String hexToBin (String hexadec) {
		Long v = Long.parseLong(hexadec, 16);
		String bin = Long.toString(v, 2);
		return bin;
	}
	
	static String hexToDec (String hexadec) {
		Integer v = Integer.parseInt(hexadec, 16);
		String bin = Integer.toString(v, 10);
		return bin;
	}
	
	static String binToHex (String binary) {
		Integer v = Integer.parseInt(binary, 2);
		String hex = Integer.toString(v, 16);
		return hex;
	}
	
	static long hexToDec2 (String hex) {
		long dec = Long.valueOf(hex, 16);
		return dec;
	}
}
