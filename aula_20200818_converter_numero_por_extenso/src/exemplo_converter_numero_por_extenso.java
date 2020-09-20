class exemplo_converter_numero_por_extenso {
	public static void main(String args[]) {

		int numero = 111;
		String valorPorExtenso = "";

		int centena;
		int dezena;
		int unidade;

		centena = numero / 100;
		dezena = (numero % 100) / 10;
		unidade = numero % 10;

		switch (centena) {
		case 1:
			valorPorExtenso = "Cento ";
			break;

		case 2:
			valorPorExtenso = "Duzentos ";
			break;

		case 3:
			valorPorExtenso = "Trezentos ";
			break;

		case 4:
			valorPorExtenso = "Quatrocentos ";
			break;

		case 5:
			valorPorExtenso = "Quinhentos ";
			break;

		case 6:
			valorPorExtenso = "Seissentos ";
			break;

		case 9:
			valorPorExtenso = "Novecentos ";
			break;
			
			}
		if (dezena > 0) {
			valorPorExtenso = valorPorExtenso + "e ";
		}
			if (dezena == 1 && unidade > 0) {
				switch (unidade) {
				case 1:
					valorPorExtenso = valorPorExtenso + "Onze ";
					break;
				case 2:
					valorPorExtenso = valorPorExtenso + "Doze ";
					break;
				case 3:
					valorPorExtenso = valorPorExtenso + "Treze ";
					break;
				case 4:
					valorPorExtenso = valorPorExtenso + "Quatorze ";
					break;
				case 5:
					valorPorExtenso = valorPorExtenso + "Quinze ";
					break;
				case 6:
					valorPorExtenso = valorPorExtenso + "Dezesseis ";
					break;
				case 7:
					valorPorExtenso = valorPorExtenso + "Dezessete ";
					break;
				case 8:
					valorPorExtenso = valorPorExtenso + "Dezoito ";
					break;
				case 9:
					valorPorExtenso = valorPorExtenso + "Dezenove ";
					break;
				}
			} else {
				switch (dezena) {
				case 1:
					valorPorExtenso = valorPorExtenso + "dez ";
					break;

				case 2:
					valorPorExtenso = valorPorExtenso + "vinte ";
					break;

				case 3:
					valorPorExtenso = valorPorExtenso + "trinta ";
					break;

				case 4:
					valorPorExtenso = valorPorExtenso + "quarenta ";
					break;

				case 5:
					valorPorExtenso = valorPorExtenso + "cinquenta ";
					break;

				case 6:
					valorPorExtenso = valorPorExtenso + "sessenta ";
					break;
				case 7:
					valorPorExtenso = valorPorExtenso + "setenta ";
					break;
				case 8:
					valorPorExtenso = valorPorExtenso + "oitenta ";
					break;
				case 9:
					valorPorExtenso = valorPorExtenso + "noventa ";
					break;

				}
				if (dezena > 0) {
					valorPorExtenso = valorPorExtenso + "e ";
				}
			

			switch (unidade) {
			// case 0:
			// valorPorExtenso = "zero ";
			// break;
			case 1:
				valorPorExtenso = valorPorExtenso + "Um ";
				break;

			case 2:
				valorPorExtenso = valorPorExtenso + "Dois ";
				break;

			case 3:
				valorPorExtenso = valorPorExtenso + "Três ";
				break;

			case 4:
				valorPorExtenso = valorPorExtenso + "Quatro ";
				break;

			case 5:
				valorPorExtenso = valorPorExtenso + "Cinco ";
				break;

			case 6:
				valorPorExtenso = valorPorExtenso + "Seis ";
				break;
			case 7:
				valorPorExtenso = valorPorExtenso + "Sete ";
				break;
			case 8:
				valorPorExtenso = valorPorExtenso + "Oito ";
				break;
			case 9:
				valorPorExtenso = valorPorExtenso + "Nove ";
				break;

			}

			}
			
		String real = (numero > 1) ? "Reais" : "Real";

		System.out.println(centena);
		System.out.println(dezena);
		System.out.println(unidade);
		System.out.println(valorPorExtenso + real);
	}

}