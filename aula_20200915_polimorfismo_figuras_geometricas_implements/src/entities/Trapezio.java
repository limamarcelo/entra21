package entities;

public class Trapezio implements FiguraGeometrica {

	private double area;
	private double baseMaior;
	private double baseMenor;
	private double altura;
	private double lado1;
	private double lado2;

	public Trapezio(double area, double baseMaior, double baseMenor, double lado1, double lado2, double altura, double perimetro) {
		setArea(area);
		setBaseMaior(baseMaior);
		setBaseMenor(baseMenor);
		setAltura(altura);
		setLado1(lado1);
		setLado2(lado2);
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getArea() {
		return area;
	}

	public void setBaseMaior(double baseMaior) {
		this.baseMaior = baseMaior;
	}

	public double getBaseMaior() {
		return baseMaior;
	}

	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}

	public double getBaseMenor() {
		return baseMenor;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado1() {
		return lado1;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	public double getLado2() {
		return lado2;
	}

	public double calcularArea() {
		return (baseMaior + baseMenor) / 2 * altura;
	}

	public double calcularPerimetro() {
		return baseMaior + baseMenor + lado1 + lado2;
	}
}