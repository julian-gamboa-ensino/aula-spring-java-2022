package laboratorio._1.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfertasController {

    @PostMapping("/ofertas")
    public ResponseEntity<String> salvarOferta(@RequestBody String dadosFormulario) {
        try {
            // 1. Obter os dados do formulário (dadosFormulario)
            // 2. Fazer a requisição para um sistema externo ou salvar em um banco de dados
            return ResponseEntity.ok("Oferta salva com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao salvar oferta");
        }
    }
}
