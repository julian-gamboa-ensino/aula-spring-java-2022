package aulas._5.ensino.desafioItau.models;

import java.time.OffsetDateTime;

public class Transacao {

    private Double valor;
    private OffsetDateTime dataHora;

    public Transacao() {} // Construtor vazio para JSON

    public Transacao(Double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}