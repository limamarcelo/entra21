import java.util.Scanner;

public class atividade_primos_boolean_qtd_exec {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("At� qual n�mero deseja verificar");
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
				System.out.println("O n�mero " + numeroSequencia + " � primo");
			}else {
				System.out.println("O n�mero " + numeroSequencia + " n�o � primo");
			}
			divisivel = false;
		}
		in.close();
	}
}
