package br.com.puc.llp.dominio;

public class Homem extends Pessoa {

	public Homem(String cpf, String nome, int idade) {
		super(cpf,nome,idade);		
	}

	private String timeDeFutebolDoCoracao;

	public String getTimeDeFutebolDoCoracao() {
		return timeDeFutebolDoCoracao;
	}

	public void setTimeDeFutebolDoCoracao(String timeDeFutebolDoCoracao) {
		this.timeDeFutebolDoCoracao = timeDeFutebolDoCoracao;
	}

}
