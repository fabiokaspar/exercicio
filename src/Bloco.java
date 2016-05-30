
public class Bloco {
	Long bloco[] = new Long[4];
	static OperadorBinario sq = new OperadorBinario();
	
	Bloco () { 
		for (int i = 0; i < 4; i++) {
			bloco[i] = Long.valueOf(0L);
		}
	}
	
	Bloco (Long[] novoBloco) { 
		for (int i = 0; i < 4; i++) {
			bloco[i] = novoBloco[i];
		}
	}
	
	// texto ASCII de 128 caracteres (i.e. 128 bytes) 
	Bloco (String texto) {
		String txtBinario = converteParaBinario(texto);
		String saux;
		
		for (int i = 0; i < 4; i++) {
			saux = txtBinario.substring(i * 32, (i+1) * 32);
			bloco[i] = Long.valueOf(saux, 2);
		}
	}
	
	// converte texto ASCII para uma string binária 
	public static String converteParaBinario (String seq) {
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
	
	// converte array de bytes para Bloco
	public static Bloco converteBufferEmBloco (byte[] chain) {
		Bloco resp = new Bloco();
		int size = chain.length; 
		int j = 0;
		String s;
		
		for (int i = 0; i < size-3; i += 4) {			
			s = calcula4BytesDecimais((short)chain[i], (short)chain[i+1],
					(short)chain[i+2], (short)chain[i+3]);
			
			resp.bloco[j++] = Long.valueOf(s, 2);
			
			//System.out.println(s);
			//System.out.println(Long.toHexString(resp.bloco[j-1]));
		}
		
		return resp;
	}
	
	// converte Bloco para array de bytes
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
	
	// completa o byte[] legivel com 0xFF e retorna um objeto Bloco 
	public static Bloco completaBloco (byte[] legivel, int nbytes_lidos, long size_bytes) {
		byte[] leg2 = new byte[16];
		
		for (int i = 0; i < nbytes_lidos; i++)
			leg2[i] = legivel[i];
		
		for (int i = nbytes_lidos; i < 16; i++)
			leg2[i] = (byte)255;
		
		Bloco novo = converteBufferEmBloco(leg2);
		novo.bloco[3] = Long.valueOf(size_bytes); 
		
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

	// Para entropia: 0 <= pos <= 127
	public Bloco alteraIesimoBit (int pos) {
		Bloco sai = new Bloco(this.bloco);
		String subBloco;
		int i = pos/32;
		int r = pos%32;
				
		Long v = sai.bloco[i];
		subBloco = sq.completaComZero(Long.toBinaryString(v), 32);
		
		//System.out.println(Long.toHexString(v));
		//System.out.println(subBloco);
		
		char pos_char = subBloco.charAt(r);  
		
		if (pos_char == '0')
			pos_char = '1';
		else
			pos_char = '0';
		
		char[] dados = subBloco.toCharArray();
		
		dados[r] = pos_char;
		subBloco = new String(String.copyValueOf(dados));
		
		sai.bloco[i] = Long.valueOf(subBloco, 2);
		
		//System.out.println("==> "+Long.toHexString(sai.bloco[i]));
		//System.out.println("==> "+subBloco+"\n");
	
		return sai;
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
	
	public void alteraBlocoAtual (Bloco novo) {
		for (int i = 0; i < 4; i++) {
			this.bloco[i] = Long.valueOf(novo.bloco[i].longValue());
		}
	}
	
}
