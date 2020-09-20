package entities;

public class Motocicleta extends Veiculo{
	public Motocicleta(String chassi, String placa, String modelo, String cor, int portas, int ano) {
		super(chassi, placa, modelo, cor, portas, ano);
	}
	public void buzinar() {
		System.out.println("BeeeBeee");
	}
}
