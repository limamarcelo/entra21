package entities;

public class Paralelograma implements FiguraGeometrica{

	private double base;
	private double altura;
	
	public Paralelograma(double base, double altura) {
		setBase(base);
		setAltura(altura);
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
	
	public double calcularArea() {
		return base * altura;
	}
	
	public double calcularPerimetro() {
		return 2 * (base + altura);
	}
}