package laboratorio._1.jpa.controllers.h2Controllers;

import org.springframework.web.bind.annotation.*;

import laboratorio._1.jpa.models.Ofertas.Oferta;
import laboratorio._1.jpa.models.Ofertas.OfertaRepository;

import java.util.List;

@RestController
@RequestMapping("/h2OfertaController")
public class h2OfertaController {

    private final OfertaRepository ofertaRepository;

    public h2OfertaController(OfertaRepository ofertaRepository) {
        this.ofertaRepository = ofertaRepository;
    }

    @GetMapping
    public List<Oferta> listarOfertas() {
        return ofertaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Oferta buscarOfertaPorId(@PathVariable String id) {
        return ofertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Oferta não encontrada"));
    }

    @PostMapping
    public Oferta criarOferta(@RequestBody Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    @PutMapping("/{id}")
    public Oferta atualizarOferta(@PathVariable String id, @RequestBody Oferta oferta) {
        //oferta.setId(id);
        return ofertaRepository.save(oferta);
    }

    @DeleteMapping("/{id}")
    public void deletarOferta(@PathVariable String id) {
        ofertaRepository.deleteById(id);
    }
}
