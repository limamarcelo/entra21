package entities;

public class Client {

	
	//Ordernar Cliente por nome e cpf (crescente) e por idade e divida(crescente e decrescente).
	private String name;
	private String cpf;
	private int age;
	private double debt;
	
	public Client() {
	}
	
	public Client(String name, String cpf, int age, double debt) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.debt = debt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}	
}