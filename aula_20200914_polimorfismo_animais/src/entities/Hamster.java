package entities;

public class Hamster extends AnimalDomestico {

	Tutor tutor;

	public Hamster(String especie, double peso, String tutor) {
		super(especie, peso);
		getTutor();

	}

	public void emitirSom() {
		System.out.println("ringring");
	}
}