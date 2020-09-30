package entities;

public class PessoaFisica extends Pessoa {

	private String cpf;

	public PessoaFisica(String nome, double provento, String cpf, Estado estado) {
		super(nome, provento);
		setCpf(cpf);
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != objeto.getClass())
			return false;

		PessoaFisica pessoa = (PessoaFisica) objeto;

		// abaixo não dá para comparar com != o cnpj pois o pessoa.getCnpj() é do tipo
		// PessoaJuridica e o outro uma String não do tipo primitivo então tem que
		// comparar utilizando o equals
		if (getProvento() != pessoa.getProvento() || !(getCpf().equals(pessoa.getCpf())))
			return false;

		return true;
	}

	@Override
	public double calcularImposto() {
		return getProvento() * 0.02;
	}
}