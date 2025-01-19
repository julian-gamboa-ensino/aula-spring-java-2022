// CompositeExample.java
//package Estrutural.Composite;

import java.util.ArrayList;
import java.util.List;

// Interface Component: Definição das operações comuns
interface Component {
    void operation();
}

// Leaf: Elemento simples, sem filhos
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " operation.");
    }
}

// Composite: Componente composto, pode ter filhos
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    // Adiciona um filho ao composite
    public void add(Component component) {
        children.add(component);
    }

    // Remove um filho do composite
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite operation started...");
        for (Component child : children) {
            child.operation(); // Delegando operação para os filhos
        }
    }
}

public class CompositeExample {
    public static void main(String[] args) {
        // Criando folhas
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");

        // Criando um composite e adicionando as folhas
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        // Executando a operação, que será delegada para as folhas
        composite.operation();
    }
}
