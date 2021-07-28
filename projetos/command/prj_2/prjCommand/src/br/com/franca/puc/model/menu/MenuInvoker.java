package br.com.franca.puc.model.menu;

import java.util.HashMap;
import java.util.Map;

import br.com.franca.puc.model.Document;
import br.com.franca.puc.model.command.CloseCommand;
import br.com.franca.puc.model.command.Command;
import br.com.franca.puc.model.command.CutCommand;
import br.com.franca.puc.model.command.OpenCommand;
import br.com.franca.puc.model.command.PasteCommand;

public class MenuInvoker {

	private static Map<String, Command> commands = new HashMap<>();

	static {
		commands.put("open", new OpenCommand(new Document()));
		commands.put("close", new CloseCommand(new Document()));
		commands.put("cut", new CutCommand(new Document()));
		commands.put("paste", new PasteCommand(new Document()));
	}

	public static void add(String commandName, Command command) {
		// valida se já existe no mapa antes de colocar
		// não precisa jogar exception, apenas não colocar no mapa o repetido
		commands.put(commandName, command);
	}

	public static void invoker(String commandName) {
		commands.get(commandName).execute();
	}
}
