package br.com.puc.llp.prjArvoreGenealogica;

import java.util.ArrayList;
import java.util.List;

import br.com.puc.llp.dominio.ClassificaIMC;
import br.com.puc.llp.dominio.Cpf;
import br.com.puc.llp.dominio.Homem;
import br.com.puc.llp.dominio.Mulher;
import br.com.puc.llp.dominio.Parentesco;
import br.com.puc.llp.dominio.Pessoa;

public class Arvore {

	public static void main(String[] args) {

		/**
		 * DonaNeves e SirNeves sem pais, casamento,
		 *  filhos (Quico Pai e M�e da Chiquinha)
		 */

		Pessoa sirNeves = new Homem(Cpf.criarCPF(), "Sir Neves", 75);
		
		Pessoa donaNeves = new Mulher(Cpf.criarCPF(), "Dona Neves", 19, 75, 1.72);
		
		// executando o IMC
		if (donaNeves instanceof Mulher){
		
			double calcularIMC = ((Mulher) donaNeves).calcularIMC();
		
			ClassificaIMC classificaIMC = ((Mulher) donaNeves).classificaIMC(calcularIMC);
		
			System.out.println("IMC: " + calcularIMC + " Classifica��o: " + classificaIMC + " da pessoa " + donaNeves.getNome());		
		}		
		
		// casar		
		sirNeves.casar(donaNeves);
		
		
		registrarCasamento(sirNeves, donaNeves);
		
		// criando um filho
		Pessoa quicoPai = criarHomem("Quico Pai", 40);
		
		// criando uma filha
		Pessoa maeDaChiquinha = criarMulher("M�e da Chiquinha", 35,70,1.62);

		// adicionado os filhos em uma lista de filhos
		List<Pessoa> filhosDonaNevesESirNeves = new ArrayList<Pessoa>() {
			{
				add(quicoPai);
				add(maeDaChiquinha);
			}
		};

		// procriando 
		 sirNeves.terFilhos(donaNeves, filhosDonaNevesESirNeves);

		// exibir a hist�ria de vida do casal
		exibirHistoriaDeVidaDoCasal(sirNeves, donaNeves);
		

		/**
		 * Quico Pai E Dona Florinda casamento, filhos (Quico Pai e M�e da
		 * Chiquinha)
		 */

		Pessoa donaFlorinda = criarMulher("Dona Florinda", 32,80,1.6);

		quicoPai.casar(donaFlorinda);
		
		registrarCasamento(quicoPai, donaFlorinda);

		Pessoa quico = criarHomem("Quico", 12);	

		Pessoa kika = criarMulher("Kika", 10,50,1.55);

		List<Pessoa> filhosQuicoEDonaFlorinda = new ArrayList<Pessoa>() {
			{
				add(quico);
				add(kika);
			}
		};
		
		quicoPai.terFilhos(donaFlorinda, filhosQuicoEDonaFlorinda);
		
		exibirHistoriaDeVidaDoCasal(donaFlorinda, quicoPai);
		

		/**
		 * Quico Pai E Dona Florinda divorcio
		 */

		// divorciando
		quicoPai.divorciar(donaFlorinda);
		
		exibirHistoriaDeVidaDoCasal(quicoPai, donaFlorinda);
		

		/**
		 * Dona Florinda casa com Professor Girafales
		 * 
		 */

		Pessoa professorGirafales = criarHomem("Professor Girafales", 28);
		
		donaFlorinda.casar(professorGirafales);
		
		registrarCasamento(professorGirafales, donaFlorinda);
		
		exibirHistoriaDeVidaDoCasal(professorGirafales, donaFlorinda);
		

		/**
		 * Dona Madruga e SirMadruga casamento, filho (Seu Madruga)
		 */

		Pessoa sirMadruga = criarHomem("Sir Madruga", 57);
		Pessoa donaMadruga = criarMulher("Dona Madruga", 55,110,1.7);

		sirMadruga.casar(donaMadruga);
		registrarCasamento(sirMadruga, donaMadruga);
		
		Pessoa seuMadruga = criarHomem("Seu Madruga", 38);

		List<Pessoa> filhosSirMadrugaEDonaMadruga = new ArrayList<Pessoa>() {
			{
				add(seuMadruga);
			}
		};

		sirMadruga.terFilhos(donaMadruga, filhosSirMadrugaEDonaMadruga);
		
		exibirHistoriaDeVidaDoCasal(donaMadruga, sirMadruga);
		
		/**
		 * Seu Madruga e M�e da Chiquinha casamento, filho (chiquinha)
		 */
		
		seuMadruga.casar(maeDaChiquinha);
		
		registrarCasamento(seuMadruga, maeDaChiquinha);
		
		Pessoa chiquinha = criarMulher("Chiquinha", 18,40,1.5);

		List<Pessoa> filhosSeuMadrugaEMaeDaChiquinha = new ArrayList<Pessoa>() {
			{
				add(chiquinha);
			}
		};

		maeDaChiquinha.terFilhos(seuMadruga, filhosSeuMadrugaEMaeDaChiquinha);		
		exibirHistoriaDeVidaDoCasal(seuMadruga, maeDaChiquinha);
		

		/**
		 * Seu Madruga e M�e da Chiquinha divorcio
		 */

		maeDaChiquinha.divorciar(seuMadruga);

		exibirHistoriaDeVidaDoCasal(maeDaChiquinha, seuMadruga);
		
		/**
		 * Seu Madruga e Bruxa do 71 casamento, filho chaves
		 */

		Pessoa bruxa = new Mulher(Cpf.criarCPF(), "Bruxa do 71", 71, 60, 1.6);

		bruxa.casar(seuMadruga);

		registrarCasamento(bruxa, seuMadruga);

		Pessoa chaves = criarHomem("Chaves", 11);

		List<Pessoa> filhosDoSeuMadrugaEBruxa = new ArrayList<Pessoa>() {
			{
				add(chaves);
			}
		};

		bruxa.terFilhos(seuMadruga, filhosDoSeuMadrugaEBruxa);
		
		exibirHistoriaDeVidaDoCasal(bruxa, seuMadruga);
		
		//FIM
		
		
		/**
		 * Rela��o para testar o programa;
		 */
		
		exibirParentesco(chaves, chaves);		
		exibirParentesco(donaFlorinda, chaves);
		exibirParentesco(quico, quicoPai);
		exibirParentesco(donaFlorinda, quico);
		exibirParentesco(professorGirafales, donaFlorinda);
		exibirParentesco(seuMadruga, chaves);
		exibirParentesco(seuMadruga, chiquinha);
		exibirParentesco(sirNeves, chiquinha);
		exibirParentesco(donaNeves, chiquinha);
		exibirParentesco(quicoPai, chiquinha);		
		exibirParentesco(maeDaChiquinha, quico);
		
		/**
		 * Testando outros m�todos de pessoa
		 */
		
		testaMetodosAlteracao(sirNeves);
		 
	}

