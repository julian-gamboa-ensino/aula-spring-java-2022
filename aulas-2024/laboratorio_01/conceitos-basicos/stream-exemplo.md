# Streams em Java: Consumo Único

Este exemplo demonstra um comportamento fundamental de Streams em Java: **o consumo único**.

**Código:**

```java

import java.util.stream.Stream;
import java.util.*;



public class Test {
  public static void main(String[] args) {
    List<String> list = new LinkedList<>();
    list.add("A");
    list.add("B");
    Stream<String> s = list.stream();
    s.forEach(System.out::print);
    s.forEach(System.out::print);
  }
}