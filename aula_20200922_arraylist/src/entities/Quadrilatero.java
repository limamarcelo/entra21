package entities;

import execptions.LadoInvalidoException;

public abstract class Quadrilatero implements FiguraGeometrica {

	private double ladoA;
	private double ladoB;
	private double ladoC;
	private double ladoD;

	public Quadrilatero(double ladoA, double ladoB, double ladoC, double ladoD) throws LadoInvalidoException {
		setLadoA(ladoA);
		setLadoB(ladoB);
		setLadoC(ladoC);
		setLadoD(ladoD);

	}

	public void setLadoA(double ladoA) throws LadoInvalidoException {

		if (ladoA <= 0) {
			throw new LadoInvalidoException("O lado A � inv�lido.");
		}

		this.ladoA = ladoA;
	}

	public double getLadoA() {
		return ladoA;
	}

	public void setLadoB(double ladoB) throws LadoInvalidoException {

		if (ladoB <= 0) {
			throw new LadoInvalidoException("O lado B � inv�lido");
		}

		this.ladoB = ladoB;
	}

	public double getLadoB() {
		return ladoB;
	}

	public void setLadoC(double ladoC) throws LadoInvalidoException {

		if (ladoC <= 0) {
			throw new LadoInvalidoException("O lado C � inv�lido");
		}

		this.ladoC = ladoC;
	}

	public double getLadoC() {
		return ladoC;
	}

	public void setLadoD(double ladoD) throws LadoInvalidoException {

		if (ladoD <= 0) {
			throw new LadoInvalidoException("O lado D � inv�lido");
		}
		this.ladoD = ladoD;
	}

	public double getLadoD() {
		return ladoD;
	}

	public String toString() {
		return "O quadrado com lado A: " + getLadoA() + ", tem a �rea de: " + calcularArea();
	}

	public String stringPerimetroQuadrado() {
		return "O quadrado com lado A: " + getLadoA() + ", tem o perimetro de: " + calcularPerimetro();
	}

}