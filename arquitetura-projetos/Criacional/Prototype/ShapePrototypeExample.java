//package Criacional.Prototype;

// Classe abstrata que define o protótipo.
abstract class Shape implements Cloneable {
    public String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract void draw();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// Classe concreta para círculos.
class Circle extends Shape {
    public int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Desenhando um círculo de cor " + color + " e raio " + radius);
    }
}

// Classe concreta para retângulos.
class Rectangle extends Shape {
    public int width, height;

    public Rectangle(String color, int width, int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Desenhando um retângulo de cor " + color + ", largura " + width + " e altura " + height);
    }
}

// Main para testar o padrão Prototype.
public class ShapePrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle = new Circle("Vermelho", 10);
        circle.draw();

        Circle clonedCircle = (Circle) circle.clone();
        clonedCircle.color = "Azul";
        clonedCircle.draw();

        Rectangle rectangle = new Rectangle("Verde", 5, 8);
        rectangle.draw();

        Rectangle clonedRectangle = (Rectangle) rectangle.clone();
        clonedRectangle.color = "Amarelo";
        clonedRectangle.draw();
    }
}

