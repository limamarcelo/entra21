public class exemplo_sub_rotina {
	// Quando definir a sub-rotina temos que nos perguntar: Qual é o tipo de dado
	// ela vai retornar: ou é nada (retorna nada = void = Procedimento que irá
	// executar o que está dentro dele e irá acabar e não irá retornar nada) ou
	// retorna alguma coisa (não é void e é uma função = ela executará e como
	// resultado ele terá um valor).
	// imprimir algo na tela, não vai retornar nada.
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