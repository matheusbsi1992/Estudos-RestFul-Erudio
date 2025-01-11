package br.com.projeto.erudio.mapper.custom;

import br.com.projeto.erudio.model.Pessoa;
import br.com.projeto.erudio.vo.v2.PessoaVO2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PessoaCustom {

    /*ESTERIOTIPO PESSOA V02--->PESSOA*/
    public PessoaVO2 esteriotypeForCustom(Pessoa pessoa) {
        PessoaVO2 pessoaVO2 = new PessoaVO2();

        pessoaVO2.setIdPessoa(pessoa.getIdPessoa());
        pessoaVO2.setNomePessoa(pessoa.getNomePessoa());
        pessoaVO2.setSobreNomePessoa(pessoa.getSobreNomePessoa());
        pessoaVO2.setEnderecoPessoa(pessoa.getEnderecoPessoa());
        pessoaVO2.setSexoPessoa(pessoa.getSexoPessoa());
        pessoaVO2.setDataAniversarioPessoa(new Date());

        return pessoaVO2;
    }

    /*ESTERIOTIPO PESSOA--->PESSOA V02*/
    public Pessoa customTypeForEsteriotype(PessoaVO2 pessoav02) {
        Pessoa pessoa = new Pessoa();

        pessoa.setIdPessoa(pessoav02.getIdPessoa());
        pessoa.setNomePessoa(pessoav02.getNomePessoa());
        pessoa.setSobreNomePessoa(pessoav02.getSobreNomePessoa());
        pessoa.setEnderecoPessoa(pessoav02.getEnderecoPessoa());
        pessoa.setSexoPessoa(pessoav02.getSexoPessoa());

        return pessoa;
    }
}
