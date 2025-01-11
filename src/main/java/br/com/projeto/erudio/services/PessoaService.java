package br.com.projeto.erudio.services;

import br.com.projeto.erudio.controller.PersonController;
import br.com.projeto.erudio.exceptions.ResourceNotFoundException;
import br.com.projeto.erudio.mapper.DozerMapper;
import br.com.projeto.erudio.mapper.custom.PessoaCustom;
import br.com.projeto.erudio.model.Pessoa;
import br.com.projeto.erudio.repository.PessoaRepository;
import br.com.projeto.erudio.vo.v1.PessoaVO;
import br.com.projeto.erudio.vo.v2.PessoaVO2;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//@Component
@Service
public class PessoaService {

    private Logger logger = Logger.getLogger(PessoaService.class.getName());


    //@Qualifier("pessoaRepository")
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaCustom pessoaCustom;

    @Autowired
    PagedResourcesAssembler pagedResourcesAssembler;

    public PessoaVO inserirPessoa(PessoaVO pessoa) {
        logger.info("Create by person...");

        var entity = DozerMapper.parseObject(pessoa, Pessoa.class);

        var pessoaVO = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaVO.class);

        return pessoaVO.add(linkTo(methodOn(PersonController.class).retornarIdPessoa(pessoaVO.getIdPessoa())).withSelfRel());
    }

    //----Atualizacao de uma nova insercao de atributo aniversario
    public PessoaVO2 inserirPessoaV02(PessoaVO2 pessoav02) {
        logger.info("Create by personV02...");

        var entity = pessoaCustom.customTypeForEsteriotype(pessoav02);

        var vo = pessoaCustom.esteriotypeForCustom(pessoaRepository.save(entity));

        return vo;
    }

    public PessoaVO atualizarPessoa(PessoaVO pessoa) {
        logger.info("Update by person...");

        var pessoaAlterada = pessoaRepository.findById(pessoa.getIdPessoa())
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para alteração através do ID !!!"));

        pessoaAlterada.setNomePessoa(pessoa.getNomePessoa());
        pessoaAlterada.setSobreNomePessoa(pessoa.getSobreNomePessoa());
        pessoaAlterada.setSexoPessoa(pessoa.getSexoPessoa());
        pessoaAlterada.setEnderecoPessoa(pessoa.getEnderecoPessoa());

        var pessoaVO = DozerMapper.parseObject(pessoaRepository.save(pessoaAlterada), PessoaVO.class);

        return pessoaVO.add(linkTo(methodOn(PersonController.class).retornarIdPessoa(pessoaAlterada.getIdPessoa())).withSelfRel());
    }

    public void deletarPessoa(Long idPessoa) {
        logger.info("Delete by person...");

        var pessoaIdentificada = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para a deleção através do ID !!!"));

        pessoaRepository.delete(pessoaIdentificada);
    }

    public PessoaVO findById(Long id) {
        logger.info("Finding by person...");

        /*pessoa = new Pessoa(pessoa.getIdPessoa(),pessoa.getNomePessoa(),pessoa.getSobreNomePessoa(),pessoa.getEnderecoPessoa(), pessoa.getSexoPessoa());
        pessoaList.add(pessoa);*/
        var entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada através do ID !!!"));

        var pessoaVO = DozerMapper.parseObject(entity, PessoaVO.class);

        return pessoaVO.add(linkTo(methodOn(PersonController.class).retornarIdPessoa(id)).withSelfRel());
    }

    @Transactional
    public PessoaVO desativarPessoa(Long id) {
        logger.info("Finding by person for deactivation...");

        /*pessoa = new Pessoa(pessoa.getIdPessoa(),pessoa.getNomePessoa(),pessoa.getSobreNomePessoa(),pessoa.getEnderecoPessoa(), pessoa.getSexoPessoa());
        pessoaList.add(pessoa);*/
        var entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada através do ID !!!"));

        var pessoa = DozerMapper.parseObject(entity, Pessoa.class);

        pessoaRepository.desativarPessoa(pessoa.getIdPessoa());

        var pessoaDesabilitar = DozerMapper.parseObject(pessoa, PessoaVO.class);

        return pessoaDesabilitar.add(linkTo(methodOn(PersonController.class).retornarIdPessoa(id)).withSelfRel());
    }

    public PagedModel<EntityModel<PessoaVO>> buscarPorNomeDaPessoa(String nomePessoa, Pageable pageable) {
        logger.info("Finding by findPersonByName...");
        //listarPessoas.forEach(System.out::println);

        var personPage = pessoaRepository.retornarPessoaPorNome(nomePessoa, pageable);

        var personVoPage = personPage.map(p -> DozerMapper.parseObject(p, PessoaVO.class));

        personVoPage.map(p -> p.add(linkTo(methodOn(PersonController.class).retornarIdPessoa(p.getIdPessoa())).withSelfRel()));

        Link link = linkTo(methodOn(PersonController.class).retornarTodasPessoa(pageable.getPageNumber(), pageable.getPageSize(), "ASC")).withSelfRel();

        return pagedResourcesAssembler.toModel(personVoPage, link);
    }

    public PagedModel<EntityModel<PessoaVO>> findAll(Pageable pageable) {
        logger.info("Finding by all...");
        //listarPessoas.forEach(System.out::println);

        var personPage = pessoaRepository.findAll(pageable);

        var personVoPage = personPage.map(p -> DozerMapper.parseObject(p, PessoaVO.class));

        personVoPage.map(p -> p.add(linkTo(methodOn(PersonController.class).retornarIdPessoa(p.getIdPessoa())).withSelfRel()));

        Link link = linkTo(methodOn(PersonController.class).retornarTodasPessoa(pageable.getPageNumber(), pageable.getPageSize(), "ASC")).withSelfRel();

        return pagedResourcesAssembler.toModel(personVoPage, link);
    }

/*
    private Pessoa mockList(int i) {
        Pessoa pessoa = new Pessoa();

        pessoa.setIdPessoa(counter.incrementAndGet());
        pessoa.setNomePessoa("Nome Pessoa " + i);
        pessoa.setSobreNomePessoa("Sobrenome " + i);
        pessoa.setSexoPessoa("Sexo");
        pessoa.setEnderecoPessoa("Endereco" + i);
        return pessoa;
    }*/

}