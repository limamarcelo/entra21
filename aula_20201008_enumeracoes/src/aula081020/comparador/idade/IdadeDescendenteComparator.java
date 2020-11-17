package aula081020.comparador.idade;

import java.util.Comparator;

import aula081020.cliente.Cliente;

public class IdadeDescendenteComparator implements Comparator<Cliente> {

	public int compare(Cliente cliente1, Cliente cliente2) {

		if (cliente1.getIdade() > cliente2.getIdade())
			return -1;

		if (cliente1.getIdade() < cliente2.getIdade())
			return 1;

		return 0;
	}
}