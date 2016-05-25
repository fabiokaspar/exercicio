import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReadFile {
	K128 alg;
	OperadorBinario op = new OperadorBinario();
	
	ReadFile (K128 alg) {
		this.alg = alg;
	}
	
	/***************************** CRIPTOGRAFIA EM CBC ****************************************/
	
	public void criptaArquivoEmCBC (String fnameInput, String fnameOutput) {
		byte[] leg = new byte[16];
		int num_bytesLidos = 0;
		Bloco x;
		
		FileInputStream entrada = null;
		FileOutputStream saida = null;
		
		try {
			entrada = new FileInputStream(fnameInput);
			saida =  new FileOutputStream(fnameOutput);
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		while (true) {
			num_bytesLidos = leDaEntrada(entrada, leg, 16);
			
			if (num_bytesLidos != -1)
			{
				if (num_bytesLidos == 16) {
					x = Bloco.converteBufferEmBloco(leg);
				}
				else { 
					x = Bloco.completaBloco(leg, num_bytesLidos);
				}
				
				Bloco y = alg.algoritmoK128(x);
				
				byte[] cifra = Bloco.converteBlocoEmBuffer(y);
				
				escreveNaSaida(saida, cifra, 16);
			}
			
			else break;
		}
		
		System.out.println("Criptografia: olhar arquivos de entrada e saida!");
		
		try {
			entrada.close();
			saida.close();
		} catch (IOException e) { e.printStackTrace(); }
	
	}
	
	/***************************** DECRIPTOGRAFIA EM CBC ****************************************/
	
	public void decriptaArquivoEmCBC (String fnameInput, String fnameOutput) {
		byte[] cifra = new byte[16];
		int num_bytesLidos = 0;
		
		FileInputStream entrada = null;
		FileOutputStream saida = null;
		
		try {
			entrada = new FileInputStream(fnameInput);
			saida =  new FileOutputStream(fnameOutput);
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		while (true) {
			num_bytesLidos = leDaEntrada(entrada, cifra, 16);
			
			if (num_bytesLidos == 16)
			{
				Bloco y = Bloco.converteBufferEmBloco(cifra);
				
				Bloco x = alg.algoritmoK128Inverso(y);
				
				byte[] leg = Bloco.converteBlocoEmBuffer(x);
				
				escreveNaSaida(saida, leg, 16);
			}
			
			else break;
		}
		
		System.out.println("Decriptografia: olhar arquivos de entrada e saida!");
		
		try {
			entrada.close();
			saida.close();
		} catch (IOException e) { e.printStackTrace(); }
		
		//fechaArquivos(entrada, saida);
	}
	
	/**************** OPERAÇÕES COM ARQUIVOS *******************/
	
	public void escreveNaSaida (FileOutputStream saida, byte[] buffer, int qtdbytes) {
		try {					
			saida.write(buffer, 0, qtdbytes);
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public void fechaArquivos (FileInputStream entrada, FileOutputStream saida) {
		try {
			entrada.close();
			saida.close();
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public int leDaEntrada (FileInputStream entrada, byte[] buffer, int qtdbytes) {
		int num_bytesLidos = 0;
		
		try {
			num_bytesLidos = entrada.read(buffer, 0, qtdbytes);
		} catch (IOException e) { e.printStackTrace(); }
		
		return num_bytesLidos;
	}
	
}
