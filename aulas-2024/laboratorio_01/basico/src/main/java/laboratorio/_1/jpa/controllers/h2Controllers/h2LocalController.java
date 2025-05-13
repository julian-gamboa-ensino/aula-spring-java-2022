package laboratorio._1.jpa.controllers.h2Controllers;

import org.springframework.web.bind.annotation.*;

import laboratorio._1.jpa.models.Local.Local;
import laboratorio._1.jpa.models.Local.LocalRepository;

import java.util.List;

@RestController
@RequestMapping("/h2LocalController")
public class h2LocalController {

    private final LocalRepository localRepository;

    public h2LocalController(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @GetMapping
    public List<Local> listarLocais() {
        return localRepository.findAll();
    }

    @GetMapping("/{id}")
    public Local buscarLocalPorId(@PathVariable String id) {
        Local local = localRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Local não encontrado"));

        
        //System.out.println("Objeto retornado do banco: " + local.getLocalGps());

return local;
    }

    @PostMapping
    public Local criarLocal(@RequestBody Local local) {
        return localRepository.save(local);
    }

    @PutMapping("/{id}")
    public Local atualizarLocal(@PathVariable String id, @RequestBody Local local) {
        //local.setId(id);
        return localRepository.save(local);
    }

    @DeleteMapping("/{id}")
    public void deletarLocal(@PathVariable String id) {
        localRepository.deleteById(id);
    }
}