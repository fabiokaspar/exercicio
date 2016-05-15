
public class Bloco {
	Long bloco[] = new Long[4];
	
	Bloco () { 
		for (int i = 0; i < 4; i++) {
			bloco[i] = 0L;
		}
	}
	
	Bloco (Long[] novoBloco) { 
		bloco = novoBloco;
	}
	
	Bloco (String texto) {
		String txtBinario = converteParaBinario(texto);
		String saux;
		
		for (int i = 0; i < 4; i++) {
			saux = txtBinario.substring(i * 32, (i+1) * 32);
			bloco[i] = Long.valueOf(saux, 2);
		}
	}
	
	private String converteParaBinario (String seq) {
		String seqBin = "", v;
		int valor;
		OperadorBinario sq = new OperadorBinario();
		
		for (int i = 0; i < seq.length(); i++) {
			valor = seq.charAt(i);
			v = Integer.toString(valor, 2);
			v = sq.completaComZero(v, 8);
			seqBin = seqBin.concat(v);
		}
		
		return seqBin;
	}
	
	public void arrayBytesToBloco (byte[] chain) {
		String saux;
		int size = chain.length;
		
		saux = String.valueOf(chain);
		
		for (int i = 0; i < 4; i++) {
			saux = saux.substring(32 * i, 32 * (i+1));
			bloco[i] = Long.valueOf(saux);
		}
	}	
}
