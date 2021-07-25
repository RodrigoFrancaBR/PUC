package br.com.franca.puc.model.orcamento;

import java.math.BigDecimal;

public class Orcamento {
	private BigDecimal valor;
	// Item poderia ser uma classe...
	private int quantidadeDeItens;
	private String situacao;

	public Orcamento(BigDecimal valor, int quantidadeDeItens) {
		this.valor = valor;
		this.quantidadeDeItens = quantidadeDeItens;
		this.situacao = "Em Analise";
	}

	public BigDecimal obterValor() {
		return valor;
	}

	public int obterQuantidadeDeItens() {
		return quantidadeDeItens;
	}
	
	private BigDecimal calcularDescontoExtra(){
		BigDecimal descontoEstra = BigDecimal.ZERO;
		
		if (situacao.equalsIgnoreCase("Em Analise")){
			descontoEstra = valor.multiply(new BigDecimal("0.05"));			
		}else if (situacao.equalsIgnoreCase("Aprovado")){
			descontoEstra = valor.multiply(new BigDecimal("0.02"));
		}
		
		return descontoEstra;
	}
	
	public void efetuarDescontoExtra(){
		BigDecimal descontoExtra = this.calcularDescontoExtra();
		BigDecimal subtract = this.valor.subtract(descontoExtra);
		this.valor = subtract;		
	}
	
	public void aprovar(){
		if (this.situacao.equalsIgnoreCase("Em Analise")){
			this.situacao = "Aprovado";	
		}
		throw new RuntimeException("Só pode aprovar se for Em Analise");
	}
	
	public String obterSituacao(){
		return this.situacao;
	}

}
