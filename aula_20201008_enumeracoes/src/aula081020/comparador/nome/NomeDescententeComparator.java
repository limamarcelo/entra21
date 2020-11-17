package aula081020.comparador.nome;

import java.util.Comparator;

import aula081020.cliente.Cliente;

public class NomeDescententeComparator implements Comparator<Cliente> {

	public int compare(Cliente cliente1, Cliente cliente2) {
		return cliente1.getNome().compareTo(cliente2.getNome()) * -1;
	}
}