package algafood.api.model;

import algafood.domain.model.Cozinha;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class RestauranteDTO {

    private Long id;
    private String nome;
    private BigDecimal frete;
    private CozinhaDTO cozinha;

}
