
package br.com.puc.llp.prjArvoreGenealogica;
import java.util.ArrayList;
import java.util.List;

import br.com.puc.llp.dominio.ClassificaIMC;
import br.com.puc.llp.dominio.Cpf;
import br.com.puc.llp.dominio.Homem;
import br.com.puc.llp.dominio.Mulher;
import br.com.puc.llp.dominio.Parentesco;
import br.com.puc.llp.dominio.Pessoa;

public class Arvore3 {

	public static void main(String[] args) {

		//*****
		//		Montando a estrutura da Arvore com as pessoas.
		//*****
		/**
		 * DonaNeves e SirNeves sem pais, casamento, filhos (Quico Pai e M�e da
		 * Chiquinha)
		 */

		Pessoa sirNeves = new Homem(Cpf.criarCPF(), "Sir Neves", 75);

		Pessoa donaNeves = new Mulher(Cpf.criarCPF(), "Dona Neves", 19, 75, 1.72);

		// casar
		sirNeves.casar(donaNeves);

		// criando um filho
		Pessoa quicoPai = criarHomem("Quico Pai", 40);

		// criando uma filha
		Pessoa maeDaChiquinha = criarMulher("M�e da Chiquinha", 35, 70, 1.62);

		// adicionado os filhos em uma lista de filhos

		List<Pessoa> filhosDonaNevesESirNeves = new ArrayList<Pessoa>() {
			{
				add(quicoPai);
				add(maeDaChiquinha);
			}
		};

		// procriando
		sirNeves.terFilhos(donaNeves, filhosDonaNevesESirNeves);

		/**
		 * Quico Pai E Dona Florinda casamento, filhos (Quico Pai e M�e da
		 * Chiquinha)
		 */

		Pessoa donaFlorinda = criarMulher("Dona Florinda", 32, 80, 1.6);

		quicoPai.casar(donaFlorinda);

		Pessoa quico = criarHomem("Quico", 12);

		Pessoa kika = criarMulher("Kika", 10, 50, 1.55);
		List<Pessoa> filhosQuicoEDonaFlorinda = new ArrayList<Pessoa>() {
			{
				add(quico);
				add(kika);
			}
		};

		quicoPai.terFilhos(donaFlorinda, filhosQuicoEDonaFlorinda);

		/**
		 * Quico Pai E Dona Florinda divorcio
		 */

		// divorciando
		quicoPai.divorciar(donaFlorinda);

		/**
		 * Dona Florinda casa com Professor Girafales
		 * 
		 */

		Pessoa professorGirafales = criarHomem("Professor Girafales", 28);

		donaFlorinda.casar(professorGirafales);

		/**
		 * Dona Madruga e SirMadruga casamento, filho (Seu Madruga)
		 */

		Pessoa sirMadruga = criarHomem("Sir Madruga", 57);
		Pessoa donaMadruga = criarMulher("Dona Madruga", 55, 110, 1.7);

		sirMadruga.casar(donaMadruga);

		Pessoa seuMadruga = criarHomem("Seu Madruga", 38);

		List<Pessoa> filhosSirMadrugaEDonaMadruga = new ArrayList<Pessoa>() {
			{
				add(seuMadruga);
			}
		};

		sirMadruga.terFilhos(donaMadruga, filhosSirMadrugaEDonaMadruga);

		/**
		 * Seu Madruga e M�e da Chiquinha casamento, filho (chiquinha)
		 */

		seuMadruga.casar(maeDaChiquinha);

		Pessoa chiquinha = criarMulher("Chiquinha", 18, 40, 1.5);

		List<Pessoa> filhosSeuMadrugaEMaeDaChiquinha = new ArrayList<Pessoa>() {
			{
				add(chiquinha);
			}
		};

		maeDaChiquinha.terFilhos(seuMadruga, filhosSeuMadrugaEMaeDaChiquinha);

		/**
		 * Seu Madruga e M�e da Chiquinha divorcio
		 */

		maeDaChiquinha.divorciar(seuMadruga);

		/**
		 * Seu Madruga e Bruxa do 71 casamento, filho chaves
		 */

		Pessoa bruxa = new Mulher(Cpf.criarCPF(), "Bruxa do 71", 71, 60, 1.6);

		bruxa.casar(seuMadruga);

		Pessoa chaves = criarHomem("Chaves", 11);

		List<Pessoa> filhosDoSeuMadrugaEBruxa = new ArrayList<Pessoa>() {
			{
				add(chaves);
			}
		};

		bruxa.terFilhos(seuMadruga, filhosDoSeuMadrugaEBruxa);

		//*****
		// 		Inserindo novos nomes na estrutura da Arvore
		//*****
		//*****
		//		Dona Neves \
		// 					SirNevasca
		// 		Sir Neves /
		//
		//	 	Dona Madruga \
		// 						Dona Noite
		// 		Sir Madruga /
		//
		// 		Casar Sir Nevasca e Dona Noite
		//
		// 		Sir Nevasca e Dona Noite terem filhos - Nevasquinha(M) e The Noite(H)
		//
		// 		Divorciar Sir Nevasca e Dona Noite
		//
		//*****

		//*****
		//		Criando sirNevasca e donaNNoite
		//*****
		Pessoa sirNevasca = new Homem(Cpf.criarCPF(), "Sir Nevasca", 45);
		
		Pessoa donaNoite = new Mulher(Cpf.criarCPF(), "Dona Noite", 41, 62, 1.62);
		
		//*****		
		// 		Associar Sir Nevasca e Dona Noite aos pais
		//*****		
		List<Pessoa> filhosDoXeY = new ArrayList<Pessoa>() {
			{
				add(sirNevasca);
			}
		};
		donaNeves.terFilhos(sirNeves, filhosDoXeY);

		filhosDoXeY.clear();
		filhosDoXeY.add(donaNoite);
		donaMadruga.terFilhos(sirMadruga, filhosDoXeY);

		//*****		
		// 		Casando sirNevasca e donaNoite
		//*****	
		try {
			System.out.println("Tentando casar");
			sirNevasca.casar(donaNoite);
		} catch (Exception e) {
			System.out.println("Pegou uma exception aqui..");
			System.out.println(e.getMessage());
		}
		registrarCasamento(sirNevasca, donaNoite);

		//*****		
		// 		Filhos de sirNevasca e donaNoite
		//*****	
		Pessoa nevasquinha = new Mulher(Cpf.criarCPF(), "Nevasquinha", 10, 50, 1.5);
		Pessoa theNoite = new Homem(Cpf.criarCPF(), "The Noite", 12);

		filhosDoXeY.clear();
		filhosDoXeY.add(nevasquinha);
		filhosDoXeY.add(theNoite);

		donaNoite.terFilhos(sirNevasca, filhosDoXeY);

		exibirFilhos(donaNoite);
		exibirFilhos(sirNevasca);
		
		//*****		
		// 		Div�rcio de sirNevasca e donaNoite
		//*****
		sirNevasca.divorciar(donaNoite);

		//***** 
		//		Filhos para Dona Florinda e Professor Girafales
		//*****
		Pessoa florzinha = new Mulher(Cpf.criarCPF(), "Florzinha", 12, 55, 1.4);
		Pessoa nika = new Mulher(Cpf.criarCPF(), "Nika", 8, 40, 1.35);

		filhosDoXeY.clear();
		filhosDoXeY.add(florzinha);
		filhosDoXeY.add(nika);

		donaFlorinda.terFilhos(professorGirafales, filhosDoXeY);

		exibirFilhos(donaFlorinda);
		exibirFilhos(professorGirafales);

		//***** 
		//		Rela��es de parentesco entre duas pessoas
		//*****
		
		exibirParentesco(sirNevasca, quicoPai);			// irm�os
		exibirParentesco(sirNevasca, seuMadruga);		// n�o s�o parentes
		exibirParentesco(sirNevasca, nevasquinha);		// pai/filha
		exibirParentesco(sirNevasca, theNoite);			// pai/filho
		exibirParentesco(donaNoite, theNoite);			// m�e/filho
		exibirParentesco(sirNevasca, donaNoite);		// n�o s�o parentes
		exibirParentesco(donaNoite, sirNevasca);		// n�o s�o parentes
		exibirParentesco(nika, sirNevasca);       		//-->> ok sirNevasca n�o � parente de donaFlorinda ou de professorGirafales
		exibirParentesco(florzinha, sirNevasca);  		//-->> ok sirNevasca n�o � parente de donaFlorinda ou de professorGirafales
		exibirParentesco(nika, donaNoite);        		//-->> ok sirNevasca n�o � parente de donaFlorinda ou de professorGirafales
		exibirParentesco(florzinha, donaNoite);   		//-->> ok sirNevasca n�o � parente de donaFlorinda ou de professorGirafales
		exibirParentesco(sirNeves, nevasquinha);		// av�/neta
		exibirParentesco(quicoPai, nevasquinha);		// tia/sobrinha
		exibirParentesco(maeDaChiquinha, nika);			//-->> ok maeDaCiquinha n�o � parente de donaFlorinda ou de professorGirafales
		exibirParentesco(nika, quicoPai);				//-->> ok  quicoPai n�o � parente de donaFlorinda ou de professorGirafales
		exibirParentesco(sirNeves, nika);				// ok sirNeves n�o � parente de donaFlorinda ou de professorGirafales
		exibirParentesco(kika, nika);					// ok irm�s por parte de m�e
		exibirParentesco(kika, florzinha);				// ok irm�s por parte de m�e
		exibirParentesco(seuMadruga, donaNoite);		// ok s�o irm�os
		exibirParentesco(chaves, chaves);				// mesma pessoa
		exibirParentesco(sirNevasca, quicoPai);			// irm�os
		exibirParentesco(nevasquinha, chaves);			// primo/prima
		exibirParentesco(theNoite, chaves);				// primo/primo		
		exibirParentesco(nevasquinha, donaNoite);		// m�e/filha
		exibirParentesco(donaNoite, nevasquinha);   	// m�e/filha
		exibirParentesco(quicoPai, theNoite);		 	// tio/sobrinho
		exibirParentesco(nevasquinha, maeDaChiquinha);  // tia/sobrinha
		exibirParentesco(sirNeves, theNoite);			// av�/neto		

		// *****
		// 		Calculando IMC das Mulheres
		// *****

		System.out.println("");
		System.out.println("Verificando o IMC das Mulheres");
		System.out.println("###################**###########################################################");

		if (donaNeves instanceof Mulher) {
			System.out.println(">>>>> IMC de Dona Neves....: " + ((Mulher) donaNeves).calcularIMC());
		}
		if (donaMadruga instanceof Mulher) {
			System.out.println(">>>>> IMC de donaMadruga...: " + ((Mulher) donaMadruga).calcularIMC());
		}
		if (donaFlorinda instanceof Mulher) {
			System.out.println(">>>>> IMC de donaFlorinda..: " + ((Mulher) donaFlorinda).calcularIMC());
		}
		if (maeDaChiquinha instanceof Mulher) {
			System.out.println(">>>>> IMC de maeDaChiquinha: " + ((Mulher) maeDaChiquinha).calcularIMC());
		}
		if (bruxa instanceof Mulher) {
			System.out.println(">>>>> IMC de bruxa.........: " + ((Mulher) bruxa).calcularIMC());
		}
		if (kika instanceof Mulher) {
			System.out.println(">>>>> IMC de kika..........: " + ((Mulher) kika).calcularIMC());
		}
		if (chiquinha instanceof Mulher) {
			System.out.println(">>>>> IMC de chiquinha.....: " + ((Mulher) chiquinha).calcularIMC());
		}

		// *****
		// 		Outra forma de Verificar o IMC
		// *****

		Mulher m = (Mulher) donaNeves;
		double imc = m.calcularIMC();
		ClassificaIMC classificaIMC = m.classificaIMC(imc);
		System.out.println(" ");
		System.out.println(">>>> IMC de " + m.getNome() + " � igual a " + m.calcularIMC() + " - Classifica��o: "
				+ classificaIMC + ".");

		// *****
		// 		Analisando o IMC das Mulheres (N�o � poss�vel analisar para os homens)
		// *****
		exibirAnaliseIMC(sirNeves);
		exibirAnaliseIMC(donaNeves);
		exibirAnaliseIMC(sirMadruga);
		exibirAnaliseIMC(donaMadruga);
		exibirAnaliseIMC(quicoPai);
		exibirAnaliseIMC(donaFlorinda);
		exibirAnaliseIMC(professorGirafales);
		exibirAnaliseIMC(maeDaChiquinha);
		exibirAnaliseIMC(seuMadruga);
		exibirAnaliseIMC(bruxa);
		exibirAnaliseIMC(quico);
		exibirAnaliseIMC(kika);
		exibirAnaliseIMC(chiquinha);
		exibirAnaliseIMC(chaves);
		
		//*****
		// 		FIM DOS TESTES!
		//*****
		//*****

	}
	
