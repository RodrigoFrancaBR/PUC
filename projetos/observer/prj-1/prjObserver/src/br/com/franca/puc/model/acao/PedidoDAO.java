package br.com.franca.puc.model.acao;

import br.com.franca.puc.model.pedido.Pedido;

public class PedidoDAO implements AcaoAposGerarPedido{
	@Override
	public void executar(Pedido pedido) {
		System.out.println("Salvando");		
	}
}
