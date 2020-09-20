import java.util.Scanner;

public class atividade_primos_boolean_qtd_exec {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Até qual número deseja verificar");
		int limite = 0;
		limite = in.nextInt();
		boolean divisivel = false;
		for (int numeroSequencia = 1; numeroSequencia <= limite; numeroSequencia++) {

			for (int denominador = 2; denominador < numeroSequencia; denominador++) {
				if ((numeroSequencia % denominador) == 0) {
					divisivel = true;
				}
			}
			
			if (!(divisivel)) {
				System.out.println("O número " + numeroSequencia + " é primo");
			}else {
				System.out.println("O número " + numeroSequencia + " não é primo");
			}
			divisivel = false;
		}
		in.close();
	}
}
