package aula_04092020;

public class Aluno {

	private String nome;
	private int idade;

	public Aluno(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
		}
/*	
	public float calcularMedia() {
		int somatorio = 0;
		for (int i = 0; i < notas.length; i++) {
			somatorio += notas[i];
		}
		return somatorio / notas.length;

	}
*/	
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

	public void confirmarPresenca() {
		System.out.println("O aluno " + nome + " está presente!");
	}

}
