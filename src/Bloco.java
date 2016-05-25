
public class Bloco {
	Long bloco[] = new Long[4];
	static OperadorBinario sq = new OperadorBinario();
	
	Bloco () { 
		for (int i = 0; i < 4; i++) {
			bloco[i] = Long.valueOf(0L);
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
		String seqBin = new String(), v;
		int valor;
		int n = seq.length();
		
		for (int i = 0; i < n; i++) {
			valor = seq.charAt(i);
			v = Integer.toString(valor, 2);
			v = sq.completaComZero(v, 8);
			seqBin = seqBin.concat(v);
		}
		
		return seqBin;
	}
	
	public static Bloco converteBufferEmBloco (byte[] chain) {
		Bloco resp = new Bloco();
		int size = chain.length; 
		int j = 0;
		String s;
		String saux;
		
		for (int i = 0; i < size-3; i += 4) {			
			s = calcula4BytesDecimais((short)chain[i], (short)chain[i+1],
					(short)chain[i+2], (short)chain[i+3]);
			
			System.out.println(s);
			resp.bloco[j++] = Long.valueOf(s, 2);
			
			System.out.println(Long.toHexString(resp.bloco[j-1]));
		}
		
		return resp;
	}
	
	public static byte[] converteBlocoEmBuffer (Bloco arg) {
		byte[] buffer = new byte[16];
		String saux;
		int k = 0;
		int aux;
		
		for (int i = 0; i < 4; i++) {
			saux = String.valueOf(sq.completaComZero(Long.toBinaryString(arg.bloco[i]), 32));
			
			for (int j = 0; j < 4; j++) {
				aux = (int) Integer.parseInt(saux.substring(j * 8, (j+1) * 8), 2);
				buffer[k++] = (byte)(aux);
			}
		}
		
		return buffer;
	}
	
	// completa o final do vetor bloco[] com (Long) 0xFF
	public static Bloco completaBloco (byte[] legivel, int nbytes) {
		int q = nbytes/4;
		int r = nbytes%4;
		String s;
		int j = 0;
		Bloco novo = new Bloco(); 
		
		for (int i = 0; i < 13; i += 4) {
			if (i < nbytes) {
				if (i < 4 * q) {
					s = Bloco.calcula4BytesDecimais((short)legivel[i], (short)legivel[i+1], 
							(short)legivel[i+2], (short)legivel[i+3]);
				}
				else {
					short sbc3 = 255;
					short sbc2 = 255;
					
					if (r >= 2)
						sbc3 = (short)legivel[nbytes-r+1]; 
						
					if (r == 3)
						sbc2 = (short)legivel[nbytes-r+2];
					
					s = Bloco.calcula4BytesDecimais((short)legivel[nbytes-r], sbc3, sbc2, (short)255);
				}
			}
			
			else {
				s = Bloco.calcula4BytesDecimais((short)255, (short)255, (short)255, (short)255);
			}
			
			novo.bloco[j++] = Long.valueOf(s, 2); 
		}
		
		return novo;
	}
	
	public void imprimeBloco () {
		for (int i = 0; i < 4; i++) {
			System.out.print(sq.completaComZero(Long.toHexString(bloco[i]), 8) + " ");
		}
		System.out.println();
	}
	
	public void imprimeBlocoEmBinario () {
		for (int i = 0; i < 4; i++) {
			System.out.print(sq.completaComZero(Long.toBinaryString(bloco[i]), 32)+ " ");
		}
		System.out.println();
	}
	
	public static String calcula4BytesDecimais (short b4, short b3, short b2, short b1) {
		//v = (16777216L, 65536L, 256L, 1L)
		String s, saux;
		int n;
		
		saux = sq.completaComZero(Integer.toBinaryString(b4), 8);
		n = saux.length();
		s = saux.substring(n-8, n);
		
		saux = sq.completaComZero(Integer.toBinaryString(b3), 8);
		n = saux.length();
		s += saux.substring(n-8, n);
		
		saux = sq.completaComZero(Integer.toBinaryString(b2), 8);
		n = saux.length();
		s += saux.substring(n-8, n);
		
		saux = sq.completaComZero(Integer.toBinaryString(b1), 8);
		n = saux.length();
		s += saux.substring(n-8, n);
		
		return s;
	}
}
