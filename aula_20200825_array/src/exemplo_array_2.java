import java.util.Scanner;

class exemplo_array_2 {
	public static void main(String args[]) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Informe a quantidade de alunos");
		int qtAlunos = ler.nextInt();
		System.out.println("Informe a quantidade de notas por aluno");
		int qtNotas = ler.nextInt();
		float notas[][] = new float[qtAlunos][qtNotas];
		float medias[] = new float[qtAlunos];
		float valorNotas = 0;
		float mediaTurma = 0;
		float mediasAlunos = 0;
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				System.out.println("Digite a nota " + (j + 1) + " do aluno " + (i + 1) + ":");
				notas[i][j] = ler.nextFloat();
			}
		}
		ler.close();
		System.out.println("As notas foram cadastradas");
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				valorNotas += notas[i][j];
			}
			medias[i] = valorNotas / notas.length;
			System.out.println("A m�dia do aluno " + (i + 1) + " foi: " + medias[i]);
			valorNotas = 0;
		}
		for (int i = 0; i < medias.length; i++) {
			mediasAlunos += medias[i];
		}
		mediaTurma = mediasAlunos / medias.length;
		System.out.printf("A m�dia da turma �: %.2f%n", mediaTurma);
	}
}