package aula_01092020_exercicio;

class Arvore {
	private String nome;
	private String reino;
	private String classe;
	private String familia;
	private String ordem;
	private float altMin;
	private float altMax;
	//https://www.sobiologia.com.br/conteudos/Seresvivos/Ciencias/classifiseresvivos2.php
	
	
	public Arvore(String nome, String reino, String classe, String familia, String ordem, float altMin, float altMax) {
		this.nome = nome;
		this.reino = reino;
		this.classe = classe;
		this.familia = familia;
		this.ordem = ordem;
		this.altMax = altMax;
		this.altMin = altMin;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getReino() {
		return this.reino;
	}

	public void setReino(String reino) {
		this.reino = reino;
	}

	public String getClasse() {
		return this.classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getFamilia() {
		return this.familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getOrdem() {
		return this.ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}

	public float getAltMin() {
		return this.altMin;
	}

	public void setAltMin(float altMin) {
		this.altMin = altMin;
	}

	public float getAltMax() {
		return this.altMax;
	}

	public void setAltMax(float altMax) {
		this.altMax = altMax;
	}

	public Arvore() {
		this.nFruta();
	}

	public void nFruta() {
		System.out.println("Não dá fruto");
	}
}