
public class Main {
	static String senha;
	static K128 alg;
	static ReadFile rf; 
	
	public static void main (String args[]) {
		leiaEntradaTerminal(args);
	}
	
	public static void leiaEntradaTerminal (String args[]) {
		if (args.length == 7 || args.length == 8) {
			
			// Modo 1: criptografar
			if (args[0].equals("-c") && args[1].equals("-i")) {
				if (args[3].equals("-o") && args[5].equals("-p")) {		
					
					defineSenha16Bytes(args[6]);
					alg = new K128(senha);
					rf = new ReadFile(alg);
					 
					rf.criptaArquivoEmCBC(args[2], args[4]);
	
					if (args.length == 8 && args[7].equals("-a")) {
						// efetuar a gravação de brancos e deleção da entrada
						
					}
				}
			}
			
			// Modo 2: decriptografar
			else if (args[0].equals("-d") && args[1].equals("-i")) {
				if (args[3].equals("-o") && args[5].equals("-p")) {
					
					defineSenha16Bytes(args[6]);
					alg = new K128(senha);
					rf = new ReadFile(alg);
					rf.decriptaArquivoEmCBC(args[2], args[4]);
				}
			}
		}
		
		if (args.length == 5) {
			
			// Modo 3: aleatoriedade método 1
			if (args[0].equals("-1") && args[1].equals("-i")) {
				if (args[3].equals("-p")) {
					
					defineSenha16Bytes(args[4]);
					alg = new K128(senha);
					//rf = new ReadFile(alg, args[2], "saida.txt");
					
				}
			}
			
			// Modo 4: aleatoriedade método 2
			else if (args[0].equals("-2") && args[1].equals("-i")) {
				if (args[3].equals("-p")) {
					
					defineSenha16Bytes(args[4]);
					alg = new K128(senha);
					//rf = new ReadFile(alg, args[2], "saida.txt");
				}
			}
		}
	}
	
	public static int defineSenha16Bytes (String pass) {
		int qtdLetrasGrandes = 0;
		int qtdAlgarismos = 0;
		int code;
		int n = pass.length();
		
		if (n > 16) {
			System.out.println("senha > do que 16 bytes!");
			return -1;
		}
		
		else if (n < 8) {
			System.out.println("senha < do que 8 bytes!");
			return -2;
		}
		
		else if (n < 16) {
			int nc = 16-n;
			senha = String.valueOf(pass.concat(pass.substring(0, nc)));
		}
		
		for (int i = 0; i < 16; i++) {
			code = (int)senha.charAt(i);
			
			if (code >= 48 && code <= 57) {
				qtdAlgarismos++;
			}
			
			else if (code >= 65 && code <= 90) {
				qtdLetrasGrandes++;
			}
		}
		
		if (qtdAlgarismos < 2 || qtdLetrasGrandes < 2) {
			System.out.println("A senha digitada deve conter pelo menos 2 letras maiúsculas e pelo menos 2 dígitos!");
			return -3;
		}
		
		System.out.println("senha final = "+ senha);
		
		return 1;
	}
	
}
