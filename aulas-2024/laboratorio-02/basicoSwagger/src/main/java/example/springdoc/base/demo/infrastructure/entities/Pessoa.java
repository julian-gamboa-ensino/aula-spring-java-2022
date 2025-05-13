package example.springdoc.base.demo.infrastructure.entities;

import java.math.BigDecimal;

public record Pessoa(String nome, Integer idade, BigDecimal salario, Profissao profissao) {
}
