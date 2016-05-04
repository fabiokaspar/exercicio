import java.io.FileInputStream;
import java.io.IOException;


public class Main {
	String senha;
	K128 alg;
	String k;
	
	public void main (String args[]) {
		senha = "ABCqwe4122kQasSS";
		//k = calculaChaveK(senha);
		alg = new K128(k);
		alg.algoritmoK128("qawsedrftgyh1298");	
	}
	
	void leArq(String fname) throws IOException {
		int index;
		byte[] legivel = new byte[16];
		int nbytes;
		FileInputStream entrada = new FileInputStream(fname);
		
		while (true) {
			index = 0;
			do {
				nbytes = entrada.read(legivel, index, 1);
				if (nbytes != -1) {
					//System.out.print((char)legivel[index]+" ");
					index = index+1;
				}	
				else break;
			} while (index < 16);
			
			if (index > 0) {
				String bloco = String.valueOf(legivel);
				//k = calculaChaveK(senha);
			}
			//System.out.println();
			
			if (nbytes == -1)
				break;
		}
		entrada.close();
	}

}
