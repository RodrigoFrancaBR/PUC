package br.com.franca.puc.model.desconto;

import java.math.BigDecimal;

import br.com.franca.puc.model.orcamento.Orcamento;

public abstract class DescontoDoOrcamento {
	
	protected DescontoDoOrcamento proximoDesconto;
	
	public DescontoDoOrcamento(DescontoDoOrcamento proximoDesconto) {
		this.proximoDesconto = proximoDesconto;
	}
	
	public abstract BigDecimal calcular(Orcamento orcamento);				
	

}
