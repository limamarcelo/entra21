package entities;

public abstract class Animal {

	private String especie;
	private double peso;

	public Animal(String especie, double peso) {
		setEspecie(especie);
		setPeso(peso);
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public abstract void emitirSom();
}