//package Estrutural.Observer;

import java.util.ArrayList;
import java.util.List;

// Interface Observer.
interface Observer {
    void update(String message);
}

// Classe concreta de Observer.
class FileWatcher implements Observer {
    private String name;

    public FileWatcher(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu a notificação: " + message);
    }
}

// Interface Subject.
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

// Classe concreta Subject.
class FileSubject implements Subject {
    private List<Observer> observers;

    public FileSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Main para testar o padrão Observer.
public class FileObserverExample {
    public static void main(String[] args) {
        FileSubject subject = new FileSubject();

        Observer watcher1 = new FileWatcher("Observador 1");
        Observer watcher2 = new FileWatcher("Observador 2");

        subject.addObserver(watcher1);
        subject.addObserver(watcher2);

        subject.notifyObservers("O arquivo foi alterado.");
        subject.notifyObservers("O arquivo foi deletado.");
    }
}
