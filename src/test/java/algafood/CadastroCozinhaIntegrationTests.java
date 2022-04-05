package algafood;

import algafood.domain.exception.EntidadeEmUsoException;
import algafood.domain.exception.EntidadeNaoEncontradaException;
import algafood.domain.model.Cozinha;
import algafood.domain.repository.CozinhaRepository;
import algafood.domain.service.CadastroCozinhaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CadastroCozinhaIntegrationTests {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired(required = true)
    private CadastroCozinhaService cadastroCozinhaService;

    @Test
    public void devePassar_QuandoCadastrarCozinhaComDadosCorretos() {
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome("Chinesa");

        Cozinha cozinhaSalva = cadastroCozinhaService.salvar(novaCozinha);

        Assertions.assertThat(cozinhaSalva).isNotNull();
        Assertions.assertThat(cozinhaSalva.getId()).isNotNull();
    }

    @Test
    public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome(null);

        ConstraintViolationException erro = assertThrows(ConstraintViolationException.class, () -> {
            cadastroCozinhaService.salvar(novaCozinha);
        });

        Assertions.assertThat(erro).isNotNull();
    }

    @Test
    public void deveFalhar_QuandoExcluirCozinhaEmUso() {

        EntidadeEmUsoException erro = assertThrows(EntidadeEmUsoException.class, () -> {
            cadastroCozinhaService.excluir(1L);
        });

    }


    @Test
    public void deveFalhar_QuandoExcluirCozinhaInexistente() {
        EntidadeNaoEncontradaException erro = assertThrows(EntidadeNaoEncontradaException.class, () -> {
            cadastroCozinhaService.excluir(100L);
        });
    }

    @Test
    public void devePassar_QuandoExcluiCozinhaExistenteSemUso() {
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome("Alagoana");
        cadastroCozinhaService.salvar(novaCozinha);

        cadastroCozinhaService.excluir(5L);
    }
}
