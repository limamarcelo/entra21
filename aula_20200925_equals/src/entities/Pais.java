package entities;

import java.util.ArrayList;
import java.util.List;

public class Pais {

	private String nome;
	private ArrayList<Estado> estados;
	
	public Pais() {
	}
	
	public Pais(String nome) {
		setNomePais(nome);
		estados = new ArrayList<Estado>();
	}
	
	public String getNomePais() {
		return this.nome;
	}
	
	public void setNomePais(String nome) {
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

		// abaixo n�o d� para comparar com != o cnpj pois o pessoa.getCnpj() � do tipo
		// PessoaJuridica e o outro uma String n�o do tipo primitivo ent�o tem que
		// comparar utilizando o equals
		if (!(getNomePais().equals(pais.getNomePais())))
			return false;

		return true;
	}
	
	public String toString() {
		return nome;
	}
}