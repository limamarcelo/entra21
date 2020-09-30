package entities;

public class PessoaJuridica extends Pessoa {

	private String cnpj;

	public PessoaJuridica(String nome, double provento, String cnpj) {
		super(nome, provento);
		setCnpj(cnpj);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != objeto.getClass())
			return false;

		PessoaJuridica pessoa = (PessoaJuridica) objeto;

		// abaixo n�o d� para comparar com != o cnpj pois o pessoa.getCnpj() � do tipo
		// PessoaJuridica e o outro uma String n�o do tipo primitivo ent�o tem que
		// comparar utilizando o equals
		if (getProvento() != pessoa.getProvento() || !(getCnpj().equals(pessoa.getCnpj())))
			return false;

		return true;
	}

	@Override
	public double calcularImposto() {
		return getProvento() * 0.1;
	}
}