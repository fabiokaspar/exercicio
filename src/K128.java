import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class K128 {
	public static void main (String args[]) {
		try {
			leArq(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void leArq(String fname) throws IOException {
		int index;
		byte[] legivel = new byte[16];
		int nbytes;
		FileInputStream entrada = new FileInputStream(fname);
		
		while (true) {
			index = 0;
			do {
				nbytes = entrada.read(legivel, index, 1);
				if (nbytes != -1) {
					System.out.print((char)legivel[index]+" ");
					index = index+1;
				}	
				else break;
			} while (index < 16);
		
			System.out.println();
			
			if (nbytes == -1)
				break;
		}
		entrada.close();
	}
	
	static void teste() {
		/*String v1 = Conversor.binToDec("0111");
		String v2 = Conversor.decToBin("255");
		String v3 = Conversor.hexToBin("AF0");
		String v4 = Conversor.binToHex("10100000111110011100"); */
		//System.out.println(v1 + " " + v2 +" "+ v3+" "+ v4);
	}
	
	
	public static byte[] readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.readAllBytes(filePath);
    }
	
	public static void writeFile(String fileName, byte[] fileBytes) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, fileBytes);
    }
}


