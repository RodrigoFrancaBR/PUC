package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public abstract class DescontoDoOrcamento {
	
	protected DescontoDoOrcamento proximoDesconto;
	
	public DescontoDoOrcamento(DescontoDoOrcamento proximoDesconto) {
		this.proximoDesconto = proximoDesconto;
	}
	// Todos os descontos precisam verficar se o desconto é valido para um orcamento
	// O core dessa validação é única para cada desconto, por isso método abstrato para deixar cada desconto dar seu comportamento
	// Todos os descontos precisam efetuar o desconto caso o desconto seja valido
	// O core desse desconto é unico para cada desconto, por isso metodo abstrato para deixar cada desconto dar seu comportamento 
	// pode se colocar final para garantir que ninguém vai modificar o comportamento do método 

	public final BigDecimal calcular(Orcamento orcamento){
		return descontoValido(orcamento) ? efetuarDesconto(orcamento): this.proximoDesconto.calcular(orcamento);
	}
	
	protected abstract BigDecimal efetuarDesconto(Orcamento orcamento);		
		
	protected abstract boolean descontoValido(Orcamento orcamento);

}
