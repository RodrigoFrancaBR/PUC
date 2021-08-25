package br.com.puc.llp.prjArvoreGenealogica;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.puc.llp.dominio.Cpf;
import br.com.puc.llp.dominio.Homem;
import br.com.puc.llp.dominio.Mulher;
import br.com.puc.llp.dominio.Parentesco;
import br.com.puc.llp.dominio.Pessoa;
import br.com.puc.llp.dominio.ClassificaIMC;

public class Arvore2 {

	public static void main(String[] args) {

		System.out.println();
		System.out.println("==================== CRIANDO A ÁRVORE GENEÁLÓGICA ====================");

		// CRIAÇÃO DAS PESSOAS
		
		Pessoa sirMadruga = new Homem (Cpf.criarCPF(), "Sir Madruga", 71);
		Pessoa donaMadruga = new Mulher (Cpf.criarCPF(), "Dona Madruga", 70, 100, 1.8);
		Pessoa sirNeves = new Homem (Cpf.criarCPF(), "Sir Neves", 61);
		Pessoa donaNeves = new Mulher (Cpf.criarCPF(), "Dona Neves", 60, 100, 1.6);
		Pessoa bruxaDo71 = new Mulher (Cpf.criarCPF(), "Bruxa do 71", 55, 108, 1.6);
		Pessoa seuMadruga = new Homem (Cpf.criarCPF(), "Seu Madruga", 50);
		Pessoa professorGirafales = new Homem (Cpf.criarCPF(), "Professor Girafales", 44);
		Pessoa donaFlorinda = new Mulher (Cpf.criarCPF(), "Dona Florinda", 43, 65, 1.65);
		Pessoa maeDaChiquinha = new Mulher (Cpf.criarCPF(), "Mãe da Chiquinha", 40, 60, 1.68);
		Pessoa quicoPai = new Homem (Cpf.criarCPF(), "Quico Pai", 50);
		Pessoa chiquinha = new Mulher (Cpf.criarCPF(), "Chiquinha", 12, 60, 1.5);
		Pessoa chaves = new Homem (Cpf.criarCPF(), "Chaves", 10);
		Pessoa kika = new Mulher (Cpf.criarCPF(), "Kika", 9, 60, 1.4);
		Pessoa quico = new Homem (Cpf.criarCPF(), "Quico", 11);
		Pessoa eduardo = new Homem (Cpf.criarCPF(), "Eduardo", 19);
		Pessoa monica = new Mulher (Cpf.criarCPF(), "Mônica", 24, 60, 1.5);

		// CRIAÇÃO DOS CASAMENTOS E RELACIONAMENTOS FILIAIS
		
		sirMadruga.casar(donaMadruga);
		sirNeves.casar(donaNeves);
		ArrayList<Pessoa> filhosAuxiliar = new ArrayList();		
		filhosAuxiliar.add(seuMadruga);
		sirMadruga.terFilhos(donaMadruga, filhosAuxiliar);

		filhosAuxiliar.clear();
		filhosAuxiliar.add(quicoPai);
		filhosAuxiliar.add(maeDaChiquinha);
		sirNeves.terFilhos(donaNeves, filhosAuxiliar);

		seuMadruga.casar(maeDaChiquinha);
		filhosAuxiliar.clear();
		filhosAuxiliar.add(chiquinha);
		seuMadruga.terFilhos(maeDaChiquinha, filhosAuxiliar);
		
		seuMadruga.divorciar(maeDaChiquinha);
		seuMadruga.casar(bruxaDo71);

		filhosAuxiliar.clear();
		filhosAuxiliar.add(chaves);
		seuMadruga.terFilhos(bruxaDo71, filhosAuxiliar);	
		
		quicoPai.casar(donaFlorinda);
		filhosAuxiliar.clear();
		filhosAuxiliar.add(quico);
		filhosAuxiliar.add(kika);
		quicoPai.terFilhos(donaFlorinda, filhosAuxiliar);
		
		quicoPai.divorciar(donaFlorinda);
		donaFlorinda.casar(professorGirafales);


		System.out.println();
		System.out.println();
		System.out.println("==================== LISTANDO RESULTADOS DE CASAR E DIVORCIAR ====================");
				
		exibirHistoricoDeCasamentos(sirMadruga);
		exibirHistoricoDeCasamentos(donaMadruga);
		exibirHistoricoDeCasamentos(sirNeves);
		exibirHistoricoDeCasamentos(donaNeves);
		exibirHistoricoDeCasamentos(bruxaDo71);
		exibirHistoricoDeCasamentos(seuMadruga);
		exibirHistoricoDeCasamentos(maeDaChiquinha);
		exibirHistoricoDeCasamentos(professorGirafales);
		exibirHistoricoDeCasamentos(donaFlorinda);
		exibirHistoricoDeCasamentos(quicoPai);		
		
		System.out.println();
		System.out.println();
		System.out.println("==================== TESTANDO PARENTESCO ====================");
		
		// Testando pessoa sem parentesco - OK, 30.05
		System.out.println( sirMadruga.obterParentesco(sirNeves) );
		
		// Testando pai - OK, 30.05
		System.out.println( chaves.obterParentesco(seuMadruga) );
		
		// Testando mãe - OK, 30.05
		System.out.println( kika.obterParentesco(donaFlorinda) );
		
		// Testando marido - OK, 30.05
		System.out.println( donaFlorinda.obterParentesco(professorGirafales));
		
		// Testando esposa - OK, 30.05
		System.out.println( sirNeves.obterParentesco(donaNeves));
		
		// Testando filho - OK, 30.05
		System.out.println( sirMadruga.obterParentesco(seuMadruga) );
		
		// Testando filha - OK, 30.05
		System.out.println( donaNeves.obterParentesco(maeDaChiquinha) );
		
		// Testando avô - OK, 30.05
		System.out.println( chaves.obterParentesco(sirMadruga));		
		
		// Testando avó - OK, 30.05
		System.out.println( quico.obterParentesco(donaNeves));
		
		// Testando tio - OK, 30.05
		System.out.println( chiquinha.obterParentesco(quicoPai) );
				
		// Testando tia - OK, 30.05
		System.out.println( kika.obterParentesco(maeDaChiquinha) );
		
		// Testando sobrinho - OK, 30.05
		System.out.println( maeDaChiquinha.obterParentesco(quico));
						
		// Testando sobrinha - OK, 30.05
		System.out.println( quicoPai.obterParentesco(chiquinha));
				
		// Testando neto - OK, 31.05
		System.out.println( sirMadruga.obterParentesco(chaves) );
		
		// Testando neta - OK, 31.05
		System.out.println( sirMadruga.obterParentesco(chiquinha) );

				
		System.out.println();
		System.out.println();
		System.out.println("==================== TESTANDO FILIAÇÃO ====================");
		
		System.out.println( sirMadruga.getNome() + " tem " + sirMadruga.getFilhos().size() + " filh@s");
		exibirFilhos(sirMadruga);
		
		System.out.println( donaMadruga.getNome() + " tem " + donaMadruga.getFilhos().size() + " filh@s");
		exibirFilhos(donaMadruga);
		
		System.out.println( sirNeves.getNome() + " tem " + sirNeves.getFilhos().size() + " filh@s");
		exibirFilhos(sirNeves);
		
		System.out.println( donaNeves.getNome() + " tem " + donaNeves.getFilhos().size() + " filh@s");
		exibirFilhos(donaNeves);
		
		System.out.println( bruxaDo71.getNome() + " tem " + bruxaDo71.getFilhos().size() + " filh@s");
		exibirFilhos(bruxaDo71);
		
		System.out.println( seuMadruga.getNome() + " tem " + seuMadruga.getFilhos().size() + " filh@s");
		exibirFilhos(seuMadruga);
		
		System.out.println( maeDaChiquinha.getNome() + " tem " + maeDaChiquinha.getFilhos().size() + " filh@s");
		exibirFilhos(maeDaChiquinha);
		
		System.out.println( professorGirafales.getNome() + " tem " + professorGirafales.getFilhos().size() + " filh@s");
		exibirFilhos(professorGirafales);
		
		System.out.println( donaFlorinda.getNome() + " tem " + donaFlorinda.getFilhos().size() + " filh@s");
		exibirFilhos(donaFlorinda);
		
		System.out.println( quicoPai.getNome() + " tem " + quicoPai.getFilhos().size() + " filh@s");
		exibirFilhos(quicoPai);		
		
		
		System.out.println();
		System.out.println();
		System.out.println("==================== TESTANDO CASAMENTOS ====================");
		System.out.println();
		System.out.println("========== Método pessoa.casar(pessoa) usando exceções ==========");
		System.out.println("========= funcionamento depende de apagar comentários // =========");
		
		// Testando
		/* Condições para casamento
		   . não ser a própria pessoa - OK, 30.05
		   */
//		sirNeves.casar(sirNeves);

		/* Condições para casamento
		   . não estarem casadas - OK, 30.05
		   */
//		seuMadruga.casar(donaFlorinda);
		
		/* Condições para casamento
		   . não ser ninguém - OK, 31.05
		   */
		
//		eduardo.casar(null);
		
		/* Condições para casamento
		   . não podem ser parentes diretos - OK, 30.05
		   */
		
//		maeDaChiquinha.casar(quicoPai);
		
		/* Condições para casamento
		   . idade ser >= 18 - OK, 30.05
		   */
		
//		quicoPai.casar(chiquinha);
		
		/* Condições para casamento
		   . passando em todas as condições, pode casar!
		 */

		
		System.out.println();
		System.out.println();
		System.out.println("==================== TESTANDO ESTADO CIVIL ====================");
		
		// Testando solteiro - OK, 30.05
		exibirEstadoCivil(chaves);
		
		// Testando solteira - OK, 30.05
		exibirEstadoCivil(chiquinha);
		
		// Testando casado - OK, 30.05
		exibirEstadoCivil(sirMadruga);
		
		// Testando casada - OK, 30.05
		exibirEstadoCivil(donaMadruga);
		
		// Testando divorciado - OK, 30.05
		exibirEstadoCivil(quicoPai);
		
		// Testando divorciada - OK, 30.05
		exibirEstadoCivil(maeDaChiquinha);
		
			
		System.out.println();
		System.out.println();
		System.out.println("==================== TESTANDO DIVÓRCIO ====================");
		
		exibirHistoricoDeDivorcios(seuMadruga);
		exibirHistoricoDeDivorcios(maeDaChiquinha);
		exibirHistoricoDeDivorcios(donaFlorinda);
		exibirHistoricoDeDivorcios(quicoPai);
		
		
		System.out.println();
		System.out.println();
		System.out.println("==================== TESTANDO IMC ====================");
		
		exibirAnaliseIMC(donaMadruga);
		exibirAnaliseIMC(sirNeves);
		exibirAnaliseIMC(donaNeves);
		exibirAnaliseIMC(maeDaChiquinha);
		exibirAnaliseIMC(bruxaDo71);
		exibirAnaliseIMC(donaFlorinda);
		exibirAnaliseIMC(chiquinha);
		exibirAnaliseIMC(kika);
		
	}
				
