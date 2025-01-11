package br.com.projeto.erudio.mocks;

import br.com.projeto.erudio.model.Pessoa;
import br.com.projeto.erudio.repository.PessoaRepository;
import br.com.projeto.erudio.services.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class MockitoTestServicePessoa {

    MockPessoa mockPessoa;

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    PessoaRepository pessoaRepository;

    @BeforeEach
    public void inicializarMock() {
        mockPessoa = new MockPessoa();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void inserirPessoaTest() {
        fail("Not yet implemented");
    }

    @Test
    public void atualizarPessoaTest() {
        fail("Not yet implemented");
    }

    @Test
    public void buscarPessoaTest() {
        Pessoa pessoa = mockPessoa.mockEntity(0);
        pessoa.setIdPessoa(1L);

        when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));

        var resultado = pessoaService.findById(1L);

        assertNotNull(resultado);
        assertNotNull(resultado.getIdPessoa());
        assertNotNull(resultado.getLinks());
        System.out.println(resultado.toString());
        assertTrue(resultado.toString().contains(""));
        assertEquals("First Name Test0", resultado.getNomePessoa());
    }

    @Test
    public void listarPessoaTest() {
        fail("Not yet implemented");
    }

}