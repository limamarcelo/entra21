package application;

import java.util.ArrayList;
import java.util.Collections;

import comparators.AgeAscComparator;
import comparators.AgeDescComparator;
import comparators.CpfComparator;
import comparators.DebtAscComparator;
import comparators.DebtDescComparator;
import comparators.NameComparator;
import entities.Client;

public class Program {

	public static void main(String[] args) {

		ArrayList<Client> customers = new ArrayList<>();

		Client client1 = new Client("Victor", "444.555.666-77", 23, 50000.00);
		Client client2 = new Client("Marcelo", "222.333.444-88", 35, 35000.00);
		Client client3 = new Client("Marco", "111.444.555-66", 25, 10000.00);

		customers.add(client1);
		customers.add(client2);
		customers.add(client3);

		System.out.println("Os dados dos clientes ordenado por ordem de cadastro são: \n");

		for (int i = 0; i < customers.size(); i++) {

			Client client = customers.get(i);
			System.out.println("O nome do cliente é: " + client.getName());
			System.out.println("O CPF do cliente é: " + client.getCpf());
			System.out.println("A idade do cliente é: " + client.getAge());
			System.out.println("A dívida do cliente é: " + client.getDebt());

			System.out.println();
		}

		Collections.sort(customers, new NameComparator());
		System.out.println("Os dados dos clientes ordenados por ordem crescente de nome são: \n");

		for (int i = 0; i < customers.size(); i++) {

			Client client = customers.get(i);
			System.out.println("O nome do cliente é: " + client.getName());
			System.out.println("O CPF do cliente é: " + client.getCpf());
			System.out.println("A idade do cliente é: " + client.getAge());
			System.out.println("A dívida do cliente é: " + client.getDebt());

			System.out.println();
		}

		Collections.sort(customers, new CpfComparator());
		System.out.println("Os dados dos clientes ordenados por ordem crescente de cpf são: \n");

		for (int i = 0; i < customers.size(); i++) {

			Client client = customers.get(i);
			System.out.println("O nome do cliente é: " + client.getName());
			System.out.println("O CPF do cliente é: " + client.getCpf());
			System.out.println("A idade do cliente é: " + client.getAge());
			System.out.println("A dívida do cliente é: " + client.getDebt());

			System.out.println();
		}

		Collections.sort(customers, new AgeAscComparator());
		System.out.println("Os dados dos clientes ordenados por ordem crescente de idade são: \n");

		for (int i = 0; i < customers.size(); i++) {

			Client client = customers.get(i);
			System.out.println("O nome do cliente é: " + client.getName());
			System.out.println("O CPF do cliente é: " + client.getCpf());
			System.out.println("A idade do cliente é: " + client.getAge());
			System.out.println("A dívida do cliente é: " + client.getDebt());

			System.out.println();
		}

		Collections.sort(customers, new AgeDescComparator());
		System.out.println("Os dados dos clientes ordenados por ordem decrescente de idade são: \n");

		for (int i = 0; i < customers.size(); i++) {

			Client client = customers.get(i);
			System.out.println("O nome do cliente é: " + client.getName());
			System.out.println("O CPF do cliente é: " + client.getCpf());
			System.out.println("A idade do cliente é: " + client.getAge());
			System.out.println("A dívida do cliente é: " + client.getDebt());

			System.out.println();
		}

		Collections.sort(customers, new DebtAscComparator());
		System.out.println("Os dados dos clientes ordenados por ordem crescente de débito são: \n");

		for (int i = 0; i < customers.size(); i++) {

			Client client = customers.get(i);
			System.out.println("O nome do cliente é: " + client.getName());
			System.out.println("O CPF do cliente é: " + client.getCpf());
			System.out.println("A idade do cliente é: " + client.getAge());
			System.out.println("A dívida do cliente é: " + client.getDebt());

			System.out.println();
		}

		Collections.sort(customers, new DebtDescComparator());
		System.out.println("Os dados dos clientes ordenados por ordem decrescente de débito são: \n");

		for (int i = 0; i < customers.size(); i++) {

			Client client = customers.get(i);
			System.out.println("O nome do cliente é: " + client.getName());
			System.out.println("O CPF do cliente é: " + client.getCpf());
			System.out.println("A idade do cliente é: " + client.getAge());
			System.out.println("A dívida do cliente é: " + client.getDebt());

			System.out.println();
		}

	}
}