package entities;

public class Cachorro extends AnimalDomestico {

	Tutor tutor;

	public Cachorro(String especie, double peso, String tutor) {
		super(especie, peso);
		getTutor();

	}

	public void emitirSom() {
		System.out.println("latir");
	}
}