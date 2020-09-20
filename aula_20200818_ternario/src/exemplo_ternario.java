

class exemplo_ternario {
	public static void main(String args[]) {
		double salario = 1000;
		double bonus = 0;

		bonus = (salario > 1000) ? 0.25 : 0.10;
		salario = (salario * bonus) + salario;

		System.out.println("Salario = " + salario);
	}
}