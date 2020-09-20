package entities;

public class Veiculo {

	String chassi;
	String placa;
	String modelo;
	String cor;
	int portas;
	int ano;

	public Veiculo(String chassi, String placa, String modelo, String cor, int portas, int ano) {
		setChassi(chassi);
		setPlaca(placa);
		setModelo(modelo);
		setAno(ano);
		setCor(cor);
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void buzinar() {
		System.out.println("bibi");
	}

	public void buzinar(String texto) {
		System.out.println(texto);
	}
}