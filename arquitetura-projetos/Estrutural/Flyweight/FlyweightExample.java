// FlyweightExample.java
//package Estrutural.Flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight
interface Forma {
    void desenhar();
}

// Implementação concreta de Flyweight
class Circulo implements Forma {
    private String cor;
    private int x;
    private int y;
    private int raio;

    public Circulo(String cor) {
        this.cor = cor;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando círculo [Cor: " + cor + ", x: " + x + ", y: " + y + ", raio: " + raio + "]");
    }
}

// Flyweight Factory
class FormaFactory {
    private static final Map<String, Forma> circuloMap = new HashMap<>();

    public static Forma getCirculo(String cor) {
        Circulo circulo = (Circulo) circuloMap.get(cor);

        if (circulo == null) {
            circulo = new Circulo(cor);
            circuloMap.put(cor, circulo);
            System.out.println("Criando círculo de cor: " + cor);
        }
        return circulo;
    }
}

public class FlyweightExample {
    private static final String[] cores = {"Vermelho", "Verde", "Azul", "Branco", "Preto"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circulo circulo = (Circulo) FormaFactory.getCirculo(getCorAleatoria());
            circulo.setX(getNumeroAleatorio());
            circulo.setY(getNumeroAleatorio());
            circulo.setRaio(100);
            circulo.desenhar();
        }
    }

    private static String getCorAleatoria() {
        return cores[(int) (Math.random() * cores.length)];
    }

    private static int getNumeroAleatorio() {
        return (int) (Math.random() * 100);
    }
}
