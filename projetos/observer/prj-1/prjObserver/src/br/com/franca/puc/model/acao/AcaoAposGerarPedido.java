package br.com.franca.puc.model.acao;

import br.com.franca.puc.model.pedido.Pedido;

public interface AcaoAposGerarPedido {
	
	public abstract void executar(Pedido pedido);

}
