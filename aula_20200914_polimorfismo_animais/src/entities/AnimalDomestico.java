package entities;

public abstract class AnimalDomestico extends Animal {

	private Tutor tutor;

	public AnimalDomestico(String especie, double peso) {
		super(especie, peso);
		setTutor(tutor);
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
}