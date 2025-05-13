// VisitorExample.java
//package Estrutural.Visitor;

import java.util.* ; 

// Interface Element
interface Element {
    void accept(Visitor visitor);
}

// Implementação concreta de Element
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "Comportamento A";
    }
}

class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "Comportamento B";
    }
}

// Interface Visitor
interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

// Implementação concreta de Visitor
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("Visitando " + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("Visitando " + element.operationB());
    }
}

public class VisitorExample {
    public static void main(String[] args) {
        List<Element> elements = Arrays.asList(new ConcreteElementA(), new ConcreteElementB());
        Visitor visitor = new ConcreteVisitor();

        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
