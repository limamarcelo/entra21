import java.util.Locale;
import java.util.Scanner;

public class aluno_apro_repro {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Double n1, n2, n3, n4, nf, p1, p2, p3, p4;
		Scanner sc = new Scanner(System.in);
		System.out.println("Cálculo Média Ponderada do Aluno e Resultado");
		System.out.println("Digite as notas e pesos entre 0 e 10");
		System.out.println("Digite a primeira nota");
		n1 = sc.nextDouble();
		if (!(n1 < 0 || n1 > 10)) { // (! ) para inverter a consulta de verdadeiro para falso vice versa
			System.out.println("Digite o peso para a primeira nota");
			p1 = sc.nextDouble();
			if (!(p1 > 10 || p1 < 0)) {
				System.out.println("Digite a segunda nota");
				n2 = sc.nextDouble();
				if (!(n2 < 0 || n2 > 10)) { // (! ) para inverter a consulta de verdadeiro para falso vice versa
					System.out.println("Digite o peso para a segunda nota");
					p2 = sc.nextDouble();
					if (!(p2 > 10 || p2 < 0)) {
						System.out.println("Digite a terceira nota");
						n3 = sc.nextDouble();
						if (!(n3 > 10 || n3 < 0)) {
							System.out.println("Digite o peso para a terceira nota");
							p3 = sc.nextDouble();
							if (!(p3 > 10 || p3 < 0)) {
								System.out.println("Digite a quarta nota");
								n4 = sc.nextDouble();
								if (!(n4 > 10 || n4 < 0)) {
									System.out.println("Digite o peso para a quarta nota");
									p4 = sc.nextDouble();
									if (!(p4 > 10 || p4 < 0)) {
										nf = (n1 * p1 + n2 * p2 + n3 * p3 + n4 * p4) / (p1 + p2 + p3 + p4);
										if (nf >= 7) {
											System.out.printf(
													"A nota ponderada do aluno é de %.2f. O aluno foi aprovado!", nf);
										} else {
											System.out.printf(
													"A nota ponderada do aluno é de %.2f. O aluno foi reprovado!", nf);
										}
									} else {
										System.out.println("Peso Menor que 0 ou Maior que 10");
										System.out.println("Digite novamente o peso da quarta nota");
										p4 = sc.nextDouble();
									}
								} else {
									System.out.println("Nota Menor que 0 ou Maior que 10");
									System.out.println("Digite novamente a quarta nota");
									n4 = sc.nextDouble();
								}
							} else {
								System.out.println("Peso Menor que 0 ou Maior que 10");
								System.out.println("Digite novamente o peso da terceira nota");
								p3 = sc.nextDouble();
							}
						} else {
							System.out.println("Nota Menor que 0 ou Maior que 10");
							System.out.println("Digite novamente a terceira nota");
							n3 = sc.nextDouble();
						}
					} else {
						System.out.println("Peso Menor que 0 ou Maior que 10");
						System.out.println("Digite novamente o peso da segunda nota");
						p2 = sc.nextDouble();
					}
				} else {
					System.out.println("Nota Menor que 0 ou Maior que 10");
					System.out.println("Digite novamente a segunda nota");
					n2 = sc.nextDouble();
				}
			} else {
				System.out.println("Peso Menor que 0 ou Maior que 10");
				System.out.println("Digite novamente o peso da primeira nota");
				p1 = sc.nextDouble();
			}
		} else {
			System.out.println("Nota Menor que 0 ou Maior que 10");
			System.out.println("Digite novamente a primeira nota");
			n1 = sc.nextDouble();
		}
		sc.close();
	}
}