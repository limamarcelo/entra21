class exemplo_array_2 {
	public static void main(String args[]) {

		int notas[] = new int[30];

//		int pos = 10;
//		notas[pos] = 1;

		for (int contador = 0; contador < notas.length; contador++) {
			notas[contador] = contador * 3;
		}
		for (int contador = 0; contador < notas.length; contador++) {
			notas[contador] = contador * 2;
			System.out.println(notas[contador]);
		}
	}
}