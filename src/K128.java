public class K128 {
	SubChave skey;
	OperadorBinario sq = new OperadorBinario(); 
	Function func;
	Bloco k;
	String senha;
	
	public K128 (String senha) {
		setKey(senha);
	}
	 
	public Bloco roundCripto (int round, Bloco x) {
		Long C, B, D, A, op;
		Long[] seg = sq.separaBloco(x); 
		Bloco y;
		
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
		
		y = sq.concatenaBloco(C, B, A, D);

		return y;
	}
	
	public Bloco algoritmoK128 (Bloco x) {
		Bloco y = new Bloco(x.bloco);
		
		for (int i = 0; i <= 0; i++) {
			y = roundCripto(i, y);
		}
		
		return y;
	}
	
	public void setKey (String senha) {
		this.senha = senha;
		this.k = new Bloco(senha);
		this.skey = new SubChave(k);
		this.func = skey.ch.func;
	}
}
