import java.util.Scanner;

public class exemplo_while {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numero = 0;
		int maior = 0;

		System.out.println("Informe um n�mero");
		numero = in.nextInt();

		while (numero != 10) {
			if (numero > maior) {
				maior = numero;
			}
			System.out.println("Informe um n�mero");
			numero = in.nextInt();
		}
		System.out.println("O maior n�mero informado �: " + maior);
		in.close();
	}
}