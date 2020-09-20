package entities;

public class Gato extends AnimalDomestico {
	Tutor tutor;

	public Gato(String especie, double peso, String tutor) {
		super(especie, peso);
		getTutor();
	}

	public void emitirSom() {
		System.out.println("mia");
	}
}