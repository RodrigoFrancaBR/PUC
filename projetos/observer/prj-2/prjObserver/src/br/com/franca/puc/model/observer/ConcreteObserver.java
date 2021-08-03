package br.com.franca.puc.model.observer;

import br.com.franca.puc.model.subject.ConcreteSubject;

public class ConcreteObserver extends Observer {
	
	private ConcreteSubject cs;
	
	public ConcreteObserver(ConcreteSubject cs) {
		this.cs = cs;
		// observer se inscreve no subject
		cs.attach(this);
	}

	// o que a aplicação precisa fazer quando um subjetc for modificado
	@Override
	public void update() {
		// se a aplicação precisa de alguma informação do subjet vc precisa ter
		// uma referencia de subject aqui no observer
		System.out.println("faz algo " + this.cs.getState());
	}

}
