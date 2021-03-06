package entities;

public class Triangulo implements FiguraGeometrica {

	private double base;
	private double altura;
	private double lado;

	public Triangulo(double lado, double base, double altura) {
		setBase(base);
		setAltura(altura);
		setLado(lado);
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getBase() {
		return base;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getLado() {
		return lado;
	}

	public double calcularArea() {
		return base * altura / 2;
	}

	public double calcularPerimetro() {
		return 3 * lado;
	}
}