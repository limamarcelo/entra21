import java.util.Scanner;

public class atividade_primos_boolean {
	public static void main(String[] args) {
		int numero = 0;
		boolean divisivel = false;
		Scanner in = new Scanner(System.in);
		System.out.println("Informe um número");
		numero = in.nextInt();
		for (int i = 2; i < numero; i++) {
			if ((numero % i) == 0) {
				divisivel = true;
			}
		}
		if (divisivel) {
			System.out.println(" O número não é primo");
		} else {
			System.out.println("O número é primo");
		}
		in.close();
	}
}
