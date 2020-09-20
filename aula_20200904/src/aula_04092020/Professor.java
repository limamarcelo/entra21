package aula_04092020;

public class Professor{

	private String nome;
	private int idade;

	public Professor(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
		}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
		/*
		
		if (idade >=0) {
			this.idade = idade;
		}else {
			System.out.println("Informe uma idade válida");
		}
		//paramos aqui.*/
	}

}
