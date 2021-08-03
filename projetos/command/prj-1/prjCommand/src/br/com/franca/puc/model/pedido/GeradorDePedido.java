package br.com.franca.puc.model.pedido;

import java.math.BigDecimal;

import br.com.franca.puc.model.cliente.Cliente;

public class GeradorDePedido {
	
	private Cliente cliente;
	private BigDecimal valorDoOrcamento;
	private int quantidadeDeItens;

	public GeradorDePedido(Cliente cliente, BigDecimal valorDoOrcamento, int quantidadeDeItens) {
		this.cliente = cliente;
		this.valorDoOrcamento = valorDoOrcamento;
		this.quantidadeDeItens = quantidadeDeItens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public BigDecimal getValorDoOrcamento() {
		return valorDoOrcamento;
	}

	public int getQuantidadeDeItens() {
		return quantidadeDeItens;
	}

}
