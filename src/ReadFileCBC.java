import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileCBC {
	K128 alg;
	OperadorBinario op = new OperadorBinario();
	
	ReadFileCBC (K128 alg) {
		this.alg = alg;
	}
	
	/***************************** CRIPTOGRAFIA EM CBC ****************************************/
	
	public ArrayList<Bloco> criptaArquivoEmCBC (String fnameInput, String fnameOutput, ArrayList<Bloco> vetEntra) {
		long numbytes = 0;
		boolean leuBloco = false;
		int num_bytesLidos = 0;
		
		byte[] leg = new byte[16];
		ArrayList<Bloco> vetSai = new ArrayList<Bloco>();
		FileInputStream entrada = null;
		FileOutputStream saida = null;
		
		Bloco x, z;
		Bloco y = null;
		Bloco y_ant = new Bloco();
				
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
					numbytes++;
				}
				else { 
					numbytes = numbytes * 16 + num_bytesLidos;
					x = Bloco.completaBloco(leg, num_bytesLidos, numbytes);
				}
				
				if (leuBloco == false) {
					z = op.xor2(x, alg.ff);
					leuBloco = true;
				}
				else {
					z = op.xor2(x, y_ant);
				}
				
				if (vetEntra != null)
					vetEntra.add(x);
				
				y = alg.algoritmoK128(z);
				y_ant.alteraBlocoAtual(y);
				
				vetSai.add(y);
								
				byte[] cifra = Bloco.converteBlocoEmBuffer(y);
				
				escreveNaSaida(saida, cifra, 16);
			}
			
			else break;
		}
		
		System.out.println("Criptografia: olhar arquivos de entrada e saida!");	
		fechaArquivos(entrada, saida);
		
		return vetSai;
	}
	
	/***************************** DECRIPTOGRAFIA EM CBC ****************************************/
	
	public void decriptaArquivoEmCBC (String fnameInput, String fnameOutput) {
		byte[] cifra = new byte[16];
		int num_bytesLidos = 0;
		Bloco x, y, z, y_ant = new Bloco();
		
		boolean leuBloco = false;
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
				y = Bloco.converteBufferEmBloco(cifra);
				z = alg.algoritmoK128Inverso(y);
				
				if (leuBloco == false) {
					x = op.xor2(z, alg.ff);
					leuBloco = true;
				}
				else {
					x = op.xor2(z, y_ant);
				}
				
				y_ant.alteraBlocoAtual(y);	
				
				byte[] leg = Bloco.converteBlocoEmBuffer(x);
				
				escreveNaSaida(saida, leg, 16);
			}
			
			else break;
		}
		
		System.out.println("Decriptografia: olhar arquivos de entrada e saida!");
				
		fechaArquivos(entrada, saida);
	}
	
	/**************************** OPERAÇÕES COM ARQUIVOS ******************************/
	
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
