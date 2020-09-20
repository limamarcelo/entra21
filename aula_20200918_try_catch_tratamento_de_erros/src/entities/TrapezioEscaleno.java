package entities;

import execptions.LadoInvalidoException;

public class TrapezioEscaleno extends Quadrilatero {

	private double altura;

	public TrapezioEscaleno(double ladoA, double baseMaior, double ladoD, double baseMenor, double altura)
			throws LadoInvalidoException {
		super(ladoA, baseMaior, ladoD, baseMenor);
		setAltura(altura);
	}

	public void setAltura(double altura) throws LadoInvalidoException {
		if (altura <= 0) {
			throw new LadoInvalidoException("A altura é inválida");
		}

		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public double calcularArea() {
		return (getLadoB() + getLadoD()) / 2 * altura;
	}

	public double calcularPerimetro() {
		return getLadoA() + getLadoB() + getLadoC() + getLadoD();
	}
}