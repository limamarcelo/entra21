package aula_01092020;
class aula_01092020_main {
	public static void main(String[] args) {
		// Carro = Classe
		// meuCarro = variável

		Carro meuCarro = new Carro("23asfcd", "abc-1234", "Grand Siena", 2020);
		Carro outroCarro = new Carro("68fsd8", "def-5678", "Fusca", 1965);

		meuCarro.ano = 2018;
		outroCarro.ano = 1966;
		
		System.out.println("Chassi: " + meuCarro.chassi + ", Placa: " + meuCarro.placa+ ", Modelo: " + meuCarro.modelo + ", Ano: "+ meuCarro.ano);
		System.out.println("Chassi: " + outroCarro.chassi + ", Placa: " + outroCarro.placa+ ", Modelo: " + outroCarro.modelo + ", Ano: "+ outroCarro.ano);
		
		//explicação de lançamento para cada atributo;
		//Carro meuCarro = new Carro();

		//meuCarro.modelo = "Grand Siena";
		//meuCarro.placa = "QJC-2827";
		//meuCarro.chassi = "ksdnis8898dsjnjds998";
		//meuCarro.ano = 2018;

		//System.out.println(meuCarro.modelo);
		//System.out.println(meuCarro.placa);
		//System.out.println(meuCarro.chassi);
		//System.out.println(meuCarro.ano);
		//meuCarro.buzinar();

	}
}