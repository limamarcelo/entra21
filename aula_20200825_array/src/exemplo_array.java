import java.util.Scanner;
class exemplo_array {
	public static void main(String args[]) {
		Scanner ler = new Scanner(System.in);
		float notas[][] = new float[3][3];
		float media1 = 0;
		float media2 = 0;
		float media3 = 0;
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				if (i == 0) {
					System.out.println("Digite a nota " + (j + 1) + " do primeiro aluno:");
				} else if (i == 1) {
					System.out.println("Digite a nota " + (j + 1) + " do segundo aluno:");
				}
				if (i == 2) {
					System.out.println("Digite a nota " + (j + 1) + " do terceiro aluno:");
				}
				notas[i][j] = ler.nextFloat();
			}
		}
		ler.close();
		System.out.println("As notas foram cadastradas");
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				if (i == 0) {
					media1 = ((notas[0][0]) + (notas[0][1]) + (notas[0][2])) / 3;
				} else if (i == 1) {
					media2 = ((notas[1][0]) + (notas[1][1]) + (notas[1][2])) / 3;
				}
				if (i == 2) {
					media3 = ((notas[2][0]) + (notas[2][1]) + (notas[2][2])) / 3;
				}
			}
		}
		System.out.printf("Média do primeiro aluno: %.2f%n", media1);
		System.out.printf("Média do segundo aluno: %.2f%n", media2);
		System.out.printf("Média do terceiro aluno: %.2f%n", media3);
		System.out.printf("Média do terceiro aluno: %.2f%n", (media1+media2+media3)/3);
	}
}