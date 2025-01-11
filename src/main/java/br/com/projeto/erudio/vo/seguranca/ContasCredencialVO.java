package br.com.projeto.erudio.vo.seguranca;

import java.io.Serializable;

public class ContasCredencialVO implements Serializable {

    private String userName;
    private String senha;

    public ContasCredencialVO(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
    }

    public ContasCredencialVO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContasCredencialVO that)) return false;

        return userName.equals(that.userName) && senha.equals(that.senha);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + senha.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ContasCredencialVO{" +
                "userName='" + userName + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
