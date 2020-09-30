package entities;

public abstract class Pessoa {

	private String nome;
	private double provento;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, double provento) {
		this.nome = nome;
		this.provento = provento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getProvento() {
		return this.provento;
	}

	public void setProvento(double provento) {
		this.provento = provento;
	}
	
	public abstract double calcularImposto();
	
	public String toString() {
		return 	nome
				+", Provento: "
				+ provento; 
	}
	
}
