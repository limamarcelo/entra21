import java.util.Scanner;

public class atividade_primos_if {
	public static void main(String[] args) {
		// int numero = 0;
		// boolean divisivel = false;
		Scanner in = new Scanner(System.in);
		System.out.println("Informe um n�mero");
		int numero;
		int divisor = 2;
		numero = in.nextInt();
		// for (int i = 2; i < numero; i++) {
		int resto = numero%divisor;
		if (resto == 0) {
			System.out.println("N�o � um n�mero primo");
		}else {System.out.println("� um n�mero primo");
		}
		in.close();
	}
}
