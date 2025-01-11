package br.com.projeto.erudio.vo.seguranca;

import java.io.Serializable;
import java.util.Date;

public class TokenVO implements Serializable {

    private String userName;
    private Boolean autenticado;
    private Date criacao;
    private Date expirado;
    private String acessoToken;
    private String atualizarToken;

    public TokenVO() {
    }

    public TokenVO(String userName, Boolean autenticado, Date criacao, Date expirado, String acessoToken, String atualizarToken) {
        this.userName = userName;
        this.autenticado = autenticado;
        this.criacao = criacao;
        this.expirado = expirado;
        this.acessoToken = acessoToken;
        this.atualizarToken = atualizarToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Date getExpirado() {
        return expirado;
    }

    public void setExpirado(Date expirado) {
        this.expirado = expirado;
    }

    public String getAcessoToken() {
        return acessoToken;
    }

    public void setAcessoToken(String acessoToken) {
        this.acessoToken = acessoToken;
    }

    public String getAtualizarToken() {
        return atualizarToken;
    }

    public void setAtualizarToken(String atualizarToken) {
        this.atualizarToken = atualizarToken;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenVO tokenVO)) return false;

        return userName.equals(tokenVO.userName) && autenticado.equals(tokenVO.autenticado) && criacao.equals(tokenVO.criacao) && expirado.equals(tokenVO.expirado) && acessoToken.equals(tokenVO.acessoToken) && atualizarToken.equals(tokenVO.atualizarToken);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + autenticado.hashCode();
        result = 31 * result + criacao.hashCode();
        result = 31 * result + expirado.hashCode();
        result = 31 * result + acessoToken.hashCode();
        result = 31 * result + atualizarToken.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TokenVO{" +
                "userName='" + userName + '\'' +
                ", autenticado=" + autenticado +
                ", criacao=" + criacao +
                ", expirado=" + expirado +
                ", acessoToken='" + acessoToken + '\'' +
                ", atualizarToken='" + atualizarToken + '\'' +
                '}';
    }

}