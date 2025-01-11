package br.com.projeto.erudio.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa")
    private Long idPessoa;

    @Column(name = "nomePessoa", nullable = false, length = 80)
    private String nomePessoa;

    @Column(name = "sobreNomePessoa", nullable = false, length = 80)
    private String sobreNomePessoa;

    @Column(name = "enderecoPessoa", nullable = false, length = 150)
    private String enderecoPessoa;

    @Column(name = "sexoPessoa", nullable = false, length = 1)
    private String sexoPessoa;

    @Column(name = "ativacao_pessoa", nullable = false, length = 1)
    private Boolean ativacaoPessoa;

    public Pessoa(Long idPessoa, String nomePessoa, String sobreNomePessoa, String enderecoPessoa, String sexoPessoa, Boolean ativacaoPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.sobreNomePessoa = sobreNomePessoa;
        this.enderecoPessoa = enderecoPessoa;
        this.sexoPessoa = sexoPessoa;
        this.ativacaoPessoa = ativacaoPessoa;
    }

    public Pessoa() {
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getSobreNomePessoa() {
        return sobreNomePessoa;
    }

    public void setSobreNomePessoa(String sobreNomePessoa) {
        this.sobreNomePessoa = sobreNomePessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public String getSexoPessoa() {
        return sexoPessoa;
    }

    public void setSexoPessoa(String sexoPessoa) {
        this.sexoPessoa = sexoPessoa;
    }

    public Boolean getAtivacaoPessoa() {
        return ativacaoPessoa;
    }

    public void setAtivacaoPessoa(Boolean ativacaoPessoa) {
        this.ativacaoPessoa = ativacaoPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", sobreNomePessoa='" + sobreNomePessoa + '\'' +
                ", enderecoPessoa='" + enderecoPessoa + '\'' +
                ", sexoPessoa='" + sexoPessoa + '\'' +
                ", ativacaoPessoa=" + ativacaoPessoa +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;

        return idPessoa.equals(pessoa.idPessoa) && nomePessoa.equals(pessoa.nomePessoa) && sobreNomePessoa.equals(pessoa.sobreNomePessoa) && enderecoPessoa.equals(pessoa.enderecoPessoa) && sexoPessoa.equals(pessoa.sexoPessoa) && ativacaoPessoa.equals(pessoa.ativacaoPessoa);
    }

    @Override
    public int hashCode() {
        int result = idPessoa.hashCode();
        result = 31 * result + nomePessoa.hashCode();
        result = 31 * result + sobreNomePessoa.hashCode();
        result = 31 * result + enderecoPessoa.hashCode();
        result = 31 * result + sexoPessoa.hashCode();
        result = 31 * result + ativacaoPessoa.hashCode();
        return result;
    }
}
