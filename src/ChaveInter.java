public class ChaveInter {
	Bloco[] ki = new Bloco[12];
	Function func = new Function();
	Constants cts = func.cts;
	OperadorBinario sq = new OperadorBinario();
	
	ChaveInter (Bloco k) {
		Long ctaux;
		ctaux = Long.valueOf("5a827999", 16);
		Bloco ct = sq.concatenaBloco(0L, 0L, 0L, ctaux); // mudei
		
		ki[0] = sq.xor2(ct, k);
		geraTabelaChavesInter();
	}
	
	public void geraTabelaChavesInter () {
		for (int i = 0; i <= 10; i++) {
			ki[i+1] = geraChaveIteracao(ki[i], i+1);
		}
	}
	
	public Bloco geraChaveIteracao (Bloco ki, int itAtual) {
		Bloco nextKey;
		Long D, C, B, A;
		
		Long[] seg = sq.separaBloco(ki);
		
		A = seg[0];
		D = seg[3];
		D = calculaSegmentoD(itAtual, A, D);
		 
		C = seg[2];
		C = calculaSegmentoC(itAtual, D, C);
		
		B = seg[1];
		B = calculaSegmentoB(itAtual, C, B);
		
		A = calculaSegmentoA(itAtual, B, A);
		
		nextKey = sq.concatenaBloco(D, C, B, A);
		
		return nextKey;
	}
	
	public Long calculaSegmentoD (int itAtual, Long arg_func, Long op_xor) {
		Long D, cr, cm, op;
		
		cr = cts.ConstR[itAtual][0];
		cm = cts.ConstM[itAtual][0];
			
		op = func.F2(arg_func, cr, cm);  // f2, A 
		D = sq.xor(op_xor, op);		// D
		
		return D;
	}
	
	public Long calculaSegmentoC (int itAtual, Long arg_func, Long op_xor) {
		Long C, cr, cm, op;
		
		cr = cts.ConstR[itAtual][1];
		cm = cts.ConstM[itAtual][1];
		
		op = func.F1(arg_func, cr, cm);  // f1, D
		C = sq.xor(op_xor, op);  // C
		
		return C;
	}
	
	public Long calculaSegmentoB (int itAtual, Long arg_func, Long op_xor) {
		Long B, cr, cm, op;
		
		cr = cts.ConstR[itAtual][2];
		cm = cts.ConstM[itAtual][2];
		
		op = func.F3(arg_func, cr, cm);  // f3, C 
		B = sq.xor(op_xor, op);  // B
		
		return B;
	}

	public Long calculaSegmentoA (int itAtual, Long arg_func, Long op_xor) {
		Long A, cr, cm, op;
		
		cr = cts.ConstR[itAtual][3];
		cm = cts.ConstM[itAtual][3];
		
		op = func.F2(arg_func, cr, cm);  // f2, B 
		A = sq.xor(op_xor, op);  // A 
		
		return A;
	}
	
}
