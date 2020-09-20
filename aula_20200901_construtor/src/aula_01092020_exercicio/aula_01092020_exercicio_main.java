package aula_01092020_exercicio;
class aula_01092020_exercicio_main {
	public static void main(String[] args) {
		
/* Criar uma classe que represente um objeto de algum dominio.
Essa classe deve ter pelo menos 3 atributos e 1 método. me enviar até a próxima aula.
*/

		Arvore pinheiro = new Arvore("Pinehiro", "Plantae", "Pinopsida", "‎Pinaceae", "‎Pinales", 45, 63);
		Arvore flamboyant = new Arvore("Flamboyant", "Plantae", "Magnoliopsida", "Fabaceae", "Fabales", 7, 10);
		
		System.out.println("Nome: " + pinheiro.getNome() + ", Reino: " + pinheiro.getReino() + ", Classe: " + pinheiro.getClasse() + ", Familia: " + pinheiro.getFamilia() + ", Ordem: " + pinheiro.getOrdem() + ", Altura Mínima: " + pinheiro.getAltMin() + ", Altura Máxima: " + pinheiro.getAltMax());
		pinheiro.nFruta();
		System.out.println("Nome: " + flamboyant.getNome() + ", Reino: " + flamboyant.getReino() + ", Classe: " + flamboyant.getClasse() + ", Familia: " + flamboyant.getFamilia() + ", Ordem: " + flamboyant.getOrdem() + ", Altura Mínima: " + flamboyant.getAltMin() + ", Altura Máxima: " + flamboyant.getAltMax());
		flamboyant.nFruta();
	}
}