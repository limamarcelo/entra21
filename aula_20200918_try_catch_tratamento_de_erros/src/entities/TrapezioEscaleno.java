package entities;

import execptions.LadoInvalidoException;

public class TrapezioEscaleno extends TrapezioIsosceles {

	public TrapezioEscaleno(double ladoA, double baseMaior, double ladoB, double baseMenor, double altura)
			throws LadoInvalidoException {
		super(ladoA, baseMaior, ladoB, baseMenor, altura);
	}
}