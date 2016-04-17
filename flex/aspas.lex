/* 
Para instalar o flex:
	$ sudo apt-get install flex


Para rodar: 
	$ flex aspas.lex
	$ gcc -c lex.yy.c
	$ gcc -o <executavel> lex.yy.o -lfl
	$ ./executavel entrada.txt saida.txt

	OBS:	- entrada.txt é uma SBox copiada do enunciado
			- saida.txt está no formato que eu quero
			- -lfl eh pra incluir a biblioteca do flex
*/

%{
/* include necessario para a chamada da funcao atof() abaixo */
int cont = 1;
%}

PALAVRA  ([a-f]|[0-9]){8}

%%

{PALAVRA}	{ 	if (cont < 8) {
					fprintf(yyout, "\"%s\",", yytext);
					cont++;
				} 
				else {
					cont = 1;
					fprintf(yyout, "\"%s\",\n", yytext);
				}
			}
	
%%

int main( int argc, char **argv ) {
	++argv, --argc;  /* pula o nome do programa */
	if ( argc > 1 ) {
     		yyin = fopen( argv[0], "r" );
     		yyout = fopen(argv[1], "w");
	}
	
	yylex();
	fclose(yyin);
	fclose(yyout);
}
