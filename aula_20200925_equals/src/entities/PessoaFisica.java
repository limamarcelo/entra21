package entities;

public class PessoaFisica extends Pessoa {

	private String cpf;

	public PessoaFisica(String nome, double provento, String cpf, Cidade cidade) {
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
		// abaixo n�o d� para comparar com != o cpf pois o pessoa.getCpf() � do tipo
		// PessoaFisica e o outro uma String n�o do tipo primitivo ent�o tem que
		// comparar utilizando o equals
		if (getProvento() != pessoa.getProvento() || !(getCpf().equals(pessoa.getCpf()) || !(getNome().equals(pessoa.getNome()))))
			return false;

		return true;
	}
	
	@Override
	public double calcularImposto() {
		return getProvento() * 0.02;
	}
}