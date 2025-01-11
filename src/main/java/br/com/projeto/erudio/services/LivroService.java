package br.com.projeto.erudio.services;

import br.com.projeto.erudio.controller.LivroController;
import br.com.projeto.erudio.exceptions.ResourceNotFoundException;
import br.com.projeto.erudio.mapper.DozerMapper;
import br.com.projeto.erudio.model.Livro;
import br.com.projeto.erudio.repository.LivroRepository;
import br.com.projeto.erudio.vo.v1.LivroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class LivroService {

    private Logger logger = Logger.getLogger(LivroService.class.getName());

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    PagedResourcesAssembler pagedResourcesAssembler;

    public LivroVO inserirLivro(LivroVO livroVO) {
        logger.info("Created book...");

        var livro = DozerMapper.parseObject(livroVO, Livro.class);

        livro.setDataLivro(LocalDateTime.now());

        var entidadeNova = DozerMapper.parseObject(livroRepository.save(livro), LivroVO.class);

        return livroVO.add(linkTo(methodOn(LivroController.class).retornarLivro(entidadeNova.getIdLivro())).withSelfRel());
    }

    public LivroVO atualizarLivro(LivroVO livro) {
        logger.info("Update by book...");

        var livroAlterada = livroRepository.findById(livro.getIdLivro())
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado para alteração através do ID !!!"));

        livroAlterada.setAutorLivro(livro.getAutorLivro());
        livroAlterada.setTituloLivro(livro.getTituloLivro());
        livroAlterada.setPrecoLivro(livro.getPrecoLivro());
        livro.setDataLivro(LocalDateTime.now());
        livroAlterada.setDataLivro(livro.getDataLivro());

        var novaEntidade = DozerMapper.parseObject(livroRepository.save(livroAlterada), LivroVO.class);

        return livro.add(linkTo(methodOn(LivroController.class).retornarLivro(novaEntidade.getIdLivro())).withSelfRel());
    }

    public void deletarLivro(Long idLivro) {
        logger.info("Delete by livro...");

        var livroIdentificada = livroRepository.findById(idLivro)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado para a deleção através do ID !!!"));

        livroRepository.delete(livroIdentificada);
    }

    public LivroVO findById(Long idLivro) {
        logger.info("Finding by livro...");

        /*pessoa = new Pessoa(pessoa.getIdPessoa(),pessoa.getNomePessoa(),pessoa.getSobreNomePessoa(),pessoa.getEnderecoPessoa(), pessoa.getSexoPessoa());
        pessoaList.add(pessoa);*/
        var entityLivro = livroRepository.findById(idLivro)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado através do ID !!!"));

        var entidadeNova = DozerMapper.parseObject(entityLivro, LivroVO.class);

        return entidadeNova.add(linkTo(methodOn(LivroController.class).retornarLivro(idLivro)).withSelfRel());
    }

    public PagedModel<EntityModel<LivroVO>> retornarLivros(Pageable pageable) {

        var modelPageListLivro = livroRepository.findAll(pageable);

        var modelPageListVOPage = modelPageListLivro.map(livro -> DozerMapper.parseObject(livro, LivroVO.class));

        modelPageListVOPage.map(l -> l.add(linkTo(methodOn(LivroController.class).retornarLivro(l.getIdLivro())).withSelfRel()));

        Link link = linkTo(methodOn(LivroController.class).retornarTodosLivros(pageable.getPageNumber(), pageable.getPageSize(), "asc")).withSelfRel();

        return pagedResourcesAssembler.toModel(modelPageListVOPage, link);
    }


}