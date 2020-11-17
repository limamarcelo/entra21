package class_20201109_conversao_de_tipo_casting;

public class Program {

	public static void main(String[] args) {
		
		int idade = 10;
		System.out.println("Idade int: " + idade);
		
		long idade2 = idade;
		System.out.println("Idade int convertido para Long: " + idade2);

		long distancia = 9223372036854775807L;
		System.out.println("Distância Long: " + distancia);
		
		int distancia2 = (int)distancia;
		System.out.println("Distância Long convertido para int: " + distancia2);
	}
}