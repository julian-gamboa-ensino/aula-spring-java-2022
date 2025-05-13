// MementoExample.java
//package Estrutural.Memento;
import java.util.*;

// Classe que deseja salvar seu estado
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("Estado atual: " + state);
    }

    public String getState() {        
        return this.state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("Estado restaurado: " + state);
    }
    
    }
    
    // Memento que armazena o estado
    class Memento {
        private final String state;
    
        public Memento(String state) {
            this.state = state;
        }
    
        public String getState() {
            return state;
        }
    }
    
    // Caretaker que gerencia os Mementos
    class Caretaker {
        private final List<Memento> mementoList = new ArrayList<>();
    
        public void add(Memento state) {
            mementoList.add(state);
        }
    
        public Memento get(int index) {
            return mementoList.get(index);
        }
    }
    
    public class MementoExample {
        public static void main(String[] args) {
            Originator originator = new Originator();
            Caretaker caretaker = new Caretaker();
    
            originator.setState("Estado #1");
            caretaker.add(originator.saveStateToMemento());
    
            originator.setState("Estado #2");
            caretaker.add(originator.saveStateToMemento());
    
            originator.setState("Estado #3");
            System.out.println("Estado atual: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(0));
        originator.getStateFromMemento(caretaker.get(1));
    }
}
