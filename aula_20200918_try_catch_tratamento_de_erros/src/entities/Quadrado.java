package entities;

import execptions.LadoInvalidoException;

public class Quadrado extends Quadrilatero {

	public Quadrado(double lado) throws LadoInvalidoException {
		// super est� chamando o construtor da classe pai
		super(lado, lado, lado, lado);
	}

	// usar m�todos de acesso getLadoA para calcular a �rea ou Per�metro do quadrado
	// pois s�o todos do mesmo tamanho.

	public double calcularArea() {
		return getLadoA() * getLadoA();
	}

	public double calcularPerimetro() {
		return getLadoA() * 4;
	}
	
	public String toString() {
		return 	"O quadrado com lado A: "
				+ getLadoA()
				+ ", tem a �rea de: "
				+ calcularArea();
	}
	
	public String stringPerimetroQuadrado() {
		return 	"O quadrado com lado A: "
				+ getLadoA()
				+ ", tem o perimetro de: "
				+ calcularPerimetro();
	}
}