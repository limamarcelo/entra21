
class exemplo_array_1 {
	public static void main(String args[]) {

		int notas[] = new int[30];

		for (int contador = 0; contador < notas.length; contador++) {
			notas[contador] = contador * 2;
		}

		for (int nota : notas) {
			System.out.println(nota + 1);
		}

	}
}
