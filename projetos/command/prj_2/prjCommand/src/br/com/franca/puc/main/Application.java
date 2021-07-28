package br.com.franca.puc.main;

import br.com.franca.puc.model.Document;
import br.com.franca.puc.model.command.CloseCommand;
import br.com.franca.puc.model.command.CutCommand;
import br.com.franca.puc.model.command.OpenCommand;
import br.com.franca.puc.model.command.PasteCommand;
import br.com.franca.puc.model.menu.MenuInvoker;

public class Application {

	public static void main(String[] args) {

		// outros commands save, delete etc...

		String open = "open";
		String close = "close";
		String cute = "cute";
		String paste = "paste";

		MenuInvoker.add(open, new OpenCommand(new Document()));
		MenuInvoker.add(close, new CloseCommand(new Document()));
		MenuInvoker.add(cute, new CutCommand(new Document()));
		MenuInvoker.add(paste, new PasteCommand(new Document()));

		MenuInvoker.invoker(open);
		MenuInvoker.invoker(close);
		MenuInvoker.invoker(cute);
		MenuInvoker.invoker(paste);
	}

}
