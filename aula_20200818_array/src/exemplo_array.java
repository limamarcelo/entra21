import java.util.Scanner;

public class exemplo_array {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Quantas Notas Você Deseja Informar?");
		int tamanho = in.nextInt();
		int notas[] = new int[tamanho];

		for (int i = 0; i < notas.length; i++) {
			System.out.println("Informe a nota");
			notas[i] = in.nextInt();
		}

		// notas [0] = 10;
		// notas [1] = 100;
		// notas [2] = 1000;

		System.out.println(notas[0]);
		System.out.println(notas[1]);
		// notas [2] = 2000; - exemplo dá para mudar o valor do array no meio do
		// processo se quiser.
		System.out.println(notas[2]);
		// onde está na memória
		System.out.println(notas);
		// tamanho de notas
		System.out.println(notas.length);
		in.close();
	}

}
