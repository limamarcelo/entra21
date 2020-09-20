package entities;

public class Retangulo extends Quadrilatero {

	public Retangulo(double base, double altura) {
		super(base, altura, base, altura);
	}

	public double calcularArea() {
		return getLadoA() * getLadoB();
	}

	public double calcularPerimetro() {
		return 2 * (getLadoA() + getLadoB());
	}
}
