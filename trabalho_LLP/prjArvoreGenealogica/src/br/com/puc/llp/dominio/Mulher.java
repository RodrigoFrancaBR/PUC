package br.com.puc.llp.dominio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Mulher extends Pessoa implements CalculoDePeso {
	
	public Mulher(String cpf, String nome,
			int idade, double peso, double altura) {
		
		super(cpf,nome,idade);
		
		if (!eValidaAlturaEPeso(altura,peso)){
			throw new IllegalArgumentException("Altura precisa ser maior que 0.5 e "
					+ "peso maior que 2kg");
		}
		
		this.peso = peso;
		this.altura = altura;
	}
	
	/*	
	public double calcularIMC() throws IllegalArgumentException{
		if (!eValidaAlturaEPeso(altura,peso)){
			throw new IllegalArgumentException("Altura precisa ser maior que 0.5 e peso maior que 2kg");
		}
		
		return this.peso / Math.pow(this.altura,2);
	
	}
	*/
	
	/**
	 * Calcula o imc da pessoa Para calcular qualquer tipo de potências, da
	 * forma: a^b onde a e b são do tipo double, usamos o método pow() da classe
	 * Math
	 */
	@Override
	public double calcularIMC() {
		double imc = 0;
		NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
		((DecimalFormat)frmt).applyPattern("##0.00");
		if (!eValidaAlturaEPeso(altura,peso)){
			throw new IllegalArgumentException("Altura precisa ser maior que 0.5 e peso maior que 2kg");
		}
		imc = Double.parseDouble(frmt.format(this.peso / Math.pow(this.altura,2)));
		return imc;
	}

	/**
	 * 
	 * @param imc double
	 * @return Uma classificação de imc
	 */
	public ClassificaIMC classificaIMC(double imc) {

		ClassificaIMC classificaIMC;

		if (imc < 18.5) {
			classificaIMC = ClassificaIMC.ABAIXO_DO_PESO;
			return classificaIMC;
		}
		if (imc < 25) {
			classificaIMC = ClassificaIMC.PESO_NORMAL;
			return classificaIMC;
		}
		if (imc < 30) {
			classificaIMC = ClassificaIMC.SOBREPESO;
			return classificaIMC;
		}
		if (imc < 35) {
			classificaIMC = ClassificaIMC.OBESIDADE_GRAU_I;
			return classificaIMC;
		}
		if (imc < 40) {
			classificaIMC = ClassificaIMC.OBESIDADE_GRAU_II;
			return classificaIMC;
		}
		classificaIMC = ClassificaIMC.OBESIDADE_GRAU_III;
		return classificaIMC;
	}

/**
 * Valida se uma altura ou peso está na regra
 * @param altura
 * @param peso
 * @return true ou false
 */
	private boolean eValidaAlturaEPeso(double altura, double peso) {
		if (altura < 0.5 || peso < 2) {
			return false;
		}
		return true;
	}

	private String timeDeBasquete;
	private double peso;
	private double altura;

	public String getTimeDeBasquete() {
		return timeDeBasquete;
	}

	public void setTimeDeBasquete(String timeDeBasquete) {
		this.timeDeBasquete = timeDeBasquete;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}
