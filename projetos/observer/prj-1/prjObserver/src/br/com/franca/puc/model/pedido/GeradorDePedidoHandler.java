package br.com.franca.puc.model.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.franca.puc.model.acao.AcaoAposGerarPedido;
import br.com.franca.puc.model.orcamento.Orcamento;

public class GeradorDePedidoHandler {
	// dao
	// service
	//
	private List<AcaoAposGerarPedido> acaoAposGerarPedido;

	public GeradorDePedidoHandler(List<AcaoAposGerarPedido> acaoAposGerarPedido) {
		this.acaoAposGerarPedido = acaoAposGerarPedido;	
	}

	public void executar(GeradorDePedido dadosDoPedido) {
		System.out.println("Executando");
		Pedido pedido = new Pedido(dadosDoPedido.getCliente(), LocalDateTime.now(),
				new Orcamento(dadosDoPedido.getValorDoOrcamento(), dadosDoPedido.getQuantidadeDeItens()));
		
		acaoAposGerarPedido.forEach(action->action.executar(pedido));
		
		// new PedidoDAO().executar(pedido);
		// new EmailService().executar(pedido);

		// System.out.println("dao. Algum comando para salvar no banco de
		// dados");
		// System.out.println("service. Algum comando para enviar uma requisicao
		// http");

	}
}
