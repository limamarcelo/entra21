import java.util.Scanner;

public class exemplo_do_while {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numero = 0;
		int maior = 0;
		
		do {
			System.out.println("Informe um n�mero");
			numero = in.nextInt();

			if (numero > maior) {
				maior = numero;

			}
		} while (numero != 10);

		System.out.println("O maior n�mero informado �: " + maior);
		in.close();
	}
}