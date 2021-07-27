package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.exception.SituacaoDoOrcamentoException;
/**
 * Or�amento est� com duas responsabilidades, 
 * 1 Calcular o desconto baseado no estado e efetuar o desconto no orcamento
 * e outra para aplicar a transi��o de estado aprovar reprovar etc..
 *   
 * @author Rodrigo
 *
 */
public class Orcamento {
	private BigDecimal valor;
	// Item poderia ser uma classe...
	private int quantidadeDeItens;
	// transformando em classe
	// private String situacao;
	private SituacaoDoOrcamento situacao;

	public Orcamento(BigDecimal valor, int quantidadeDeItens) {
		this.valor = valor;
		this.quantidadeDeItens = quantidadeDeItens;
		// this.situacao = "Em Analise";
		this.situacao = new EmAnalise();
	}

	public BigDecimal obterValor() {
		return valor;
	}

	public int obterQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	// ifs que v�o crescer
	
	/**
	private BigDecimal calcularDescontoExtra() {
		BigDecimal descontoEstra = BigDecimal.ZERO;

		if (situacao.equalsIgnoreCase("Em Analise")) {
			descontoEstra = valor.multiply(new BigDecimal("0.05"));
		} else if (situacao.equalsIgnoreCase("Aprovado")) {
			descontoEstra = valor.multiply(new BigDecimal("0.02"));
		}

		return descontoEstra;
	}*/

	private BigDecimal calcularDescontoExtra() {
		return this.situacao.calcularDescontoExtra(this);		
	}

	// quem fornece o desconto eh a situa��o e n�o o orcamento
	
	/**
	public void efetuarDescontoExtra() {
		BigDecimal descontoExtra = this.calcularDescontoExtra();
		BigDecimal subtract = this.valor.subtract(descontoExtra);
		this.valor = subtract;
	}*/
	
	public void efetuarDescontoExtra(){
		BigDecimal descontoExtra = this.calcularDescontoExtra();
		this.valor = this.valor.subtract(descontoExtra);
	}

	// transi��o de estados.. Cada estado deveria saber se pode trocar de estado e pra qual
	
	/**
	public void aprovar() {
		if (this.situacao.equalsIgnoreCase("Em Analise")) {
			this.situacao = "Aprovado";
		}
		throw new RuntimeException("S� pode aprovar se for Em Analise");
	}*/

	public SituacaoDoOrcamento obterSituacao() {
		return this.situacao;
	}

	protected void atualizarSituacao(SituacaoDoOrcamento situacao) {
		this.situacao = situacao;
	}
	
	public void aprovar() throws SituacaoDoOrcamentoException{
		// suponha que o orcamento esteja em analise, 
		// teria que ter um if.. se for diferente de em analise dispara exception
		// se nao muda o estado para aprovado
		// esse if est� implicito no metodo aprovar da subclasse situacao.. 
		// pois o metodo aprovar vai disparar exception 
		// se o estado for diferente de em analise 
		// pode disparar uma exception
		// o orcamento n�o precisa tratar isso
		// pois a exce��o que pode disparar � por conta
		// da situa��o do orcamento que alguem que nao foi o orcamento configurou
		// n�o foi o orcamento que definiu seu estado mas alguem de fora 
		// com exce��o do primeiro estado qdo se cria um orcamento
		this.situacao.aprovar(this);
	}

	public void finalizar() throws SituacaoDoOrcamentoException {
		this.situacao.finalizar(this);		
	}

	public void reprovar() throws SituacaoDoOrcamentoException {
		this.situacao.reprovar(this);
	}

	public void colocarEmAnalise() throws SituacaoDoOrcamentoException {
		this.situacao.colocarEmAnalise(this);
		
	}

}
