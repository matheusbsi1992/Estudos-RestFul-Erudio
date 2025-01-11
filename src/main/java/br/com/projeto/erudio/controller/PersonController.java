package br.com.projeto.erudio.controller;

import br.com.projeto.erudio.services.PessoaService;
import br.com.projeto.erudio.vo.v1.PessoaVO;
import br.com.projeto.erudio.vo.v2.PessoaVO2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.projeto.erudio.util.MediaType.*;

@RestController
@RequestMapping("/api/pessoa/v1")
@Tag(name = "Pessoa", description = "EndPoint para o gerenciamento de Pessoas")
public class PersonController {

    //@Qualifier("pessoaServer")
    @Autowired
    private PessoaService pessoaService;

    /*public void setPessoaServer(PessoaServer pessoaServer) {
        this.pessoaServer = pessoaServer;
    }*/

    @PostMapping(value = "/inserirPessoa"
            //, method = RequestMethod.POST
            , consumes = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Inserir Pessoa", description = "Inserir Pessoa", tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = PessoaVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Not Found", responseCode = "404",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Internal Error", responseCode = "500",
                            content = {
                                    @Content
                            })
            })
    public PessoaVO inserirPessoa(@RequestBody PessoaVO pessoa) {
        return pessoaService.inserirPessoa(pessoa);
    }

    /* @PostMapping(value = "/v2/inserirPessoa"
             //, method = RequestMethod.POST
             , consumes = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
             , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
     )*/
    public PessoaVO2 inserirPessoaV2(@RequestBody PessoaVO2 pessoa) {
        return pessoaService.inserirPessoaV02(pessoa);
    }

    @PutMapping(value = "/atualizarPessoa"
            //, method = RequestMethod.PUT
            , consumes = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Atualizar Pessoa", description = "Atualizar Pessoa", tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = PessoaVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Not Found", responseCode = "404",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Internal Error", responseCode = "500",
                            content = {
                                    @Content
                            })
            })
    public PessoaVO atualizarPessoa(@RequestBody PessoaVO pessoa) {
        return pessoaService.atualizarPessoa(pessoa);
    }

    @DeleteMapping(value = "/deletarPessoa/{idPessoa}"
            //, method = RequestMethod.DELETE)
    )
    @Operation(summary = "Deletar Pessoa", description = "Deletar Pessoa", tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = PessoaVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Not Found", responseCode = "404",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Internal Error", responseCode = "500",
                            content = {
                                    @Content
                            })
            })
    public ResponseEntity<?> deletarPessoa(@PathVariable(value = "idPessoa") Long idPessoa) {
        pessoaService.deletarPessoa(idPessoa);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/buscarPessoa/{idPessoa}"
            //, method = RequestMethod.GET
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Buscar Pessoa", description = "Buscar Pessoa", tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = PessoaVO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Not Found", responseCode = "404",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Internal Error", responseCode = "500",
                            content = {
                                    @Content
                            })
            })
    public PessoaVO retornarIdPessoa(@PathVariable(value = "idPessoa") Long idPessoa) {
        return pessoaService.findById(idPessoa);
    }


    @PatchMapping(value = "/desativarPessoa/{idPessoa}"
            //, method = RequestMethod.GET
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Desativar Pessoa", description = "Desativar Pessoa", tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = PessoaVO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Forbidden", responseCode = "403",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Not Found", responseCode = "404",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Internal Error", responseCode = "500",
                            content = {
                                    @Content
                            })
            })
    public PessoaVO desativarPessoa(@PathVariable(value = "idPessoa") Long idPessoa) {
        return pessoaService.desativarPessoa(idPessoa);
    }

    @GetMapping(path = "/buscarPessoaPorNome/{nomePessoa}"
            //, method = RequestMethod.GET
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Listar Pessoas Por Nome", description = "Listar Pessoas Por Nome", tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json"
                                            , array = @ArraySchema(schema = @Schema(implementation = PessoaVO.class)))
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Forbidden", responseCode = "403",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Not Found", responseCode = "404",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Internal Error", responseCode = "500",
                            content = {
                                    @Content
                            })
            })
    public ResponseEntity<PagedModel<EntityModel<PessoaVO>>> retornarTodosNomePessoa(@PathVariable(value = "nomePessoa") String nomePessoa,
                                                                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                                     @RequestParam(value = "page", defaultValue = "12") Integer size,
                                                                                     @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "nomePessoa"));

        return ResponseEntity.ok(pessoaService.buscarPorNomeDaPessoa(nomePessoa, pageable));
    }

    @GetMapping(path = "/listarPessoa"
            //, method = RequestMethod.GET
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Listar Pessoas", description = "Listar Pessoas", tags = {"Pessoa"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json"
                                            , array = @ArraySchema(schema = @Schema(implementation = PessoaVO.class)))
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Forbidden", responseCode = "403",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Not Found", responseCode = "404",
                            content = {
                                    @Content
                            }),
                    @ApiResponse(description = "Internal Error", responseCode = "500",
                            content = {
                                    @Content
                            })
            })
    public ResponseEntity<PagedModel<EntityModel<PessoaVO>>> retornarTodasPessoa(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                                 @RequestParam(value = "page", defaultValue = "12") Integer size,
                                                                                 @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "nomePessoa"));

        return ResponseEntity.ok(pessoaService.findAll(pageable));
    }
}