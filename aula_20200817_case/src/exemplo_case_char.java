class exemplo_case_char {
	public static void main(String args[]) {

		char genero = 'l';

		switch (genero) {
		case 'm':
			System.out.println("O genero eh masculino");
			break;
		case 'f':
			System.out.println("O genero eh feminino");
			break;

		default:
			System.out.println("O genero recuperado do banco de dados nao foi classificado previamente.");

		}
	}
}
