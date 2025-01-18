//	package Estrutural.Decorator;

// Interface base para café.
interface Coffee {
    String getDescription();
    double getCost();
}

// Implementação básica de café.
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Café simples";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Classe Decorator base.
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Adiciona leite ao café.
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Leite";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

// Adiciona açúcar ao café.
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Açúcar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}

// Main para testar o padrão Decorator.
public class CoffeeDecoratorExample {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " custa " + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " custa " + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " custa " + coffee.getCost());
    }
}


