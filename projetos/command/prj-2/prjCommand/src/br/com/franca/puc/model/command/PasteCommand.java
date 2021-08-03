package br.com.franca.puc.model.command;

import br.com.franca.puc.model.Document;

public class PasteCommand extends Command {

	private Document document;

	public PasteCommand(Document document) {
		this.document = document;
	}

	@Override
	public void execute() {	
		// se a lógica de executar o commando de fechar for algo simples não
		// precisa de um Receiver
		// posso ter vários Receiver, um para cada command
		// PastReceiver, CutReceiver ou posso ter um único Receiver
		// DocumentReceiver que faz todos os commands
		document.paste();
	}
}
