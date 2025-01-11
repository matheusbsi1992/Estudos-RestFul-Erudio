package br.com.projeto.erudio.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;


@Entity
@Table(name = "permissao")
public class Permissao implements GrantedAuthority, Serializable {

    @Id
    @Column(name = "idPermissao", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermissao;

    @Column(name = "descricaoPermissao")
    private String descricaoPermissao;

    public Permissao(Long idPermissao, String descricaoPermissao) {
        this.idPermissao = idPermissao;
        this.descricaoPermissao = descricaoPermissao;
    }

    public Permissao() {
    }

    public Long getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Long idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getDescricaoPermissao() {
        return descricaoPermissao;
    }

    public void setDescricaoPermissao(String descricaoPermissao) {
        this.descricaoPermissao = descricaoPermissao;
    }

    @Override
    public String getAuthority() {
        return this.descricaoPermissao;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permissao permissao)) return false;

        return idPermissao.equals(permissao.idPermissao) && descricaoPermissao.equals(permissao.descricaoPermissao);
    }

    @Override
    public int hashCode() {
        int result = idPermissao.hashCode();
        result = 31 * result + descricaoPermissao.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Permissao{" +
                "idPermissao=" + idPermissao +
                ", descricaoPermissao='" + descricaoPermissao + '\'' +
                '}';
    }

}
