package br.com.franca.puc.model.subject;

public class ConcreteSubject extends Subject {

	private String state;

	public String getState() {
		return this.state;
	}

	// algum m�todo que modifique o estado do seu objeto
	public void setState(String state) {
		this.state = state;
		notifyObservers();
	}

}
