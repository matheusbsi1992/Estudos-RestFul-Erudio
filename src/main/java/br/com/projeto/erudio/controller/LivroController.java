package br.com.projeto.erudio.controller;

import br.com.projeto.erudio.services.LivroService;
import br.com.projeto.erudio.vo.v1.LivroVO;
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
@RequestMapping("/api/livro/v1")
@Tag(name = "Livro", description = "EndPoint para o gerenciamento de Livros")
public class LivroController {

    @Autowired
    private LivroService livroService;


    @PostMapping(value = "/inserirLivro"
            //, method = RequestMethod.POST
            , consumes = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Inserir Livro", description = "Inserir Livro", tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = LivroVO.class))
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
    public LivroVO inserirLivro(@RequestBody LivroVO livro) {
        return livroService.inserirLivro(livro);
    }

    @PutMapping(value = "/atualizarLivro"
            //, method = RequestMethod.PUT
            , consumes = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Atualizar Livro", description = "Atualizar Livro", tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =
                            @Content(schema = @Schema(implementation = LivroVO.class))
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
    public LivroVO atualizarLivro(@RequestBody LivroVO livro) {
        return livroService.atualizarLivro(livro);
    }

    @DeleteMapping(value = "/deletarLivro/{idLivro}"
            //, method = RequestMethod.DELETE)
    )
    @Operation(summary = "Deletar Livro", description = "Deletar Livro", tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = LivroVO.class))
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
    public ResponseEntity<?> deletarLivro(@PathVariable(value = "idLivro") Long idLivro) {
        livroService.deletarLivro(idLivro);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/buscarLivro/{idLivro}"
            //, method = RequestMethod.GET
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Buscar Livro", description = "Buscar Livro", tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = LivroVO.class))
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
    public LivroVO retornarLivro(@PathVariable(value = "idLivro") Long idLivro) {
        return livroService.findById(idLivro);
    }

    @GetMapping(path = "/listarlivro"
            //, method = RequestMethod.GET
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Listar Livros", description = "Listar Livros", tags = {"Livro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json"
                                            , array = @ArraySchema(schema = @Schema(implementation = LivroVO.class)))
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
    public ResponseEntity<PagedModel<EntityModel<LivroVO>>> retornarTodosLivros(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                                @RequestParam(value = "size", defaultValue = "12") Integer size,
                                                                                @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        var valorSortedAscDesc = "asc".equalsIgnoreCase(direction) ? Sort.Direction.ASC : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(valorSortedAscDesc, "autorLivro"));

        return ResponseEntity.ok(livroService.retornarLivros(pageable));
    }
}