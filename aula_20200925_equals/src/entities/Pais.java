package entities;

import java.util.ArrayList;
import java.util.List;

public class Pais {

	private String nome;
	private ArrayList<Estado> estados;
	
	public Pais() {
	}
	
	public Pais(String nome) {
		setNome(nome);
		estados = new ArrayList<Estado>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Estado> getEstado(){
		return estados;
	}
	
	public boolean adicionarEstado(Estado estado) {
		return estados.add(estado);
	}
	
	public boolean removerEstado(Estado estado) {
		return estados.remove(estado);
	}
	
	public boolean equals(Object objeto) {

		if (this == objeto)
			return true;

		if (objeto == null)
			return false;

		// this.getClass() ou getClass tanto faz.
		if (getClass() != objeto.getClass())
			return false;

		Pais pais = (Pais) objeto;

		// comparar utilizando o equals
		if (!(getNome().equals(pais.getNome())))
			return false;

		return true;
	}
	
	public String toString() {
		return nome;
	}
}