import java.util.ArrayList;

public class Entropia {
	int nbits;
	ArrayList<Bloco> vetEntra;
	ArrayList<Bloco> vetEntraC;
	ArrayList<Bloco> vetAlter;
	ArrayList<Bloco> vetAlterC;
	ReadFileCBC rf;
	K128 alg;
	OperadorBinario op = new OperadorBinario();
	
	Entropia (K128 alg) {
		this.alg = alg;
		rf = new ReadFileCBC(this.alg);
		
		vetEntra = new ArrayList<Bloco>();
		vetEntraC = new ArrayList<Bloco>();
		vetAlter = new ArrayList<Bloco>();
		vetAlterC = new ArrayList<Bloco>();
		nbits = 4 * 128;
	}
	
	public void entropiaMetodo1 (String fnameInput, String fnameOutput) {
		vetEntraC = rf.criptaArquivoEmCBC(fnameInput, fnameOutput, vetEntra);
		Bloco blc;
		
		blc = vetEntra.get(0);
		
		for (int i = 0; i < 128; i++) {
			blc = blc.alteraIesimoBit(i);
			
		}
	}
	
	public ArrayList<Bloco> criptografaEmCBC (ArrayList<Bloco> vetEntra) {
		ArrayList<Bloco> vetSai = new ArrayList<Bloco>();
		
		int n = vetEntra.size();
		Bloco z = op.xor2(vetEntra.get(0), alg.ff);
		vetSai.add(alg.algoritmoK128(z));
		
		for (int i = 1; i < n; i++) {
			z = op.xor2(vetEntra.get(i), vetSai.get(i-1));
			vetSai.add(alg.algoritmoK128(z));
		}
		
		return vetSai;
	}
	
}
