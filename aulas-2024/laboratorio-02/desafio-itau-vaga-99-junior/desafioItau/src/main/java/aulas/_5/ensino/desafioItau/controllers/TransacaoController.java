package aulas._5.ensino.desafioItau.controllers;

import aulas._5.ensino.desafioItau.models.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TransacaoController {

    private static final Logger logger = LoggerFactory.getLogger(TransacaoController.class);
    private List<Transacao> transacoes = new ArrayList<>();

    @PostMapping("/transacao")
    
    public ResponseEntity<Void> criarTransacao(@RequestBody Transacao transacao) {
        logger.info("Recebida requisição POST /transacao: {}", transacao);

        if (transacao.getValor() == null || transacao.getDataHora() == null ||
                transacao.getDataHora().isAfter(OffsetDateTime.now()) || transacao.getValor() < 0) {
            logger.warn("Transação inválida: {}", transacao);
            return ResponseEntity.unprocessableEntity().build();
        }

        transacoes.add(transacao);
        logger.info("Transação criada com sucesso: {}", transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> limparTransacoes() {
        logger.info("Recebida requisição DELETE /transacao");
        transacoes.clear();
        logger.info("Transações limpas com sucesso.");
        return ResponseEntity.ok().build();
    }

    public List<Transacao> getTransacoes() { // Novo método getTransacoes()
        return transacoes;
    }

}