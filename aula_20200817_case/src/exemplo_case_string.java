class exemplo_case_string {
	public static void main(String args[]) {

		String genero = "masculino";

		switch (genero) {
		case "masculino":
			System.out.println("O genero eh masculino");
			break;
		case "feminino":
			System.out.println("O genero eh feminino");
			break;

		default:
			System.out.println("O genero recuperado do banco de dados nao foi classificado previamente.");

		}
	}
}
