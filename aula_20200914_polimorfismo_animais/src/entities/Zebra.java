package entities;

public class Zebra extends AnimalSilvestre {

	public Zebra(String especie, double peso) {
		super(especie, peso);

	}

	public void emitirSom() {
		System.out.println("relinchar");
	}
}