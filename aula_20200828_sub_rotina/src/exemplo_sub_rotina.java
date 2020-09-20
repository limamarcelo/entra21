public class exemplo_sub_rotina {
	// Quando definir a sub-rotina temos que nos perguntar: Qual � o tipo de dado
	// ela vai retornar: ou � nada (retorna nada = void = Procedimento que ir�
	// executar o que est� dentro dele e ir� acabar e n�o ir� retornar nada) ou
	// retorna alguma coisa (n�o � void e � uma fun��o = ela executar� e como
	// resultado ele ter� um valor).
	// imprimir algo na tela, n�o vai retornar nada.
	// Quando for fazer uma soma e quero saber o resultado. Esta sub-rotina tem que
	// ser executada e dar um retorno.

	public static int soma(int valor1, int valor2) {
		int resultado = valor1 + valor2;
		return resultado;
	}

	public static void imprime(int conteudo) {
		System.out.println(conteudo);
	}

	public static void main(String args[]) {
		int operando1 = 1;
		int operando2 = 9;
		
		int valor = soma(operando1, operando2);
		imprime(valor);
	}
}