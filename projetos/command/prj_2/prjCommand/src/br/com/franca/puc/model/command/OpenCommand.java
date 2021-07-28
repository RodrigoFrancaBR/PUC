package br.com.franca.puc.model.command;

import br.com.franca.puc.model.Document;

public class OpenCommand extends Command {
	private Document receiver;

	public OpenCommand(Document receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// se a l�gica de executar o commando de fechar for algo simples n�o
		// precisa de um Receiver
		// posso ter v�rios Receiver, um para cada command
		// PastReceiver, CutReceiver ou posso ter um �nico Receiver
		// DocumentReceiver que faz todos os commands
		receiver.open();
	}

}
