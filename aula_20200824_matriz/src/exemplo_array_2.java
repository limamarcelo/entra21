class exemplo_array_2 {
	public static void main(String args[]) {

		int foto[][] = new int[5][5];
		int contador = 1;
		for (int i = 0; i < foto.length; i++) {

			for (int j = 0; j < foto[i].length; j++) {

				foto[i][j] = contador;
				contador ++;

				System.out.print(foto[i][j]);
			}
			System.out.print("\n");
		}
	}
}