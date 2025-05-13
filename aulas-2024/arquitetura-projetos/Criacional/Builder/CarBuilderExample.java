//package Criacional.Builder;

// Classe Car representando o produto final.
class Car {
    private String engine;
    private int wheels;
    private String color;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Carro com motor: " + engine + ", rodas: " + wheels + ", cor: " + color;
    }
}

// Interface do Builder.
interface CarBuilder {
    void buildEngine();
    void buildWheels();
    void paint();
    Car getCar();
}

// Implementação concreta do Builder para criar carros esportivos.
class SportsCarBuilder implements CarBuilder {
    private Car car;

    public SportsCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("Motor V8");
    }

    @Override
    public void buildWheels() {
        car.setWheels(4);
    }

    @Override
    public void paint() {
        car.setColor("Vermelho");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

// Diretor que gerencia o processo de construção.
class CarDirector {
    private CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constructCar() {
        builder.buildEngine();
        builder.buildWheels();
        builder.paint();
        return builder.getCar();
    }
}

// Main para testar o padrão Builder.
public class CarBuilderExample {
    public static void main(String[] args) {
        CarBuilder builder = new SportsCarBuilder();
        CarDirector director = new CarDirector(builder);

        Car car = director.constructCar();
        System.out.println(car);
    }
}
