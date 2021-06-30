package br.com.puc.teste;

import br.com.puc.domain.Builder;
import br.com.puc.domain.Casa;
import br.com.puc.domain.CasaBuilder;
import br.com.puc.domain.CasaComGaragemBuilder;
import br.com.puc.domain.CasaComPiscinaBuilder;
import br.com.puc.domain.Director;

public class Main {

	public static void main(String[] args) {

		Director director = new Director();

		// casa builder
		Builder casaBuilder = new CasaBuilder();
		director.buildCasaSimples(casaBuilder);
		Casa casaComBuilder = casaBuilder.buildCasa();
		System.out.println(casaComBuilder.toString());

		// casa com piscina
		Builder casaComPiscinaBuilder = new CasaComPiscinaBuilder();
		director.buildCasaComPiscina(casaComPiscinaBuilder);
		Casa casaComPiscina = casaComPiscinaBuilder.buildCasa();
		System.out.println(casaComPiscina.toString());

		// casa com garagem
		Builder casaComGaragemBuilder = new CasaComGaragemBuilder();
		director.buildCasaComGaragem(casaComGaragemBuilder);
		Casa casaComGaragem = casaComGaragemBuilder.buildCasa();
		System.out.println(casaComGaragem.toString());

	}

}
