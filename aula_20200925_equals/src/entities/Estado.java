package entities;

import java.util.ArrayList;
import java.util.List;

public class Estado {

	private String nome;
	private ArrayList<Cidade> cidades;
	
	public Estado() {
	}
	
	public Estado(String nome) {
		setNomeEstado(nome);
		cidades = new ArrayList<Cidade>();
	}
	
	public String getNomeEstado() {
		return this.nome;
	}
	
	public void setNomeEstado(String nome) {
		this.nome = nome;
	}
	
	public List<Cidade> getCidade(){
		return cidades;
	}
	
	public boolean adicionarCidade(Cidade cidade) {
		return cidades.add(cidade);
	}
	
	public boolean removerCidade(Cidade cidade) {
		return cidades.remove(cidade);
	}
	
	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != objeto.getClass())
			return false;

		Estado estado = (Estado) objeto;

		// abaixo n�o d� para comparar com != o cnpj pois o pessoa.getCnpj() � do tipo
		// PessoaJuridica e o outro uma String n�o do tipo primitivo ent�o tem que
		// comparar utilizando o equals
		if (!(getNomeEstado().equals(estado.getNomeEstado())))
			return false;

		return true;
	}
	
	public String toString() {
		return nome;
	}
}