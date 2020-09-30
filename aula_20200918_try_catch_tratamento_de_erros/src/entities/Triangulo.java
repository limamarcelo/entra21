package entities;

import execptions.LadoInvalidoException;

public class Triangulo implements FiguraGeometrica{

	private double base;
	private double altura;
	private double lado;

	public Triangulo(double lado, double base, double altura) throws LadoInvalidoException{
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
	
	public String toString() {
		return 	"O triângulo com lado A de tamanho: "
				+ getLado()
				+ "e com base de tamanho: "
				+ getBase()
				+ "e com altura de tamanho: "
				+ getAltura()
				+ ", tem a área de: "
				+ calcularArea();
	}
	
	public String stringPerimetro() {
		return 	"O triângulo com lado A de tamanho: "
				+ getLado()
				+ "e com base de tamanho: "
				+ getBase()
				+ "e com altura de tamanho: "
				+ getAltura()
				+ ", tem o perímetro de: "
				+ calcularPerimetro();
	}

}