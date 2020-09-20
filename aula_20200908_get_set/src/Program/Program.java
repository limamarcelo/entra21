package Program;

import entities.Carro;
import entities.Motocicleta;

public class Program {

	public static void main(String[] args) {
		
		Carro carro = new Carro("jnsf763jcnd", "QJC-2828", "Grand Siena", "Vermelha", 4, 2018 );
		System.out.println(carro.getChassi());
		System.out.println(carro.getPlaca());
		System.out.println(carro.getModelo());
		System.out.println(carro.getAno());
		System.out.println(carro.getCor());
		System.out.println(carro.getPortas());
		carro.buzinar();
		
		Motocicleta motocicleta = new Motocicleta("jnsf763jcnd", "QJC-2828", "Grand Siena", "Vermelha", 0, 2018 );
		System.out.println(motocicleta.getChassi());
		System.out.println(motocicleta.getPlaca());
		System.out.println(motocicleta.getModelo());
		System.out.println(motocicleta.getAno());
		System.out.println(motocicleta.getCor());
		System.out.println(motocicleta.getPortas());
		motocicleta.buzinar();
	}
}