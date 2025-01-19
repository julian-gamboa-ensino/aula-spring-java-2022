// TemplateMethodExample.java
//package Estrutural.Template_Method;

// Classe abstrata definindo o template method
abstract class AbstractClass {
    
    // Método template, define o esqueleto da operação
    public void templateMethod() {
        stepOne();
        stepTwo();
        stepThree();
    }

    // Etapas que devem ser implementadas pelas subclasses
    protected abstract void stepOne();
    protected abstract void stepTwo();
    protected abstract void stepThree();
}

// ConcreteClassA: Implementação do TemplateMethod para a classe A
class ConcreteClassA extends AbstractClass {

    @Override
    protected void stepOne() {
        System.out.println("ConcreteClassA - Step 1");
    }

    @Override
    protected void stepTwo() {
        System.out.println("ConcreteClassA - Step 2");
    }

    @Override
    protected void stepThree() {
        System.out.println("ConcreteClassA - Step 3");
    }
}

// ConcreteClassB: Implementação do TemplateMethod para a classe B
class ConcreteClassB extends AbstractClass {

    @Override
    protected void stepOne() {
        System.out.println("ConcreteClassB - Step 1");
    }

    @Override
    protected void stepTwo() {
        System.out.println("ConcreteClassB - Step 2");
    }

    @Override
    protected void stepThree() {
        System.out.println("ConcreteClassB - Step 3");
    }
}

public class TemplateMethodExample {
    public static void main(String[] args) {
        // Criando instâncias das classes concretas
        AbstractClass classA = new ConcreteClassA();
        classA.templateMethod(); // Executa o template method da ConcreteClassA

        AbstractClass classB = new ConcreteClassB();
        classB.templateMethod(); // Executa o template method da ConcreteClassB
    }
}
