package algafood.controller;

import algafood.domain.model.Estado;
import algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.listar();
    }

    @GetMapping("/{estadoId}")
    public Estado buscar(@PathVariable Long estadoId){
        return estadoRepository.buscar(estadoId);
    }

    @PostMapping
    public Estado salvarEstado(Estado estado){
        return estadoRepository.salvar(estado);
    }
}
