package br.com.projeto.erudio.controller;

import br.com.projeto.erudio.services.AuthService;
import br.com.projeto.erudio.vo.seguranca.ContasCredencialVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.projeto.erudio.util.MediaType.*;


@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Endpoint")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping(value = "/signin"
            , consumes = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Signin", description = "Signin", tags = {"Authentication Endpoint"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = ContasCredencialVO.class))
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
    public ResponseEntity<?> signIn(@RequestBody ContasCredencialVO contasCredencialVO) {
        if (contasCredencialVO == null ||
                contasCredencialVO.getUserName().isBlank() || contasCredencialVO.getUserName().isEmpty() || contasCredencialVO.getUserName() == null
                || contasCredencialVO.getSenha().isBlank() || contasCredencialVO.getSenha().isEmpty() || contasCredencialVO.getSenha() == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        var token = authService.signin(contasCredencialVO);

        if (token == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        } else {
            return token;
        }
    }

    @PutMapping(value = "/refresh/{username}"
            , consumes = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
            , produces = {MEDIA_TYPE_YAML, MEDIA_TYPE_JSON, MEDIA_TYPE_XML}
    )
    @Operation(summary = "Refresh", description = "Refresh", tags = {"Authentication Endpoint"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content =
                            @Content(mediaType = "application/json"
                                    , schema = @Schema(implementation = ContasCredencialVO.class))
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
    public ResponseEntity<?> refresh(@PathVariable("username") String username, @RequestHeader("Authorization") String refreshToken) {
        if (refreshToken == null ||
                refreshToken.isBlank() || refreshToken.isEmpty() || username == null
                || username.isBlank() || username.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        System.out.println("refresh token --->>>" + refreshToken);
        var token = authService.refreshToken(username, refreshToken);

        if (token == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        } else {
            return token;
        }
    }

}
