package aula081020.comparador.cpf;

import java.util.Comparator;

import aula081020.cliente.Cliente;

public class CpfAscendenteComparator implements Comparator<Cliente> {

	public int compare(Cliente cliente1, Cliente cliente2) {
		return cliente1.getCpf().compareTo(cliente2.getCpf());
	}
}