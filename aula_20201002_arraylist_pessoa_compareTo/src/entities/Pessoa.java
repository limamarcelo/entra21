package entities;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private Integer idade;

	public Pessoa() {
	}

	public Pessoa(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return this.idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != objeto.getClass())
			return false;

		Pessoa pessoa = (Pessoa) objeto;
		if (!(getNome().equals(pessoa.getNome()) || !(getIdade().equals(pessoa.getIdade()))))
			return false;

		return true;
	}

 //compareTo por idade
	@Override
	public int compareTo(Pessoa pessoa) {

		if (this.getIdade() < pessoa.getIdade())
			return -1;

		if (this.getIdade() < pessoa.getIdade())
			return 1;
		return 0;
	}
	
	
/*	
	//compareTo com nome
	@Override
	public int compareTo(Pessoa pessoa) {

		return getNome().compareTo(pessoa.getNome());
	}
*/	

/*	//compareTo por nome e idade
	@Override
		public int compareTo(Pessoa pessoa) {

			if (this.getIdade() < pessoa.getIdade() && getNome().compareTo(pessoa.getNome()))
				return -1;

			if (this.getIdade() < pessoa.getIdade() && getNome().compareTo(pessoa.getNome()))
				return 1;
			return 0;
		}
*/
}