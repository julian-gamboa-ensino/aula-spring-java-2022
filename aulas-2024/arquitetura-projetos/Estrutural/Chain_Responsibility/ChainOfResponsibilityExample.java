// ChainOfResponsibilityExample.java
//package Estrutural.Chain_Responsibility;

import java.util.Map;

// Handler: Classe abstrata que define a responsabilidade e a cadeia
abstract class Handler {
    protected Handler nextHandler;

    // Define o próximo manipulador na cadeia
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    // Método que será sobrescrito pelos manipuladores concretos
    public abstract void handleRequest(int request);
}

// ConcreteHandlerA: Manipulador que lida com requisições menores que 10
class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request < 10) {
            System.out.println("Handler A handled request: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request); // Passa para o próximo
        }
    }
}

// ConcreteHandlerB: Manipulador que lida com requisições entre 10 e 20
class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("Handler B handled request: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request); // Passa para o próximo
        }
    }
}

// ConcreteHandlerC: Manipulador que lida com requisições maiores que 20
class ConcreteHandlerC extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 20) {
            System.out.println("Handler C handled request: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request); // Passa para o próximo
        }
    }
}

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        // Criando manipuladores concretos
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();

        // Encadeando os manipuladores
        handlerA.setNextHandler(handlerB);
        handlerB.setNextHandler(handlerC);

        // Fazendo uma requisição
        handlerA.handleRequest(15);  // Será tratado por HandlerB
    }
}
