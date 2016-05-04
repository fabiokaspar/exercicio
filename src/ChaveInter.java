public class ChaveInter {
	String k0;
	String[] ki;
	Function func = new Function();
	Constants cts = func.cts;
	OperadorBinario sq = new OperadorBinario();
	
	ChaveInter (String k) {
		this.ki = new String[12];
		
		String v;
		v = Conversor.hexToBin("5a827999");
		v = sq.completaComZero(v, 128);
		
		k0 = sq.xor(v, k);
		geraTabelaChavesInter();
	}
	
	public void geraTabelaChavesInter () {
		ki[0] = k0;
		
		for (int i = 0; i <= 10; i++) {
			ki[i+1] = geraChaveIteracao(ki[i], i);
		}
	}
	
	public String geraChaveIteracao (String ki, int itAtual) {
		String nextKey;
		String D, C, B, A;
		String[] seg = sq.separaBits(ki, 4);
		
		A = seg[0];
		D = seg[3];
		D = calculaSegmentoD(itAtual, A, D);
		 
		C = seg[2];
		C = calculaSegmentoC(itAtual, D, C);
		
		B = seg[1];
		B = calculaSegmentoB(itAtual, C, B);
		
		A = calculaSegmentoA(itAtual, B, A);
		
		nextKey = D+C+B+A;
		return nextKey;
	}
	
	public String calculaSegmentoD (int itAtual, String arg_func, String op_xor) {
		String D, cr, cm, op;
		
		cr = Long.toBinaryString(cts.ConstR[itAtual][0]);
		cm = Long.toBinaryString(cts.ConstM[itAtual][0]);
		
		cr = sq.completaComZero(cr, 5);
		cm = sq.completaComZero(cm, 32);
		
		op = func.F2(arg_func, cr, cm);  // f2, A 
		D = sq.xor(op_xor, op);		// D
		
		return D;
	}
	
	public String calculaSegmentoC (int itAtual, String arg_func, String op_xor) {
		String C, cr, cm, op;
		
		cr = Long.toBinaryString(cts.ConstR[itAtual][1]);
		cm = Long.toBinaryString(cts.ConstM[itAtual][1]);
		
		cr = sq.completaComZero(cr, 5);
		cm = sq.completaComZero(cm, 32);
		
		op = func.F1(arg_func, cr, cm);  // f1, D
		C = sq.xor(op_xor, op);  // C
		
		return C;
	}
	
	public String calculaSegmentoB (int itAtual, String arg_func, String op_xor) {
		String B, cr, cm, op;
		
		cr = Long.toBinaryString(cts.ConstR[itAtual][2]);
		cm = Long.toBinaryString(cts.ConstM[itAtual][2]);
		
		cr = sq.completaComZero(cr, 5);
		cm = sq.completaComZero(cm, 32);
		
		op = func.F3(arg_func, cr, cm);  // f3, C 
		B = sq.xor(op_xor, op);  // B
		
		return B;
	}

	public String calculaSegmentoA (int itAtual, String arg_func, String op_xor) {
		String A, cr, cm, op;
		
		cr = Long.toBinaryString(cts.ConstR[itAtual][3]);
		cm = Long.toBinaryString(cts.ConstM[itAtual][3]);
		
		cr = sq.completaComZero(cr, 5);
		cm = sq.completaComZero(cm, 32);
		
		op = func.F2(arg_func, cr, cm);  // f2, B 
		A = sq.xor(op_xor, op);  // A 
		
		return A;
	}
	
}
