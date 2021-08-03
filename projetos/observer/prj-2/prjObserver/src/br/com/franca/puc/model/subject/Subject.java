package br.com.franca.puc.model.subject;

import java.util.ArrayList;
import java.util.List;

import br.com.franca.puc.model.observer.Observer;

public abstract class Subject {

	private List<Observer> observers = new ArrayList<>();

	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	public void detach(Observer observer) {
		this.observers.remove(observer);
	}

	public void notifyObservers() {
		observers.forEach(o -> o.update());
	}

}
