package br.com.franca.puc.model.command;

import br.com.franca.puc.model.pedido.Pedido;

public class PedidoCommand extends Command {

	private Pedido receiver;

	public PedidoCommand(Pedido receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.fecharPedido();
	}

}
