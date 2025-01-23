package aulas._5.ensino.desafioItau.controllers;

import aulas._5.ensino.desafioItau.models.Estatisticas;
import aulas._5.ensino.desafioItau.models.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class EstatisticaController {

    private static final Logger logger = LoggerFactory.getLogger(EstatisticaController.class);

    private final TransacaoController transacaoController;

    @Value("${estatisticas.limiteTempo:60}")
    private int limiteTempo;

    @Autowired
    public EstatisticaController(TransacaoController transacaoController) {
        this.transacaoController = Objects.requireNonNull(transacaoController, "transacaoController não pode ser nulo");
    }

    @GetMapping("/estatisticas")
    

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Upload de arquivo realizado com sucesso"),
        @ApiResponse(responseCode = "200", description = "Estatísticas retornadas com sucesso"),
        @ApiResponse(responseCode = "404", description = "Nenhuma transação encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })

    
    public Estatisticas getEstatisticas() {
        List<Transacao> transacoes = transacaoController.getTransacoes();

        OffsetDateTime limite = OffsetDateTime.now().minus(Duration.ofSeconds(limiteTempo));

        try {
            DoubleSummaryStatistics estatisticas = transacoes.stream()
                    .filter(t -> t.getDataHora().isAfter(limite))
                    .collect(Collectors.summarizingDouble(Transacao::getValor));

            return new Estatisticas(estatisticas.getCount(), estatisticas.getSum(),
                    estatisticas.getAverage(), estatisticas.getMin(), estatisticas.getMax());
        } catch (Exception e) {
            logger.error("Erro ao calcular estatísticas", e);
            // Retornar um objeto de erro ou lançar uma exceção customizada
            return null;
        }
    }
}