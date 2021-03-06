package entities;

public class Quadrado implements FiguraGeometrica{

	private double lado;

	public Quadrado(double lado) {
		setLado(lado);
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getLado() {
		return this.lado;
	}

	public double calcularArea() {
		return lado * lado;
	}

	public double calcularPerimetro() {
		return lado * 4;
	}

}