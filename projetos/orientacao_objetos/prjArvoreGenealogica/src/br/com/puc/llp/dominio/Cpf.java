package br.com.puc.llp.dominio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Qualquer coisa diferente disso é inválido
 */
public abstract class Cpf {	

	/**
	 * Valida se um cpf é válido baseado na regra:
	 *  Todo cpf tem que ser número de 11 digitos sem traços (-) ou pontos (.)
	 * @param cpf
	 * @return true ou false
	 */
	public static boolean cpfValido(String cpf) {

		if (cpf == null || cpf.contains("-") || cpf.contains(".")) {
			return false;
		}

		if (cpf.length() != 11) {
			return false;
		}

		try {
			Long.valueOf(cpf);
		} catch (NumberFormatException e) {
			System.out.println("CPF:" + cpf + " não é válido");
			return false;
		}

		return true;

	}
	/**
	 * Cria um cpf aleatorio 
	 * @param cpf
	 * @return
	 */
	public static String criarCPF() {
		String cpfDefault = "12345678911";					
		
		String primeiroCaracter = cpfDefault.substring(0, 1);
		
		int primeiroValor = new Random().nextInt(9) + 1;
		
		String cpfReplace = cpfDefault.replace(primeiroCaracter, Integer.toString(primeiroValor));

		String[] cpfSplit = cpfReplace.split("");
		
		List<String> cpfAsList = Arrays.asList(cpfSplit);
		
		Collections.shuffle(cpfAsList);
		
		StringBuilder builder = new StringBuilder();		
		
		for (String string : cpfAsList) {
			 builder.append(string);
		}
		
		String cpfShuffle = builder.toString();
		
		return cpfShuffle;

	}

}
