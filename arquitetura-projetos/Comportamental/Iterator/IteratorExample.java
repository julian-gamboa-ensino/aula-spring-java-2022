// IteratorExample.java
//package Estrutural.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Coleção que implementa Iterable
class NomeColecao implements Iterable<String> {
    private List<String> nomes = new ArrayList<>();

    public void adicionarNome(String nome) {
        nomes.add(nome);
    }

    @Override
    public Iterator<String> iterator() {
        return nomes.iterator();
    }
}

public class IteratorExample {
    public static void main(String[] args) {
        NomeColecao colecao = new NomeColecao();
        colecao.adicionarNome("Alice");
        colecao.adicionarNome("Bob");
        colecao.adicionarNome("Charlie");

        // Usando o iterator para percorrer a coleção
        for (String nome : colecao) {
            System.out.println(nome);
        }
    }
}
