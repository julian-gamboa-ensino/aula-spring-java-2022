// BridgeExample.java
//package Estrutural.Bridge;

// Implementador
interface Cor {
    String aplicarCor();
}

// Implementação concreta de Cor
class Vermelho implements Cor {
    @Override
    public String aplicarCor() {
        return "vermelho";
    }
}

class Azul implements Cor {
    @Override
    public String aplicarCor() {
        return "azul";
    }
}

// Abstração
abstract class Forma {
    protected Cor cor;

    public Forma(Cor cor) {
        this.cor = cor;
    }

    abstract void desenhar();
}

// Refinamento da Abstração
class Circulo extends Forma {
    public Circulo(Cor cor) {
        super(cor);
    }

    @Override
    void desenhar() {
        System.out.println("Desenhando círculo de cor " + cor.aplicarCor());
    }
}

class Quadrado extends Forma {
    public Quadrado(Cor cor) {
        super(cor);
    }

    @Override
    void desenhar() {
        System.out.println("Desenhando quadrado de cor " + cor.aplicarCor());
    }
}

public class BridgeExample {
    public static void main(String[] args) {
        Forma circuloVermelho = new Circulo(new Vermelho());
        Forma quadradoAzul = new Quadrado(new Azul());

        circuloVermelho.desenhar();
        quadradoAzul.desenhar();
    }
}
