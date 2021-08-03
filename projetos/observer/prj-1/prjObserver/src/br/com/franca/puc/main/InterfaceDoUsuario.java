package br.com.franca.puc.main;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.franca.puc.model.Cliente;
import br.com.franca.puc.model.acao.AcaoAposGerarPedido;
import br.com.franca.puc.model.acao.EmailService;
import br.com.franca.puc.model.acao.PedidoDAO;
import br.com.franca.puc.model.orcamento.Orcamento;
import br.com.franca.puc.model.pedido.GeradorDePedido;
import br.com.franca.puc.model.pedido.GeradorDePedidoHandler;

/**
 * pode ser uma controller view interface de comando Poderia receber os
 * parametros ou os objetos o recebi o Orcamento, cliente pedido do front por
 * exemplo.. chegou aqui na main
 * 
 * @author Rodrigo
 *
 */
public class InterfaceDoUsuario {

	public static void main(String[] args) {
		 		
		 // REGRAS DE NEGOCIO
		/// servico externo pode me passar um orcamento
		// se não eu teria que passar o valor e a quantidade de ites aqui 
		Orcamento orcamento1 = new Orcamento(new BigDecimal("200"), 6);

		// o cliente vem pela web.. 
		Cliente cliente = new Cliente("Rodrigo", "102345678912");
		
		// data pego na hora de gerar o pedido
		// LocalDateTime data = LocalDateTime.now();
		
		// na controller nao recebemos um pedido.. 
		// Pedido p = new Pedido(cliente, data, orcamento1);

		// passar no construtor ou em um metodo gerar..
		GeradorDePedido dadosDoPedido = new GeradorDePedido(cliente, orcamento1.obterValor(), orcamento1.obterQuantidadeDeItens());

		// passa as dependencias externas no construtor
		List<AcaoAposGerarPedido> asList = Arrays.asList(new PedidoDAO(), new EmailService());
		
		GeradorDePedidoHandler handler = new GeradorDePedidoHandler(asList);
		
		handler.executar(dadosDoPedido);
		
		
		// DEPENDENCIAS PARA EXTERNAS
			// vao ser injetados 
		// System.out.println("Algum comando para salvar no banco de dados");
		// System.out.println("Algum comando para enviar uma requisicao http");
		
	}

}