	private static void exibirParentesco(Pessoa p1, Pessoa p2) {
		System.out.println("");
		System.out.println("exibirParentesco:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Exibindo o parentesco entre: " + p1.getNome() + " e " + p2.getNome());

		Parentesco parentesco = p1.obterParentesco(p2);
		Parentesco parentesco2 = p2.obterParentesco(p1);

		if (parentesco == Parentesco.SEM_PARENTESCO && parentesco2 == Parentesco.SEM_PARENTESCO) {
			System.out.println(p2.getNome() + " n�o � parente de " + p1.getNome() + " e " + p1.getNome()
					+ " n�o � parente de " + p2.getNome());
		}

		if (parentesco == Parentesco.FILHO && parentesco2 == Parentesco.PAI) {
			System.out.println(
					p2.getNome() + " � filho de " + p1.getNome() + " e " + p1.getNome() + " � pai de " + p2.getNome());
		}

		if (parentesco == Parentesco.PAI && parentesco2 == Parentesco.FILHO) {
			System.out.println(
					p1.getNome() + " � filho de " + p2.getNome() + " e " + p2.getNome() + " � pai de " + p1.getNome());
		}

		if (parentesco == Parentesco.FILHO && parentesco2 == Parentesco.MAE) {
			System.out.println(
					p2.getNome() + " � filho de " + p1.getNome() + " e " + p1.getNome() + " � mae de " + p2.getNome());
		}

		if (parentesco == Parentesco.MAE && parentesco2 == Parentesco.FILHO) {
			System.out.println(
					p1.getNome() + " � filho de " + p2.getNome() + " e " + p2.getNome() + " � mae de " + p1.getNome());
		}

		if (parentesco == Parentesco.ESPOSA && parentesco2 == Parentesco.MARIDO) {
			System.out.println(p2.getNome() + " � esposa de " + p1.getNome() + " e " + p1.getNome() + " � marido de "
					+ p2.getNome());
		}

		if (parentesco == Parentesco.MARIDO && parentesco2 == Parentesco.ESPOSA) {
			System.out.println(p1.getNome() + " � esposa de " + p2.getNome() + " e " + p2.getNome() + " � marido de "
					+ p1.getNome());
		}

		if (parentesco == Parentesco.FILHA && parentesco2 == Parentesco.PAI) {
			System.out.println(
					p2.getNome() + " � filha de " + p1.getNome() + " e " + p1.getNome() + " � pai de " + p2.getNome());
		}

		if (parentesco == Parentesco.PAI && parentesco2 == Parentesco.FILHA) {
			System.out.println(
					p1.getNome() + " � filha de " + p2.getNome() + " e " + p2.getNome() + " � pai de " + p1.getNome());
		}
		
		if (parentesco == Parentesco.FILHA && parentesco2 == Parentesco.MAE) {
			System.out.println(
					p2.getNome() + " � filha de " + p1.getNome() + " e " + p1.getNome() + " � mae de " + p2.getNome());
		}

		if (parentesco == Parentesco.MAE && parentesco2 == Parentesco.FILHA) {
			System.out.println(
					p1.getNome() + " � filha de " + p2.getNome() + " e " + p2.getNome() + " � mae de " + p1.getNome());
		}

		if (parentesco == Parentesco.NETA && parentesco2 == Parentesco.AV�) {
			System.out.println(
					p2.getNome() + " � neta de " + p1.getNome() + " e " + p1.getNome() + " � av� de " + p2.getNome());
		}

		if (parentesco == Parentesco.AV� && parentesco2 == Parentesco.NETA) {
			System.out.println(
					p1.getNome() + " � neta de " + p2.getNome() + " e " + p2.getNome() + " � av� de " + p1.getNome());
		}
		
		if (parentesco == Parentesco.AV� && parentesco2 == Parentesco.NETO) {
			System.out.println(
					p1.getNome() + " � neto de " + p2.getNome() + " e " + p2.getNome() + " � av� de " + p1.getNome());
		}
		
		if (parentesco == Parentesco.NETO && parentesco2 == Parentesco.AV�) {
			System.out.println(
					p1.getNome() + " � av� de " + p2.getNome() + " e " + p2.getNome() + " � neto de " + p1.getNome());
		}
		
		if (parentesco == Parentesco.NETA && parentesco2 == Parentesco.AV�) {
			System.out.println(
					p2.getNome() + " � neta de " + p1.getNome() + " e " + p1.getNome() + " � av� de " + p2.getNome());
		}

		if (parentesco == Parentesco.AV� && parentesco2 == Parentesco.NETA) {
			System.out.println(
					p1.getNome() + " � neta de " + p2.getNome() + " e " + p2.getNome() + " � av� de " + p1.getNome());
		}

		if (parentesco == Parentesco.SOBRINHA && parentesco2 == Parentesco.TIO) {
			System.out.println(p2.getNome() + " � sobrinha de " + p1.getNome() + " e " + p1.getNome() + " � tio de "
					+ p2.getNome());
		}

		if (parentesco == Parentesco.TIO && parentesco2 == Parentesco.SOBRINHA) {
			System.out.println(p1.getNome() + " � sobrinha de " + p2.getNome() + " e " + p2.getNome() + " � tio de "
					+ p1.getNome());
		}
		
		if (parentesco == Parentesco.SOBRINHO && parentesco2 == Parentesco.TIO) {
			System.out.println(p2.getNome() + " � sobrinho de " + p1.getNome() + " e " + p1.getNome() + " � tio de "
					+ p2.getNome());
		}

		if (parentesco == Parentesco.TIO && parentesco2 == Parentesco.SOBRINHO) {
			System.out.println(p1.getNome() + " � sobrinho de " + p2.getNome() + " e " + p2.getNome() + " � tio de "
					+ p1.getNome());
		}

		if (parentesco == Parentesco.SOBRINHO && parentesco2 == Parentesco.TIA) {
			System.out.println(p2.getNome() + " � sobrinho de " + p1.getNome() + " e " + p1.getNome() + " � tia de "
					+ p2.getNome());
		}

		if (parentesco == Parentesco.TIA && parentesco2 == Parentesco.SOBRINHO) {
			System.out.println(p1.getNome() + " � sobrinho de " + p2.getNome() + " e " + p2.getNome() + " � tia de "
					+ p1.getNome());
		}
		

		if (parentesco == Parentesco.TIA && parentesco2 == Parentesco.SOBRINHA) {
			System.out.println(p1.getNome() + " � sobrinha de " + p2.getNome() + " e " + p2.getNome() + " � tia de "
					+ p1.getNome());
		}
		
		if (parentesco == Parentesco.SOBRINHA && parentesco2 == Parentesco.TIA) {
			System.out.println(p1.getNome() + " � sobrinha de " + p2.getNome() + " e " + p2.getNome() + " � tia de "
					+ p1.getNome());
		}
		
		
		if (parentesco == Parentesco.IRM�O && parentesco2 == Parentesco.IRM�O) {
			System.out.println(p1.getNome() + " � irm�o de " + p2.getNome() + " e " + p2.getNome() + " � irm�o de "
					+ p1.getNome());
		}
					  		
		if (parentesco == Parentesco.IRM� && parentesco2 == Parentesco.IRM�O) {
			System.out.println(p1.getNome() + " � irm�o de " + p2.getNome() + " e " + p2.getNome() + " � irm� de "
					+ p1.getNome());
		}		

		if (parentesco == Parentesco.IRM�O && parentesco2 == Parentesco.IRM�) {
			System.out.println(p1.getNome() + " � irm�o de " + p2.getNome() + " e " + p2.getNome() + " � irm� de "
					+ p1.getNome());
		}
		
		if (parentesco == Parentesco.IRM� && parentesco2 == Parentesco.IRM�) {
			System.out.println(p1.getNome() + " � irm� de " + p2.getNome() + " e " + p2.getNome() + " � irm� de "
					+ p1.getNome());
		}
		
		if (parentesco == Parentesco.PRIMO && parentesco2 == Parentesco.PRIMO) {
			System.out.println(p1.getNome() + " � primo de " + p2.getNome() + " e " + p2.getNome() + " � primo de "
					+ p1.getNome());
		}
					  		
		if (parentesco == Parentesco.PRIMA && parentesco2 == Parentesco.PRIMO) {
			System.out.println(p1.getNome() + " � prima de " + p2.getNome() + " e " + p2.getNome() + " � primo de "
					+ p1.getNome());
		}		

		if (parentesco == Parentesco.PRIMO && parentesco2 == Parentesco.PRIMA) {
			System.out.println(p1.getNome() + " � primo de " + p2.getNome() + " e " + p2.getNome() + " � prima de "
					+ p1.getNome());
		}
		
		if (parentesco == Parentesco.PRIMA && parentesco2 == Parentesco.PRIMA) {
			System.out.println(p1.getNome() + " � prima de " + p2.getNome() + " e " + p2.getNome() + " � prima de "
					+ p1.getNome());
		}
		
		System.out.println("exibirParentesco:: End");
	}	
	

