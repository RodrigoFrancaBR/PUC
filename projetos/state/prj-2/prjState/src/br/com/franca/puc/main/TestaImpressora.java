package br.com.franca.puc.main;

import br.com.franca.puc.model.state.Impressora;
import br.com.franca.puc.model.state.exception.NaoPodeDesligarException;
import br.com.franca.puc.view.ImpressoraView;

public class TestaImpressora {

	public static void main(String[] args) {
		ImpressoraView tela = new ImpressoraView();

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
			imp.colocarTinta();
			imp.imprimir(); // sem tinta ok
			// imp.pausarImpressao();
			// imp.cancelarImpressao();

			// imp.ligar();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				imp.desligar();
			} catch (NaoPodeDesligarException e) {
				e.printStackTrace();
				System.out.println("Não foi possivel desligar a impressora, " + e.getMessage() + ".");
			}
		}
	}

}
