package br.com.projeto.erudio.mocks;


import br.com.projeto.erudio.model.Pessoa;
import br.com.projeto.erudio.vo.v1.PessoaVO;

import java.util.ArrayList;
import java.util.List;

public class MockPessoa {


    public Pessoa mockEntity() {
        return mockEntity(0);
    }

    public PessoaVO mockVO() {
        return mockVO(0);
    }

    public List<Pessoa> mockEntityList() {
        List<Pessoa> Pessoas = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            Pessoas.add(mockEntity(i));
        }
        return Pessoas;
    }

    public List<PessoaVO> mockVOList() {
        List<PessoaVO> Pessoas = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Pessoas.add(mockVO(i));
        }
        return Pessoas;
    }

    public Pessoa mockEntity(Integer number) {
        Pessoa Pessoa = new Pessoa();
        Pessoa.setEnderecoPessoa("Addres Test" + number);
        Pessoa.setNomePessoa("First Name Test" + number);
        Pessoa.setSexoPessoa(((number % 2) == 0) ? "Male" : "Female");
        Pessoa.setIdPessoa(number.longValue());
        Pessoa.setSobreNomePessoa("Last Name Test" + number);
        return Pessoa;
    }

    public PessoaVO mockVO(Integer number) {
        PessoaVO Pessoa = new PessoaVO();
        Pessoa.setEnderecoPessoa("Addres Test" + number);
        Pessoa.setNomePessoa("First Name Test" + number);
        Pessoa.setSexoPessoa(((number % 2) == 0) ? "Male" : "Female");
        Pessoa.setIdPessoa(number.longValue());
        Pessoa.setSobreNomePessoa("Last Name Test" + number);
        return Pessoa;
    }

}
