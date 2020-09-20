import java.util.Scanner;

public class atividade_sub_rotina {
	// Quando definir a sub-rotina temos que nos perguntar: Qual � o tipo de dado
	// ela vai retornar: ou � nada (retorna nada = void = Procedimento que ir�
	// executar o que est� dentro dele e ir� acabar e n�o ir� retornar nada) ou
	// retorna alguma coisa (n�o � void e � uma fun��o = ela executar� e como
	// resultado ele ter� um valor).
	// imprimir algo na tela, n�o vai retornar nada.
	// Quando for fazer uma soma e quero saber o resultado. Esta sub-rotina tem que
	// ser executada e dar um retorno.

	public static int multiplicacao(int valor1, int valor2) {
		int resultadoMultiplicacao = valor1 * valor2;
		return resultadoMultiplicacao;
	}

	public static int divisao(int valor1, int valor2) {
		int resultadoDivisao = valor1 / valor2;
		return resultadoDivisao;
	}

	public static int subtracao(int valor1, int valor2) {
		int resultadoSubtracao = valor1 - valor2;
		return resultadoSubtracao;
	}

	public static int soma(int valor1, int valor2) {
		int resultadoSoma = valor1 + valor2;
		return resultadoSoma;
	}

	public static void imprime(int conteudo) {
		System.out.println(conteudo);
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char continuar;
		do {
			System.out.println("Programa que multiplica ou soma dois valores informados e mostra o resultado");

			System.out.println("Informe o primeiro valor");
			int operando1 = in.nextInt();
			System.out.println("Informe o segundo valor");
			int operando2 = in.nextInt();
			char operacao;
			System.out.println(
					"Qual opera��o voc� deseja fazer? \nSoma: (+)\nSubtra��o (-)\nMultiplica��o (*)\nDivis�o (/)");

			operacao = in.next().charAt(0);
			switch (operacao) {
			case '*':
				int resultadoMultiplicacao = multiplicacao(operando1, operando2);
				imprime(resultadoMultiplicacao);
				break;
			case '+':
				int resultadoSoma = soma(operando1, operando2);
				imprime(resultadoSoma);
				break;
			case '/':
				int resultadoDivisao = divisao(operando1, operando2);
				imprime(resultadoDivisao);
				break;
			case '-':
				int resultadoSubtracao = subtracao(operando1, operando2);
				imprime(resultadoSubtracao);
				break;

			default:
				System.out.println("Digite algum das duas opera��es Soma (s) ou Multiplica��o (m)");
			}
			System.out.println("Deseja continuar? (s/n): ");
			continuar = in.next().charAt(0);
		} while (continuar != 'n');
		in.close();
	}
}