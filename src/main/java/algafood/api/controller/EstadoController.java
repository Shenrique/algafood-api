package algafood.api.controller;

import algafood.domain.exception.EntidadeEmUsoException;
import algafood.domain.exception.EntidadeNaoEncontradaException;
import algafood.domain.model.Cozinha;
import algafood.domain.model.Estado;
import algafood.domain.repository.EstadoRepository;
import algafood.domain.service.CadastroEstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstadoService;

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public Estado buscar(@PathVariable Long estadoId) {
       return cadastroEstadoService.buscarOuFalhar(estadoId);
    }

    @PostMapping
    public ResponseEntity<Estado> salvarEstado(@RequestBody Estado estado) {
        Estado EstadoSalvo = cadastroEstadoService.salvar(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(EstadoSalvo);
    }

    @PutMapping("/{estadoId}")
    public Estado atualizarEstado(@PathVariable Long estadoId, @RequestBody Estado estado) {
            Estado retornoEstado = cadastroEstadoService.buscarOuFalhar(estadoId);

            BeanUtils.copyProperties(estado, retornoEstado, "id");

            return cadastroEstadoService.salvar(retornoEstado);
    }

    @DeleteMapping("/{estadoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEstado(@PathVariable Long estadoId) {
            cadastroEstadoService.excluir(estadoId);
    }

}
