package br.com.franca.puc.model.pedido;

import java.time.LocalDateTime;

import br.com.franca.puc.model.cliente.Cliente;
import br.com.franca.puc.model.orcamento.Orcamento;

public class Pedido {
	
	private Cliente cliente;
	private LocalDateTime data;
	private Orcamento orcamento;

	public Pedido(Cliente cliente, LocalDateTime data, Orcamento orcamento) {
		this.cliente = cliente;
		this.data = data;
		this.orcamento = orcamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public void fecharPedido() {
		System.out.println("Fechando Pedido");
	}

}
