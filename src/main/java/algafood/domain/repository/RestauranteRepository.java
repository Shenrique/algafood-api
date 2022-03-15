package algafood.domain.repository;

import algafood.domain.model.Cidade;
import algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Long restauranteId);
}