	private static void exibirHistoricoDeCasamentos(Pessoa pessoa) {

		System.out.println("Exibindo as pessoas com quem eu, " + pessoa.getNome() + ", casei: ");

		List<Pessoa> pessoasComQuemCasei = pessoa.obterHistoricoDeCasamento();

		for (Pessoa p : pessoasComQuemCasei) {
			System.out.println("   - Nome: " + p.getNome());
		}

		System.out.println();

	}
	
	private static void exibirHistoricoDeDivorcios(Pessoa pessoa) {

		System.out.println("");
		System.out.println("Eu, " + pessoa.getNome() + ", já me divorciei de: ");

		for (Pessoa p : pessoa.getExConjuges()) {
			System.out.println("   - Nome: " + p.getNome());
		}

	}
	
	private static void exibirFilhos(Pessoa pessoa) {

		if (pessoa.getFilhos().size() < 1) {
			System.out.println(pessoa.getNome() + " não tem filhos");
			System.out.println("");
		} else {

			System.out.println("Exibindo os filhos de, " + pessoa.getNome());

			for (Pessoa p : pessoa.getFilhos()) {
				System.out.println("   - Nome: " + p.getNome());
			}
			System.out.println("");
		}

	}
	
	private static void exibirEstadoCivil(Pessoa pessoa) {
		System.out.println("");
		System.out.println("O estado civil d@ " + pessoa.getNome() + " é " + pessoa.obterEstadoCivil());
	}
	
