package br.com.franca.puc.main;

import br.com.franca.puc.model.observer.ConcreteObserver;
import br.com.franca.puc.model.observer.Observer;
import br.com.franca.puc.model.subject.ConcreteSubject;

public class Main {

	public static void main(String[] args) {

		// representa o seu objeto que pode mudar de estado.
		ConcreteSubject subject = new ConcreteSubject();

		// observadores que precisam fazer alguma coisa qdo meu objeto mudar de estado
		Observer o1 = new ConcreteObserver(subject);
		Observer o2 = new ConcreteObserver(subject);
		
		// meu objeto que sabe quem precisa ser notificado faz todo sentido ele norificar os interessados.
		subject.attach(o1);
		subject.attach(o2);
		
		
		// mudando o estado do meu objeto algum metodo específico da minha app 
		subject.setState("novo estado ");
	}

}
