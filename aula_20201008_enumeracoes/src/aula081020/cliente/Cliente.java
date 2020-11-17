package aula081020.cliente;

public class Cliente {

	private String nome;
	private String cpf;
	private int idade;
	private double divida;

	public Cliente(String nome, String cpf, int idade, double divida) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setDivida(divida);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getDivida() {
		return divida;
	}

	public void setDivida(double divida) {
		this.divida = divida;
	}
}