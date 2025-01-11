package br.com.projeto.erudio.vo.v2;

import java.io.Serializable;
import java.util.Date;


public class PessoaVO2 implements Serializable {

    private Long idPessoa;

    private String nomePessoa;

    private String sobreNomePessoa;

    private String enderecoPessoa;

    private String sexoPessoa;

    private Date dataAniversarioPessoa;


    public PessoaVO2(Long idPessoa, String nomePessoa, String sobreNomePessoa, String enderecoPessoa, String sexoPessoa, Date dataAniversarioPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.sobreNomePessoa = sobreNomePessoa;
        this.enderecoPessoa = enderecoPessoa;
        this.sexoPessoa = sexoPessoa;
        this.dataAniversarioPessoa = dataAniversarioPessoa;
    }

    public PessoaVO2() {
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

    public Date getDataAniversarioPessoa() {
        return dataAniversarioPessoa;
    }

    public void setDataAniversarioPessoa(Date dataAniversarioPessoa) {
        this.dataAniversarioPessoa = dataAniversarioPessoa;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaVO2 pessoaVO2)) return false;

        return idPessoa.equals(pessoaVO2.idPessoa) && nomePessoa.equals(pessoaVO2.nomePessoa) && sobreNomePessoa.equals(pessoaVO2.sobreNomePessoa) && enderecoPessoa.equals(pessoaVO2.enderecoPessoa) && sexoPessoa.equals(pessoaVO2.sexoPessoa) && dataAniversarioPessoa.equals(pessoaVO2.dataAniversarioPessoa);
    }

    @Override
    public int hashCode() {
        int result = idPessoa.hashCode();
        result = 31 * result + nomePessoa.hashCode();
        result = 31 * result + sobreNomePessoa.hashCode();
        result = 31 * result + enderecoPessoa.hashCode();
        result = 31 * result + sexoPessoa.hashCode();
        result = 31 * result + dataAniversarioPessoa.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PessoaVO2{" +
                "idPessoa=" + idPessoa +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", sobreNomePessoa='" + sobreNomePessoa + '\'' +
                ", enderecoPessoa='" + enderecoPessoa + '\'' +
                ", sexoPessoa='" + sexoPessoa + '\'' +
                ", dataAniversarioPessoa=" + dataAniversarioPessoa +
                '}';
    }
}