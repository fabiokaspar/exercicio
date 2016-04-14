
public class K128 {
	public static void main(String args[]){
		teste();
	}
	
	static void teste() {
		SBox sb = new SBox();
		String v1 = Conversor.binToDec("0111");
		String v2 = Conversor.decToBin("255");
		String v3 = Conversor.hexToBin("AF0");
		String v4 = Conversor.binToHex("10100000111110011100");
		//System.out.println(v1 + " " + v2 +" "+ v3+" "+ v4);
		
		v1 = sb.getElementFromS1(0);
		v2 = sb.getElementFromS1(255);
		v3 = sb.getElementFromS1(8);
		System.out.println("SBox S1: " + v1 + " " + v2 +" "+ v3);
		
		v1 = sb.getElementFromS2(0);
		v2 = sb.getElementFromS2(255);
		v3 = sb.getElementFromS2(8);
		System.out.println("SBox S2: " + v1 + " " + v2 +" "+ v3);
		
		v1 = sb.getElementFromS3(0);
		v2 = sb.getElementFromS3(255);
		v3 = sb.getElementFromS3(8);
		System.out.println("SBox S3: " + v1 + " " + v2 +" "+ v3);
		
		v1 = sb.getElementFromS4(0);
		v2 = sb.getElementFromS4(255);
		v3 = sb.getElementFromS4(8);
		System.out.println("SBox S4: " + v1 + " " + v2 +" "+ v3);
	}
}
