package entities;

public class PessoaFisica extends Pessoa{

	
	
	public PessoaFisica(String nome, double provento) {
		super(nome, provento);
	}

	@Override
	public double calcularImposto() {
		return getProvento() * 0.02;
	}
}
