package br.com.franca.puc.main;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;
import br.com.franca.puc.model.orcamento.exception.SituacaoDoOrcamentoException;

public class CalcularDescontoExtra {
	
	public static void main(String[] args) throws SituacaoDoOrcamentoException {

		Orcamento orcamento1 = new Orcamento(new BigDecimal("200"), 6);
		Orcamento orcamento2 = new Orcamento(new BigDecimal("200"), 4);
		Orcamento orcamento3 = new Orcamento(new BigDecimal("600"), 1);
		
		orcamento1.efetuarDescontoExtra();
		orcamento1.aprovar();
		orcamento1.finalizar();
		orcamento1.reprovar();
		orcamento1.colocarEmAnalise();
		
		orcamento2.efetuarDescontoExtra();
		orcamento3.efetuarDescontoExtra();
				
		System.out.println("################: " + orcamento1.obterValor());
		System.out.println(orcamento1.obterSituacao());
		
		System.out.println("################: " + orcamento2.obterValor());
		System.out.println(orcamento2.obterSituacao());
		
		System.out.println("################: " + orcamento3.obterValor());
		System.out.println(orcamento3.obterSituacao());
		
	}
}
