
public class Conversor {
	// hexadecimal para binario
	// binario para decimal
	
	static Integer binToDec (String binary) {
		Integer dec = Integer.parseInt(binary, 10);
		//String dec = Integer.toString(v, 10);
		return dec;
	}
	
	static Integer decToBin (String dec) {
		Integer bin = Integer.parseInt(dec, 2);
		//String bin = Integer.toString(v, 2);
		return bin;
	}
	
	static Integer hexToBin (String hexadec) {
		Integer bin = Integer.parseInt(hexadec, 2);
		//String bin = Integer.toString(v, 2);
		
		return bin;
	}
	
	static Integer binToHex (String binary) {
		Integer hex = Integer.parseInt(binary, 16);
		//String hex = Integer.toString(v, 16);
		return hex;
	}
}
