package algafood;


import algafood.domain.model.Estado;
import algafood.domain.service.CadastroEstadoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CadastroEstadoIntegrationTests {

    @Autowired
    private Estado estado;

    @Autowired
    private CadastroEstadoService cadastroEstadoService;

    @Test
    public void deveAtribuirId_QuandoCadastrarEstadoComDadosCorretos() {
        Estado estadoTest = new Estado();
        estadoTest.setNome("Alagoas");

        Estado estadoSalvo = cadastroEstadoService.salvar(estadoTest);

        //Verifique que =  assertThat
        Assertions.assertThat(estadoSalvo).isNotNull();
        Assertions.assertThat(estadoSalvo.getId()).isNotNull();
    }
}
