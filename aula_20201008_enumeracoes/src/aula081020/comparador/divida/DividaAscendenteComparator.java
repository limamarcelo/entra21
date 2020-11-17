package aula081020.comparador.divida;

import java.util.Comparator;

import aula081020.cliente.Cliente;

public class DividaAscendenteComparator implements Comparator<Cliente> {

	public int compare(Cliente cliente1, Cliente cliente2) {

		if (cliente1.getDivida() > cliente2.getDivida())
			return 1;

		if (cliente1.getDivida() < cliente2.getDivida())
			return -1;

		return 0;
	}
}