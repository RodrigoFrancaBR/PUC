package br.com.puc.domain;

public class Director {

	public void buildCasaSimples(Builder builder) {
		builder.buildParedes(4);
		builder.buildPortas(2);
		builder.buildJanelas(1);
		builder.buildTelhado();		
	}

	public void buildCasaComPiscina(Builder builder) {
		builder.buildParedes(4);
		builder.buildPortas(3);
		builder.buildJanelas(2);
		builder.buildTelhado();
		// Cast.. para devolver a casa com piscina...
		CasaComPiscinaBuilder casaComPiscinaBuilder = (CasaComPiscinaBuilder) builder;
		casaComPiscinaBuilder.buildPiscina();
	}

	public void buildCasaComGaragem(Builder builder) {
		builder.buildParedes(4);
		builder.buildPortas(3);
		builder.buildJanelas(2);
		builder.buildTelhado();
		// Cast.. para devolver a casa com piscina...
		CasaComGaragemBuilder casaComGaragemBuilder = (CasaComGaragemBuilder) builder;
		casaComGaragemBuilder.buildGaragem();

	}

}
