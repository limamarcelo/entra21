package entities;

public class Carro extends Veiculo {
	public Carro(String chassi, String placa, String modelo, String cor, int portas, int ano) {
		super(chassi, placa, modelo, cor, portas, ano);
	}

	public void buzinar() {
		System.out.println("BiiiiBiiii");
	}
}