	private static void exibirAnaliseIMC(Pessoa p1) {
			
			double imc = 0;
			DecimalFormat frmt = new DecimalFormat("##0.0");
	
			System.out.println("");
			System.out.println("Exibindo análise de IMC de " + p1.getNome());		
			
			if (p1 instanceof Mulher) {
				if ((((Mulher)p1).getAltura()) > 0 && (((Mulher)p1).getPeso() > 0)) {
					imc = ((Mulher) p1).calcularIMC();
					ClassificaIMC ClassificaIMC = ((Mulher)p1).classificaIMC(imc);
					switch (ClassificaIMC) {
					case ABAIXO_DO_PESO:
						System.out.println(p1.getNome() + " está com IMC igual a " +frmt.format(imc)+" estando "+"ABAIXO DO PESO");
						break;
					case PESO_NORMAL:
						System.out.println(p1.getNome() + " está com IMC igual a " +frmt.format(imc)+" estando "+"COM PESO NORMAL");;
						break;
					case SOBREPESO:
						System.out.println(p1.getNome() + " está com IMC igual a " +frmt.format(imc)+" estando "+"COM EXCESSO DE PESO (SOBREPESO)");
						break;
					case OBESIDADE_GRAU_I:
						System.out.println(p1.getNome() + " está com IMC igual a " +frmt.format(imc)+" estando "+"COM OBESIDADE CLASSE I");
						break;
					case OBESIDADE_GRAU_II:
						System.out.println(p1.getNome() + " está com IMC igual a " +frmt.format(imc)+" estando "+"COM OBESIDADE CLASSE II");
						break;
					case OBESIDADE_GRAU_III:
						System.out.println(p1.getNome() + " está com IMC igual a " +frmt.format(imc)+" estando "+"COM OBESIDADE CLASSE III");
						break;
					}
				}
			} else {
				System.out.println(p1.getNome()+" é homem - não tem peso e altura e, portando, não é possível analisar o IMC.");
			}
		}


	
}
