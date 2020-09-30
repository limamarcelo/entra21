package entities;

public class PessoaJuridica extends Pessoa{

	public PessoaJuridica(String nome, double provento) {
		super(nome, provento);
	}
	

	@Override
	public double calcularImposto() {
		return getProvento() * 0.1;
	}

}
