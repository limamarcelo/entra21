package entities;

public abstract class Quadrilatero implements FiguraGeometrica {

	private double ladoA;
	private double ladoB;
	private double ladoC;
	private double ladoD;

	public Quadrilatero(double ladoA, double ladoB, double ladoC, double ladoD) {
		setLadoA(ladoA);
		setLadoB(ladoB);
		setLadoC(ladoC);
		setLadoD(ladoD);

	}

	public void setLadoA(double ladoA) {
		this.ladoA = ladoA;
	}

	public double getLadoA() {
		return ladoA;
	}

	public void setLadoB(double ladoB) {
		this.ladoB = ladoB;
	}

	public double getLadoB() {
		return ladoB;
	}

	public void setLadoC(double ladoC) {
		this.ladoC = ladoC;
	}

	public double getLadoC() {
		return ladoC;
	}

	public void setLadoD(double ladoD) {
		this.ladoD = ladoD;
	}

	public double getLadoD() {
		return ladoD;
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