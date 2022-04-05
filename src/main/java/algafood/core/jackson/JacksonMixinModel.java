package algafood.core.jackson;

import algafood.api.model.mixin.CidadeMixin;
import algafood.api.model.mixin.CozinhaMixin;
import algafood.domain.model.Cidade;
import algafood.domain.model.Cozinha;
import algafood.domain.model.Restaurante;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModel extends SimpleModule {

    public JacksonMixinModel(){
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }

}
