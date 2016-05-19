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
		Long A, B, C, D, op;
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
	
	public Bloco roundCriptoInverso (int round, Bloco y) {
		Long ANovo, BNovo, CNovo, DNovo, op;
		Long A, B, C, D;
		Long[] seg = sq.separaBloco(y);
		Bloco x;
		
		ANovo = seg[2];
		BNovo = seg[1];
		CNovo = seg[0];
		DNovo = seg[3];
				
		op = func.F2(ANovo, skey.KR5[round][3], skey.KM32[round][3]);
		D = sq.xor(DNovo, op);
		
		op = func.F3(BNovo, skey.KR5[round][2], skey.KM32[round][2]);
		A = sq.xor(ANovo, op);
		
		op = func.F1(CNovo, skey.KR5[round][1], skey.KM32[round][1]);
		B = sq.xor(BNovo, op);
		
		op = func.F2(D, skey.KR5[round][0], skey.KM32[round][0]);
		C = sq.xor(CNovo, op);
		
		x = sq.concatenaBloco(A, B, C, D);
		
		return x;
	}
	
	public Bloco algoritmoK128 (Bloco x) {
		Bloco y = new Bloco(x.bloco);
		
		for (int i = 0; i <= 11; i++) {
			y = roundCripto(i, y);
		}
		
		return y;
	}
	
	public Bloco algoritmoK128Inverso (Bloco y) {
		Bloco x = new Bloco(y.bloco);
		
		for (int i = 11; i >= 0; i--) {
			x = roundCriptoInverso(i, x);
		}
		
		return x;
	}
	
	public Bloco algoritmoK128Round0 (Bloco x) {
		Bloco y = new Bloco(x.bloco);
	
		y = roundCripto(0, y);
		
		return y;
	}
	
	public Bloco algoritmoK128InversoRound0 (Bloco y) {
		Bloco x = new Bloco(y.bloco);

		x = roundCriptoInverso(0, x);
		
		return x;
	}
		
	public void setKey (String senha) {
		this.senha = senha;
		this.k = new Bloco(senha);
		this.skey = new SubChave(k);
		this.func = skey.ch.func;
	}
}
