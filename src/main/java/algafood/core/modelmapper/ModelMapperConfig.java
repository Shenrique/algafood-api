package algafood.core.modelmapper;

import algafood.api.model.RestauranteDTO;
import algafood.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
     var modelMapper = new ModelMapper();

     modelMapper.createTypeMap(Restaurante.class, RestauranteDTO.class)
             .addMapping(Restaurante::getTaxaFrete, RestauranteDTO::setFrete);
     return modelMapper;
    }

}