	/**
	 * M�todo que cria uma hist�ria de vida do casal
	 * 
	 * @param homem
	 * @param mulher
	 */
	private static void exibirHistoriaDeVidaDoCasal(Pessoa homem, Pessoa mulher) {

		System.out.println("");
		System.out.println("exibirHistoriaDeVidaDoCasal:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Hist�ria de vida de: " + homem.getNome() + " e " + mulher.getNome());

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

	private static Pessoa criarMulher(String nome, int idade, double peso, double altura) {
		return new Mulher(Cpf.criarCPF(), nome, idade, peso, altura);
	}

	private static Pessoa criarHomem(String nome, int idade) {
		return new Homem(Cpf.criarCPF(), nome, idade);
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

	private static void testaMetodosAlteracao(Pessoa pessoa) {

		System.out.println("");
		System.out.println("testaMetodosAlteracao:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Exibindo os dados atuais da pessoa, " + pessoa.getNome());

		System.out.println("**Nome** : " + pessoa.getNome());
		System.out.println("**CPF** : " + pessoa.getCpf());
		System.out.println("**Idade** : " + pessoa.getIdade());

		if (pessoa instanceof Homem) {

			((Homem) pessoa).setTimeDeFutebolDoCoracao("Bota-Fogo");

			System.out.println("**Time Atual** : " + ((Homem) pessoa).getTimeDeFutebolDoCoracao());

			System.out.println("Exibindo os dados alterados da pessoa, " + pessoa.getNome());

			// alterando os dados
			((Homem) pessoa).setTimeDeFutebolDoCoracao("Time alterado para : " + "Flamengo");

			// exibindo dados alterandos
			System.out.println(((Homem) pessoa).getTimeDeFutebolDoCoracao());

		} else {
			((Mulher) pessoa).setTimeDeBasquete("Cuba");

			System.out.println("**Time Atual** : " + ((Mulher) pessoa).getTimeDeBasquete());

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

	private static void exibirAnaliseIMC(Pessoa p1) {

		double imc = 0;
		System.out.println("");
		System.out.println("exibirAnaliseIMC:: Inicio");
		System.out.println("###################**###########################################################");
		System.out.println("Exibindo an�lise de IMC de " + p1.getNome());

		if (p1 instanceof Mulher) {
			if ((((Mulher) p1).getAltura()) > 0 && (((Mulher) p1).getPeso() > 0)) {
				imc = ((Mulher) p1).calcularIMC();
				ClassificaIMC classificaIMC = ((Mulher) p1).classificaIMC(imc);
				switch (classificaIMC) {
				case ABAIXO_DO_PESO:
					System.out.println(p1.getNome() + " est� com IMC igual a " + imc + " estando " + "ABAIXO DO PESO");
					break;
				case PESO_NORMAL:
					System.out.println(p1.getNome() + " est� com IMC igual a " + imc + " estando " + "COM PESO NORMAL");
					;
					break;
				case SOBREPESO:
					System.out.println(p1.getNome() + " est� com IMC igual a " + imc + " estando "
							+ "COM EXCESSO DE PESO (SOBREPESO)");
					break;
				case OBESIDADE_GRAU_I:
					System.out.println(
							p1.getNome() + " est� com IMC igual a " + imc + " estando " + "COM OBESIDADE CLASSE I");
					break;
				case OBESIDADE_GRAU_II:
					System.out.println(
							p1.getNome() + " est� com IMC igual a " + imc + " estando " + "COM OBESIDADE CLASSE II");
					break;
				case OBESIDADE_GRAU_III:
					System.out.println(
							p1.getNome() + " est� com IMC igual a " + imc + " estando " + "COM OBESIDADE CLASSE III");
					break;
				}
			}
		} else {
			System.out.println(
					p1.getNome() + " � homem - n�o tem peso e altura e, portando, n�o � poss�vel analisar o IMC.");
		}
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

}
