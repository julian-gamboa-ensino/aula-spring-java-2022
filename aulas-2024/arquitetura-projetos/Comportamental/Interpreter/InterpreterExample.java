// InterpreterExample.java
//package Estrutural.Interpreter;

import java.util.Map;

// Interface Expressao
interface Expressao {
    int interpretar(Map<String, Integer> contexto);
}

// Expressão terminal para variáveis
class Variavel implements Expressao {
    private String nome;

    public Variavel(String nome) {
        this.nome = nome;
    }

    @Override
    public int interpretar(Map<String, Integer> contexto) {
        return contexto.getOrDefault(nome, 0);
    }
}

// Expressão terminal para números inteiros
class Numero implements Expressao {
    private int numero;

    public Numero(int numero) {
        this.numero = numero;
    }

    @Override
    public int interpretar(Map<String, Integer> contexto) {
        return numero;
    }
}

// Expressão não-terminal para adição
class Soma implements Expressao {
    private Expressao esquerda;
    private Expressao direita;

    public Soma(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public int interpretar(Map<String, Integer> contexto) {
        return esquerda.interpretar(contexto) + direita.interpretar(contexto);
    }
}

// Expressão não-terminal para subtração
class Subtracao implements Expressao {
    private Expressao esquerda;
    private Expressao direita;

    public Subtracao(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public int interpretar(Map<String, Integer> contexto) {
        return esquerda.interpretar(contexto) - direita.interpretar(contexto);
    }
}

public class InterpreterExample {
    public static void main(String[] args) {
        // Contexto com valores das variáveis
        Map<String, Integer> contexto = Map.of("a", 5, "b", 2);

        // Expressão: a + (b - 3)
        Expressao expressao = new Soma(
            new Variavel("a"),
            new Subtracao(
                new Variavel("b"),
                new Numero(3)
            )
        );

        int resultado = expressao.interpretar(contexto);
        System.out.println("Resultado da expressão: " + resultado);
    }
}
