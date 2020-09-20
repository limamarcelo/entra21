package aula_01092020;
class Carro {

	// atributo = variáveis
	String chassi;
	String placa;
	String modelo;
	int ano;

	// construtor padrão que não precisa ser declarado se não declarar e criar um
	// novo carro fica null por não exigir o lançamento das informações
	// public Carro() {
	// }
	
	// construtor com quatro parâmetros
	public Carro(String chassi, String placa, String modelo, int ano) {
		this.chassi = chassi;
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;

	}

	// abaixo para exeplicação
	// public Carro() {
	// chassi = new String();
	// placa = new String();
	// modelo = new String();
	// ano = 0;
	// }

	// método = sub-rotinas
	
	public Carro() {
		this.buzinar();
	}
	
	public void buzinar() {
		System.out.println("bibi");
	}
}