package br.com.franca.puc.model;

public class Document {

	public Document() {
	}

	public void open() {
		System.out.println("Executando o comando de Abrir");
	}

	public void close() {
		System.out.println("Executando o comando de Fechar");
	}

	public void cut() {
		System.out.println("Executando o comando de Recortar");
	}

	public void copy() {
		System.out.println("Executando o comando de Copiar");
	}

	public void paste() {
		System.out.println("Executando o comando de Colar");
	}
}
