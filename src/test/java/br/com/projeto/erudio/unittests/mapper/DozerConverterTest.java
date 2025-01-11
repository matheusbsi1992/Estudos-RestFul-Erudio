package br.com.projeto.erudio.unittests.mapper;

import br.com.projeto.erudio.mapper.DozerMapper;
import br.com.projeto.erudio.mocks.MockPessoa;
import br.com.projeto.erudio.model.Pessoa;
import br.com.projeto.erudio.vo.v1.PessoaVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DozerConverterTest {

    MockPessoa inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPessoa();
    }

    @Test
    public void parseEntityToVOTest() {
        PessoaVO output = DozerMapper.parseObject(inputObject.mockEntity(), PessoaVO.class);
        assertEquals(Long.valueOf(0L), output.getIdPessoa());
        assertEquals("First Name Test0", output.getNomePessoa());
        assertEquals("Last Name Test0", output.getSobreNomePessoa());
        assertEquals("Addres Test0", output.getEnderecoPessoa());
        assertEquals("Male", output.getSexoPessoa());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PessoaVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), PessoaVO.class);
        PessoaVO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getIdPessoa());
        assertEquals("First Name Test0", outputZero.getNomePessoa());
        assertEquals("Last Name Test0", outputZero.getSobreNomePessoa());
        assertEquals("Addres Test0", outputZero.getEnderecoPessoa());
        assertEquals("Male", outputZero.getSexoPessoa());

        PessoaVO outputSeven = outputList.get(4);

        assertEquals(Long.valueOf(4L), outputSeven.getIdPessoa());
        assertEquals("First Name Test4", outputSeven.getNomePessoa());
        assertEquals("Last Name Test4", outputSeven.getSobreNomePessoa());
        assertEquals("Addres Test4", outputSeven.getEnderecoPessoa());
        assertEquals("Female", outputSeven.getSexoPessoa());

        PessoaVO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getIdPessoa());
        assertEquals("First Name Test12", outputTwelve.getNomePessoa());
        assertEquals("Last Name Test12", outputTwelve.getSobreNomePessoa());
        assertEquals("Addres Test12", outputTwelve.getEnderecoPessoa());
        assertEquals("Male", outputTwelve.getSexoPessoa());
    }

    @Test
    public void parseVOToEntityTest() {
        Pessoa output = DozerMapper.parseObject(inputObject.mockVO(), Pessoa.class);
        assertEquals(Long.valueOf(0L), output.getIdPessoa());
        assertEquals("First Name Test0", output.getNomePessoa());
        assertEquals("Last Name Test0", output.getSobreNomePessoa());
        assertEquals("Addres Test0", output.getEnderecoPessoa());
        assertEquals("Male", output.getSexoPessoa());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Pessoa> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Pessoa.class);
        Pessoa outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getIdPessoa());
        assertEquals("First Name Test0", outputZero.getNomePessoa());
        assertEquals("Last Name Test0", outputZero.getSobreNomePessoa());
        assertEquals("Addres Test0", outputZero.getEnderecoPessoa());
        assertEquals("Male", outputZero.getSexoPessoa());

        Pessoa outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getIdPessoa());
        assertEquals("First Name Test7", outputSeven.getNomePessoa());
        assertEquals("Last Name Test7", outputSeven.getSobreNomePessoa());
        assertEquals("Addres Test7", outputSeven.getEnderecoPessoa());
        assertEquals("Female", outputSeven.getSexoPessoa());

        Pessoa outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getIdPessoa());
        assertEquals("First Name Test12", outputTwelve.getNomePessoa());
        assertEquals("Last Name Test12", outputTwelve.getSobreNomePessoa());
        assertEquals("Addres Test12", outputTwelve.getEnderecoPessoa());
        assertEquals("Male", outputTwelve.getSexoPessoa());
    }
}
