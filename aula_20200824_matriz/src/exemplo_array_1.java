class exemplo_array_1 {
	public static void main(String args[]) {

		int elementos[] = new int[5];

		for (int contador = 0; contador < elementos.length; contador++) {
			elementos[contador] = contador + 1;
		}
			
		for(int contador = 0; contador < elementos.length; contador++) {
			System.out.println(elementos[contador]);
		}

		for(int contador = elementos.length-1; contador >=0; contador--) {
			System.out.println(elementos[contador]);
		}

		}
	}