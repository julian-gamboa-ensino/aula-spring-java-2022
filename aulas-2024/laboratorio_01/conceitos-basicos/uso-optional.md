# Prática: Explorando Optional e Streams em Java

**Objetivo:** 

* Compreender o uso da classe `Optional` para lidar com valores nulos de forma segura.
* Aplicar o conceito de Streams para processar coleções de dados de forma eficiente.
* Entender a importância da ordenação em streams.

**Descrição:**

Nesta prática, vamos analisar um código Java que demonstra o uso da classe `Optional` em conjunto com Streams. O código cria uma lista de números, a ordena utilizando Streams e, em seguida, utiliza o método `findFirst()` para obter o primeiro elemento da lista ordenada. A classe `Optional` garante que o código não lance uma exceção caso a lista esteja vazia, proporcionando maior segurança.

**Código:**

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Test {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(5.4);
        list.add(1.2);

        Optional<Double> opt = list.stream().sorted().findFirst();

        System.out.print(opt.get() + " --- " + list.get(0)); 
    }
}


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TutorialStreams {

    public static void main(String[] args) {

        // Criando Streams a partir de diferentes fontes

        // 1. Listas
        List<Integer> numerosLista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> streamLista = numerosLista.stream();

        System.out.println("Stream a partir de uma lista:");
        streamLista.forEach(System.out::println);

        // 2. Arrays
        int[] numerosArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream<Integer> streamArray = Arrays.stream(numerosArray).boxed(); // Corrigido

        System.out.println("\nStream a partir de um array:");
        streamArray.forEach(System.out::println);

        // 3. Strings
        String texto = "abc";
        Stream<Character> streamString = texto.chars().mapToObj(c -> (char) c);

        System.out.println("\nStream a partir de uma string:");
        streamString.forEach(System.out::println);

        // 4. Valores
        Stream<Integer> streamValores = Stream.of(1, 2, 3);

        System.out.println("\nStream a partir de valores:");
        streamValores.forEach(System.out::println);

        // 5. Geradores
        Stream<Integer> streamGerador = Stream.iterate(0, n -> n + 2).limit(10);

        System.out.println("\nStream a partir de um gerador:");
        streamGerador.forEach(System.out::println);


        // --------------------------------------------------------------------
        // Métodos Intermediários
        // --------------------------------------------------------------------

        // 1. filter (filtra elementos)
        System.out.println("\nNúmeros pares da lista:");
        numerosLista.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // 2. map (transforma elementos)
        System.out.println("\nQuadrado dos números do array:");
        Arrays.stream(numerosArray)
                .boxed() // Corrigido
                .map(n -> n * n)
                .forEach(System.out::println);

        // 3. sorted (ordena elementos)
        System.out.println("\nNúmeros da lista em ordem decrescente:");
        numerosLista.stream()
                .sorted((a, b) -> b - a)
                .forEach(System.out::println);

        // 4. distinct (remove duplicatas)
        List<Integer> numerosComDuplicatas = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        System.out.println("\nNúmeros sem duplicatas:");
        numerosComDuplicatas.stream()
                .distinct()
                .forEach(System.out::println);

        // 5. limit (limita o número de elementos)
        System.out.println("\nPrimeiros 5 números do array:");
        Arrays.stream(numerosArray)
                .boxed() // Corrigido
                .limit(5)
                .forEach(System.out::println);

        // 6. skip (ignora os primeiros elementos)
        System.out.println("\nNúmeros do array ignorando os 3 primeiros:");
        Arrays.stream(numerosArray)
                .boxed() // Corrigido
                .skip(3)
                .forEach(System.out::println);


        // --------------------------------------------------------------------
        // Métodos Terminais
        // --------------------------------------------------------------------

        // 1. count (conta elementos)
        long contagemPares = numerosLista.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("\nQuantidade de números pares na lista: " + contagemPares);

        // 2. findFirst (encontra o primeiro elemento)
        Integer primeiroPar = numerosLista.stream()
                .filter(n -> n % 2 == 0)
                .findFirst()
                .orElse(null);
        System.out.println("\nPrimeiro número par da lista: " + primeiroPar);

        // 3. anyMatch, allMatch, noneMatch (verifica condições)
        boolean todosPositivos = numerosLista.stream()
                .allMatch(n -> n > 0);
        System.out.println("\nTodos os números da lista são positivos? " + todosPositivos);

        // 4. collect (coleta elementos)
        List<Integer> quadrados = Arrays.stream(numerosArray)
                .boxed() // Corrigido
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("\nQuadrados dos números do array em uma nova lista: " + quadrados);

        // 5. reduce (combina elementos)
        int soma = numerosLista.stream()
                .reduce(0, Integer::sum);
        System.out.println("\nSoma dos números da lista: " + soma);
    }
}