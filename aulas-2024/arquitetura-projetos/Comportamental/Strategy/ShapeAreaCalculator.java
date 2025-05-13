//package .Strategy;

// Interface Strategy para cálculo de áreas.
interface AreaStrategy {
    double calculateArea();
}

// Implementação para cálculo da área de um círculo.
class CircleArea implements AreaStrategy {
    private double radius;

    public CircleArea(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Implementação para cálculo da área de um quadrado.
class SquareArea implements AreaStrategy {
    private double side;

    public SquareArea(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

// Implementação para cálculo da área de um triângulo.
class TriangleArea implements AreaStrategy {
    private double base, height;

    public TriangleArea(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }
}

// Main para testar o padrão Strategy.
public class ShapeAreaCalculator {
    public static void main(String[] args) {
        AreaStrategy circle = new CircleArea(5);
        AreaStrategy square = new SquareArea(4);
        AreaStrategy triangle = new TriangleArea(6, 3);

        System.out.println("Área do círculo: " + circle.calculateArea());
        System.out.println("Área do quadrado: " + square.calculateArea());
        System.out.println("Área do triângulo: " + triangle.calculateArea());
    }
}
