package aulas._5.ensino.desafioItau;

import aulas._5.ensino.desafioItau.controllers.EstatisticaController;
import aulas._5.ensino.desafioItau.controllers.TransacaoController;
import aulas._5.ensino.desafioItau.models.Estatisticas;
import aulas._5.ensino.desafioItau.models.Transacao;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstatisticaControllerTest {

    @Test
    public void getEstatisticas_retornaEstatisticasCorretas() {
        TransacaoController transacaoController = new TransacaoController();
        transacaoController.criarTransacao(new Transacao(100.0, OffsetDateTime.now()));
        transacaoController.criarTransacao(new Transacao(200.0, OffsetDateTime.now()));
        transacaoController.criarTransacao(new Transacao(300.0, OffsetDateTime.now()));

        EstatisticaController controller = new EstatisticaController(transacaoController);

        Estatisticas estatisticas = controller.getEstatisticas();

        assertEquals(3, estatisticas.getCount());
        assertEquals(600.0, estatisticas.getSum());
        assertEquals(200.0, estatisticas.getAvg());
        assertEquals(100.0, estatisticas.getMin());
        assertEquals(300.0, estatisticas.getMax());
    }

    @Test
    public void getEstatisticas_semTransacoes_retornaEstatisticasZeradas() {
        TransacaoController transacaoController = new TransacaoController();
        // Transações fora do limite de 60 segundos
        transacaoController.criarTransacao(new Transacao(100.0, OffsetDateTime.now().minusMinutes(2)));

        EstatisticaController controller = new EstatisticaController(transacaoController);

        Estatisticas estatisticas = controller.getEstatisticas();

        assertEquals(0, estatisticas.getCount());
        assertEquals(0.0, estatisticas.getSum());
        assertEquals(0.0, estatisticas.getAvg());
        assertEquals(0.0, estatisticas.getMin());
        assertEquals(0.0, estatisticas.getMax());
    }
}