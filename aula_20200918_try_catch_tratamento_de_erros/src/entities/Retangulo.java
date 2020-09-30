package entities;

import execptions.LadoInvalidoException;

public class Retangulo extends Quadrilatero {

	public Retangulo(double base, double altura) throws LadoInvalidoException {
		super(base, altura, base, altura);
	}

	public double calcularArea() {
		return getLadoA() * getLadoB();
	}

	public double calcularPerimetro() {
		return 2 * (getLadoA() + getLadoB());
	}
	
	public String toString() {
		return 	"O ret�ngulo com lado A de tamanho: "
				+ getLadoA()
				+ "e lado B de tamanho: "
				+ getLadoB()
				+ ", tem a �rea de: "
				+ calcularArea();
	}
	
	public String stringPerimetro() {
		return 	"O ret�ngulo com lado A de tamanho: "
				+ getLadoA()
				+ "e lado B de tamanho: "
				+ getLadoB()
				+ ", tem o perimetro de: "
				+ calcularPerimetro();
	}

}
