package aula_01092020;
class Carro {

	// atributo = vari�veis
	String chassi;
	String placa;
	String modelo;
	int ano;

	// construtor padr�o que n�o precisa ser declarado se n�o declarar e criar um
	// novo carro fica null por n�o exigir o lan�amento das informa��es
	// public Carro() {
	// }
	
	// construtor com quatro par�metros
	public Carro(String chassi, String placa, String modelo, int ano) {
		this.chassi = chassi;
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;

	}

	// abaixo para exeplica��o
	// public Carro() {
	// chassi = new String();
	// placa = new String();
	// modelo = new String();
	// ano = 0;
	// }

	// m�todo = sub-rotinas
	
	public Carro() {
		this.buzinar();
	}
	
	public void buzinar() {
		System.out.println("bibi");
	}
}