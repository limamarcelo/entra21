package entities;

import execptions.LadoInvalidoException;

public class TrapezioIsosceles extends Trapezios {

	public TrapezioIsosceles(double ladoA, double baseMaior, double ladoB, double baseMenor, double altura)
			throws LadoInvalidoException {
		super(ladoA, baseMaior, ladoB, baseMenor, altura);
	}

	public String toString() {
		return 	"O Trap�zio Is�sceles com laterais de tamanho: "
				+ getLadoA()
				+ ", e base Maior de: "
				+ getLadoB()
				+ " e base Menor de: "
				+ getLadoD()
				+ ", tem a �rea de: "
				+ calcularArea();
	}
	
	public String stringPerimetro() {
		return 	"O Trap�zio Is�sceles com laterais de tamanho: "
				+ getLadoA()
				+ ", e base Maior de: "
				+ getLadoB()
				+ " e base Menor de: "
				+ getLadoD()
				+ ", tem o per�metro de: "
				+ calcularPerimetro();
	}

}