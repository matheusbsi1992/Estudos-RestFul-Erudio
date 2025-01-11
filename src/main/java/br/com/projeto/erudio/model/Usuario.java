package br.com.projeto.erudio.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "user_name_usuario", unique = true, nullable = false)
    private String userName;

    @Column(name = "full_name_usuario")
    private String fullNameUsuario;

    @Column(name = "password_usuario", nullable = false)
    private String passwordUsuario;

    @Column(name = "account_non_expired_usuario")
    private Boolean accountNonExpiredUsuario;

    @Column(name = "account_non_locked_usuario")
    private Boolean accountNonLockedUsuario;

    @Column(name = "credentials_non_expired_usuario")
    private Boolean credentialsNonExpiredUsuario;

    @Column(name = "ativo_usuario")
    private Boolean ativoUsuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_permissao",
            joinColumns = {@JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "id_permissao")})
    private List<Permissao> permissaoList;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String userName, String fullNameUsuario, String passwordUsuario, Boolean accountNonExpiredUsuario, Boolean accountNonLockedUsuario, Boolean credentialsNonExpiredUsuario, Boolean ativoUsuario, List<Permissao> permissaoList) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.fullNameUsuario = fullNameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.accountNonExpiredUsuario = accountNonExpiredUsuario;
        this.accountNonLockedUsuario = accountNonLockedUsuario;
        this.credentialsNonExpiredUsuario = credentialsNonExpiredUsuario;
        this.ativoUsuario = ativoUsuario;
        this.permissaoList = permissaoList;
    }

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        for (Permissao permissao : permissaoList) {
            roles.add(permissao.getDescricaoPermissao());
        }
        return roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissaoList;
    }

    @Override
    public String getPassword() {
        return this.passwordUsuario;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpiredUsuario;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLockedUsuario;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpiredUsuario;
    }

    @Override
    public boolean isEnabled() {
        return this.ativoUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getFullNameUsuario() {
        return fullNameUsuario;
    }

    public void setFullNameUsuario(String fullNameUsuario) {
        this.fullNameUsuario = fullNameUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Boolean getAccountNonExpiredUsuario() {
        return accountNonExpiredUsuario;
    }

    public void setAccountNonExpiredUsuario(Boolean accountNonExpiredUsuario) {
        this.accountNonExpiredUsuario = accountNonExpiredUsuario;
    }

    public Boolean getAccountNonLockedUsuario() {
        return accountNonLockedUsuario;
    }

    public void setAccountNonLockedUsuario(Boolean accountNonLockedUsuario) {
        this.accountNonLockedUsuario = accountNonLockedUsuario;
    }

    public Boolean getCredentialsNonExpiredUsuario() {
        return credentialsNonExpiredUsuario;
    }

    public void setCredentialsNonExpiredUsuario(Boolean credentialsNonExpiredUsuario) {
        this.credentialsNonExpiredUsuario = credentialsNonExpiredUsuario;
    }

    public Boolean getAtivoUsuario() {
        return ativoUsuario;
    }

    public void setAtivoUsuario(Boolean ativoUsuario) {
        this.ativoUsuario = ativoUsuario;
    }

    public List<Permissao> getPermissaoList() {
        return permissaoList;
    }

    public void setPermissaoList(List<Permissao> permissaoList) {
        this.permissaoList = permissaoList;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;

        return idUsuario.equals(usuario.idUsuario) && userName.equals(usuario.userName) && fullNameUsuario.equals(usuario.fullNameUsuario) && passwordUsuario.equals(usuario.passwordUsuario) && accountNonExpiredUsuario.equals(usuario.accountNonExpiredUsuario) && accountNonLockedUsuario.equals(usuario.accountNonLockedUsuario) && credentialsNonExpiredUsuario.equals(usuario.credentialsNonExpiredUsuario) && ativoUsuario.equals(usuario.ativoUsuario) && permissaoList.equals(usuario.permissaoList);
    }

    @Override
    public int hashCode() {
        int result = idUsuario.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + fullNameUsuario.hashCode();
        result = 31 * result + passwordUsuario.hashCode();
        result = 31 * result + accountNonExpiredUsuario.hashCode();
        result = 31 * result + accountNonLockedUsuario.hashCode();
        result = 31 * result + credentialsNonExpiredUsuario.hashCode();
        result = 31 * result + ativoUsuario.hashCode();
        result = 31 * result + permissaoList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", userName='" + userName + '\'' +
                ", fullNameUsuario='" + fullNameUsuario + '\'' +
                ", passwordUsuario='" + passwordUsuario + '\'' +
                ", accountNonExpiredUsuario=" + accountNonExpiredUsuario +
                ", accountNonLockedUsuario=" + accountNonLockedUsuario +
                ", credentialsNonExpiredUsuario=" + credentialsNonExpiredUsuario +
                ", ativoUsuario=" + ativoUsuario +
                ", permissaoList=" + permissaoList +
                '}';
    }
}