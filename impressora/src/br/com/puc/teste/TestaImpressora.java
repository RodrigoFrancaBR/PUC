package br.com.puc.teste;

import br.com.puc.state.Impressora;
import br.com.puc.state.exception.NaoPodeDesligarException;

public class TestaImpressora {

	public static void main(String[] args) throws NaoPodeDesligarException {
		/**
		 * padrão inicia com estado desligada...
		 */
		Impressora imp = new Impressora();

		try {
			imp.ligar();
			imp.imprimir();
			imp.pausarImpressao();
			imp.imprimir(); // volta a imprimir
			imp.terminarImpressao(); // deixar impressora no estado pronta
			imp.imprimirUltimaFolha();
			
			//imp.imprimir();
			//imp.pausarImpressao();
			//imp.cancelarImpressao();
			//imp.colocarTinta();
			//imp.ligar();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			imp.desligar();
		}
	}

}
