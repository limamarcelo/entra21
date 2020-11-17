package entities;

import java.util.ArrayList;
import java.util.List;

public class Estado {

	private String nome;
	private ArrayList<Cidade> cidades;
	
	public Estado() {
	}
	
	public Estado(String nome) {
		setNome(nome);
		cidades = new ArrayList<Cidade>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
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
	
	public void adicionarHabitante(Cidade cidade, Pessoa habitante) {
		int indice = cidades.indexOf(cidade);
		cidades.get(indice).adicionarHabitante(habitante);
	}
	
	public void mudarHabitante(Cidade origem, Cidade destino, Pessoa habitante) {
		origem.removerHabitante(habitante);
		destino.adicionarHabitante(habitante);
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

		// comparar utilizando o equals
		if (!(getNome().equals(estado.getNome())))
			return false;
		return true;
	}
	
	public String toString() {
		return nome;
	}
}