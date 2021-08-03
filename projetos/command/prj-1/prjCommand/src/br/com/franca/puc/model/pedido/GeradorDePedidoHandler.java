package br.com.franca.puc.model.pedido;

import java.time.LocalDateTime;

import br.com.franca.puc.model.orcamento.Orcamento;

public class GeradorDePedidoHandler {
	// dao
	// service
	public void executar(GeradorDePedido dadosDoPedido) {
		System.out.println("Executando");
		Pedido p = new Pedido(dadosDoPedido.getCliente(), LocalDateTime.now(),
				new Orcamento(dadosDoPedido.getValorDoOrcamento(), dadosDoPedido.getQuantidadeDeItens()));

		System.out.println("dao. Algum comando para salvar no banco de dados");
		System.out.println("service. Algum comando para enviar uma requisicao http");

	}
}
