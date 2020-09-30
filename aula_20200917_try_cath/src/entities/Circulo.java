package entities;

public class Circulo implements FiguraGeometrica {

	private double raio;

	public Circulo(double raio) {
		setArea(raio);
	}

	public void setArea(double raio) {
		this.raio = raio;
	}

	public double getArea() {
		return this.raio;
	}

	public double calcularArea() {
		return Math.PI * raio * raio;
	}

	public double calcularPerimetro() {
		return 2 * Math.PI * raio;
	}

}