	private static void exibirParentesco(Pessoa p1, Pessoa p2) {
		System.out.println("");
		System.out.println("exibirParentesco:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Exibindo o parentesco entre: " + p1.getNome() + " e " + p2.getNome());		
		
		Parentesco parentesco = p1.obterParentesco(p2);
		Parentesco parentesco2 = p2.obterParentesco(p1);
		
		if (parentesco==Parentesco.SEM_PARENTESCO && parentesco2 == Parentesco.SEM_PARENTESCO){
			System.out.println(p2.getNome() + " n�o � parente de "+ p1.getNome() + " e " + p1.getNome() + " n�o � parente de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.FILHO && parentesco2 == Parentesco.PAI){
			System.out.println(p2.getNome() + " � filho de "+ p1.getNome() + " e " + p1.getNome() + " � pai de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.PAI && parentesco2 == Parentesco.FILHO){
			System.out.println(p1.getNome() + " � filho de "+ p2.getNome() + " e " + p2.getNome() + " � pai de " + p1.getNome());
		}					
				
		if (parentesco==Parentesco.FILHO && parentesco2 == Parentesco.MAE){
			System.out.println(p2.getNome() + " � filho de "+ p1.getNome() + " e " + p1.getNome() + " � mae de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.MAE && parentesco2 == Parentesco.FILHO){
			System.out.println(p1.getNome() + " � filho de "+ p2.getNome() + " e " + p2.getNome() + " � mae de " + p1.getNome());
		}
		
		if (parentesco==Parentesco.ESPOSA && parentesco2 == Parentesco.MARIDO){
			System.out.println(p2.getNome() + " � esposa de "+ p1.getNome() + " e " + p1.getNome() + " � marido de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.MARIDO && parentesco2 == Parentesco.ESPOSA){
			System.out.println(p1.getNome() + " � esposa de "+ p2.getNome() + " e " + p2.getNome() + " � marido de " + p1.getNome());
		}
		
		if (parentesco==Parentesco.FILHA && parentesco2 == Parentesco.PAI){
			System.out.println(p2.getNome() + " � filha de "+ p1.getNome() + " e " + p1.getNome() + " � pai de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.PAI && parentesco2 == Parentesco.FILHA){
			System.out.println(p1.getNome() + " � filha de "+ p2.getNome() + " e " + p2.getNome() + " � pai de " + p1.getNome());
		}
		
		if (parentesco==Parentesco.NETA && parentesco2 == Parentesco.AV�){
			System.out.println(p2.getNome() + " � neta de "+ p1.getNome() + " e " + p1.getNome() + " � av� de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.AV� && parentesco2 == Parentesco.NETA){
			System.out.println(p1.getNome() + " � neta de "+ p2.getNome() + " e " + p2.getNome() + " � av� de " + p1.getNome());
		}
		
		if (parentesco==Parentesco.NETA && parentesco2 == Parentesco.AV�){
			System.out.println(p2.getNome() + " � neta de "+ p1.getNome() + " e " + p1.getNome() + " � av� de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.AV� && parentesco2 == Parentesco.NETA){
			System.out.println(p1.getNome() + " � neta de "+ p2.getNome() + " e " + p2.getNome() + " � av� de " + p1.getNome());
		}
		
		if (parentesco==Parentesco.SOBRINHA && parentesco2 == Parentesco.TIO){
			System.out.println(p2.getNome() + " � sobrinha de "+ p1.getNome() + " e " + p1.getNome() + " � tio de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.TIO && parentesco2 == Parentesco.SOBRINHA){
			System.out.println(p1.getNome() + " � sobrinha de "+ p2.getNome() + " e " + p2.getNome() + " � tio de " + p1.getNome());
		}
		
		if (parentesco==Parentesco.SOBRINHO && parentesco2 == Parentesco.TIA){
			System.out.println(p2.getNome() + " � sobrinho de "+ p1.getNome() + " e " + p1.getNome() + " � tia de " + p2.getNome()); 
		}
		
		if (parentesco==Parentesco.TIA && parentesco2 == Parentesco.SOBRINHO){
			System.out.println(p1.getNome() + " � sobrinho de "+ p2.getNome() + " e " + p2.getNome() + " � tia de " + p1.getNome());
		}
		
		if (parentesco==Parentesco.MESMA_PESSOA && parentesco2 == Parentesco.MESMA_PESSOA){
			System.out.println(p1.getNome() + " � a mesma pessoa que "+ p2.getNome() + " e " + p2.getNome() + " � a mesma pessoa que " + p1.getNome());
		}
		
		
		System.out.println("exibirParentesco:: End");
	}

	/**
	 * M�todo que cria uma hist�ria de vida do casal
	 * @param homem
	 * @param mulher
	 */
	private static void exibirHistoriaDeVidaDoCasal(Pessoa homem, Pessoa mulher) {
		
		System.out.println("");
		System.out.println("exibirHistoriaDeVidaDoCasal:: Inicio");
		System.out.println("###################**###########################################################");		
		System.out.println("Hist�ria de vida de: "+ homem.getNome() + " e " + mulher.getNome());		
		
		exibirEstadoCivil(homem);
		exibirEstadoCivil(mulher);
		
		exibirHistoricoDeCasamento(homem);
		exibirHistoricoDeCasamento(mulher);
		
		exibirHistoricoDeDivorcios(homem);
		exibirHistoricoDeDivorcios(mulher);

		exibirFilhos(homem);
		exibirFilhos(mulher);
		
		System.out.println("exibirHistoriaDeVidaDoCasal:: End");
		
	}

	private static void exibirEstadoCivil(Pessoa pessoa) {
		System.out.println("");
		System.out.println("exibirEstadoCivil:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Verificando o estado civil de, " + pessoa.getNome());
		System.out.println("O estado civil �, " + pessoa.obterEstadoCivil());
		System.out.println("exibirEstadoCivil:: End");
	}

	private static Pessoa criarMulher(String nome, int idade,double peso, double altura ) {
		return new Mulher(Cpf.criarCPF(), nome, idade, peso, altura);
	}

	private static Pessoa criarHomem(String nome, int idade) {
		return new Homem(Cpf.criarCPF(), nome, idade);
	}

	private static void registrarCasamento(Pessoa homem, Pessoa mulher) {

		System.out.println("");
		System.out.println("registrarCasamento:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Registrando o casamento entre: " + homem.getNome() + " e " + mulher.getNome());

		System.out.println("O Conjuge de " + homem.getNome() + " � " + homem.getConjuge().getNome() + " com cpf:"
				+ mulher.getCpf());

		System.out.println("O Conjuge de " + mulher.getNome() + " � " + mulher.getConjuge().getNome() + " com cpf:"
				+ homem.getCpf());

		System.out.println("###################**###########################################################");
		System.out.println("registrarCasamento:: End");

	}

	private static void exibirHistoricoDeCasamento(Pessoa pessoa) {

		System.out.println("");
		System.out.println("exibirHistoricoDeCasamento:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Exibindo as pessoas com quem eu, " + pessoa.getNome() + " casei: ");

		List<Pessoa> pessoasComQuemCasei = pessoa.obterHistoricoDeCasamento();

		for (Pessoa p : pessoasComQuemCasei) {
			System.out.println("cpf= " + p.getCpf() + " , " + "nome=" + p.getNome());
		}

		System.out.println("###################**###########################################################");
		System.out.println("exibirHistoricoDeCasamento:: End");
	}

	private static void exibirHistoricoDeDivorcios(Pessoa pessoa) {

		System.out.println("");
		System.out.println("exibirHistoricoDeDivorcios:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Exibindo as pessoas com quem eu, " + pessoa.getNome() + " divorciei: ");

		for (Pessoa p : pessoa.getExConjuges()) {
			System.out.println("cpf= " + p.getCpf() + " , " + "nome=" + p.getNome());
		}

		System.out.println("###################**###########################################################");
		System.out.println("exibirHistoricoDeDivorcios:: End");
	}

	private static void exibirFilhos(Pessoa pessoa) {

		System.out.println("");
		System.out.println("exibirFilhos:: Inicio");
		System.out.println("###################**###########################################################");

		if (pessoa.getFilhos().size() < 1) {
			System.out.println(pessoa.getNome() + " n�o tem filhos");
		} else {

			System.out.println("Exibindo os filhos de, " + pessoa.getNome());

			for (Pessoa p : pessoa.getFilhos()) {
				System.out.println("Pessoa [cpf=" + p.getCpf() + ", nome=" + p.getNome() + ", idade=" + p.getIdade()
						+ ", conjuge=" + p.getConjuge() + "]");
			}

		}

		System.out.println("###################**###########################################################");
		System.out.println("exibirFilhos:: End");
	}
	
	private static void testaMetodosAlteracao(Pessoa pessoa){
		
		System.out.println("");
		System.out.println("testaMetodosAlteracao:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Exibindo os dados atuais da pessoa, " + pessoa.getNome());
		
		System.out.println("**Nome** : " + pessoa.getNome());
		System.out.println("**CPF** : " + pessoa.getCpf());
		System.out.println("**Idade** : " + pessoa.getIdade());
				
		if (pessoa instanceof Homem){
			
			((Homem) pessoa).setTimeDeFutebolDoCoracao("Bota-Fogo");
			
			System.out.println("**Time Atual** : "+((Homem) pessoa).getTimeDeFutebolDoCoracao());
			
			System.out.println("Exibindo os dados alterados da pessoa, " + pessoa.getNome());								

			// alterando os dados			
			((Homem) pessoa).setTimeDeFutebolDoCoracao("Time alterado para : " + "Flamengo");

			// exibindo dados alterandos
			System.out.println(((Homem) pessoa).getTimeDeFutebolDoCoracao());
 						
		}else{
				((Mulher) pessoa).setTimeDeBasquete("Cuba");
				
				System.out.println("**Time Atual** : "+((Mulher) pessoa).getTimeDeBasquete());
				
				System.out.println("Exibindo os dados alterados da pessoa, " + pessoa.getNome());

				// alterando os dados			
				((Mulher) pessoa).setTimeDeBasquete("Time alterado para : " + "Brasil");

				// exibindo dados alterandos
				System.out.println(((Mulher) pessoa).getTimeDeBasquete());
		}
		
		// alterando os dados
		pessoa.alterarNome("Novo nome da Pessoa, " + pessoa.getNome());
		pessoa.alterarCpf("12345678975");
		pessoa.alterarIdade(19);		

		// exibindo dados alterandos
		System.out.println("**Nome** : " + pessoa.getNome());
		System.out.println("**CPF** : " + pessoa.getCpf());
		System.out.println("**Idade** : " + pessoa.getIdade());
		
		pessoa.fazerAniverssario();
		System.out.println("**MAIS UM ANO DE VIDA**" + pessoa.getIdade());			
		
		System.out.println("###################**###########################################################");
		System.out.println("testaMetodosAlteracao:: End");
	}
	
	

}
