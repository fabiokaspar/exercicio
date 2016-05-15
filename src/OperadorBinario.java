public class OperadorBinario {
	long pot = (long) Math.pow(2, 32);
	
	public Long xor (Long op1, Long op2) {
		Long resp;
		 
		resp = op1.longValue() ^ op2.longValue();
		
		return resp;
	}
	
	public Bloco xor2 (Bloco op1, Bloco op2) {
		Bloco resp = new Bloco();
		
		for (int i = 0; i < 4; i++) {
			resp.bloco[i] = 0L;
			resp.bloco[i] = (op1.bloco[i].longValue() ^ op2.bloco[i].longValue());
		}
		
		return resp;
	}
	
	public Long rotacionaEsquerda (Long op, int off) {
		String seq = Long.toBinaryString(op);
		seq = completaComZero(seq, 32);
		
		String last;
		String sufixo = seq.substring(0, off);
		
		last = seq.substring(off, 32);
		last = last.concat(sufixo);
		
		Long res = Long.valueOf(last, 2);
		
		return res;
	}
	
	public Long cincoBitsDaDireita (Long op) {
		Long res;
		String saux;
		int n;
		
		saux = Long.toBinaryString(op);
		n = saux.length();
		saux = saux.substring(n-5, n);
		res = Long.valueOf(saux, 2); 
		
		return res;		
	}
	
	public Long[] separaBloco (Bloco op) {	
		return op.bloco;
	}
	
	public int[] extratorDeBytes (Long op) {
		String saux = Long.toBinaryString(op);
		saux = completaComZero(saux, 32);
		
		int[] bytes = new int[4];
		int j = 0;
		
		for (int i = 0; i < 4; i++) {
			bytes[j++] = (int)Integer.valueOf(saux.substring(i * 8, (i+1) * 8), 2);
		}
		
		return bytes;
	}
	
	public String completaComZero (String seq, int total) {
		int qtd_atual = seq.length();
		int dif = total - qtd_atual;
		String last = String.valueOf(seq);
		String zero = "0";
		
		for (int i = 1; i <= dif; i++) {
			last = zero + last;
		}
		
		return last;
	}
	
	public Bloco concatenaBloco (Long op1, Long op2, Long op3, Long op4) {
		Bloco blc = new Bloco();
		
		blc.bloco[0] = op1;
		blc.bloco[1] = op2;
		blc.bloco[2] = op3;
		blc.bloco[3] = op4;
		
		return blc;
	}
	
	public Long somaMod32 (Long op1, Long op2) {
		long soma = (op1.longValue() + op2.longValue()) % pot;
				
		return soma;
	}
	
	public Long subMod32 (Long op1, Long op2) {
		long sub = (op1.longValue()-op2.longValue());
		
		if (sub < 0) 
			sub += pot;
		
		if (sub >= pot)
			sub = sub % pot;
		
		return sub;
	}
}
