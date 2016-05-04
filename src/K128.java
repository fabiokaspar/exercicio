public class K128 {
	SubChave skey;
	OperadorBinario sq; 
	Function func;
	String xbin;
	
	public K128 (String senha) {
		String key = converteParaBinario(senha);
		System.out.println("senha = "+senha);
		skey = new SubChave(key);
		func = skey.ch.func;
		sq = new OperadorBinario();
	}
	
	public String converteParaBinario (String seq) {
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
	
	public String roundCripto (int round, String x) {
		String y, C, B, D, A, op;
		String[] seg = sq.separaBits(x,4); 
		
		D = seg[3];
		C = seg[2];
		op = func.F2(D, skey.KR5[round][0], skey.KM32[round][0]);
		C = sq.xor(C, op);
		
		B = seg[1];
		op = func.F1(C, skey.KR5[round][1], skey.KM32[round][1]);
		B = sq.xor(B, op);
		
		A = seg[0];
		op = func.F3(B, skey.KR5[round][2], skey.KM32[round][2]);
		A = sq.xor(A, op);
		
		op = func.F2(A, skey.KR5[round][3], skey.KM32[round][3]);
		D = sq.xor(D, op);
		
		y = C+B+A+D;
		return y;
	}
	
	public String algoritmoK128 (String blocoX) {
		String y;
		
		y = converteParaBinario(blocoX);
		this.xbin = String.valueOf(y);
		
		for (int i = 0; i <= 11; i++) {
			y = roundCripto(i, y);
		}
		
		return y;
	}
	
	public void setOtherKey (String senha) {
		String key = converteParaBinario(senha);
		skey = new SubChave(key);
		func = skey.ch.func;
	}
}
