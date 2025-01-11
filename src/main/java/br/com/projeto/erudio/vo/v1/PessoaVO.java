package br.com.projeto.erudio.vo.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"idPessoa", "nomePessoa", "sobreNomePessoa", "sexoPessoa", "enderecoPessoa", "ativacaoPessoa"})
public class PessoaVO extends RepresentationModel<PessoaVO> implements Serializable {

    //@JsonProperty(value = "id_pessoa")
    //@Mapping("id")
    private Long idPessoa;

    //@JsonProperty(value = "nome_pessoa")
    private String nomePessoa;

    //@JsonProperty(value = "sobre_nome_pessoa")
    private String sobreNomePessoa;

    //@JsonProperty(value = "endereco_pessoa")
    private String enderecoPessoa;

    //@JsonIgnore
    //@JsonProperty(value = "sexo_pessoa")
    private String sexoPessoa;

    private Boolean ativacaoPessoa;

}
