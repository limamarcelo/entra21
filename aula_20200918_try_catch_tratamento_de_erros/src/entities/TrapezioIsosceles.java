package entities;

import execptions.LadoInvalidoException;

public class TrapezioIsosceles extends Trapezios {

	public TrapezioIsosceles(double ladoA, double baseMaior, double ladoB, double baseMenor, double altura)
			throws LadoInvalidoException {
		super(ladoA, baseMaior, ladoB, baseMenor, altura);
	}

	public String toString() {
		return 	"O Trapézio Isósceles com laterais de tamanho: "
				+ getLadoA()
				+ ", e base Maior de: "
				+ getLadoB()
				+ " e base Menor de: "
				+ getLadoD()
				+ ", tem a área de: "
				+ calcularArea();
	}
	
	public String stringPerimetro() {
		return 	"O Trapézio Isósceles com laterais de tamanho: "
				+ getLadoA()
				+ ", e base Maior de: "
				+ getLadoB()
				+ " e base Menor de: "
				+ getLadoD()
				+ ", tem o perímetro de: "
				+ calcularPerimetro();
	}

}