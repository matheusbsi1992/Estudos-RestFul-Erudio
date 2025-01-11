package br.com.projeto.erudio.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLivro")
    private Long idLivro;

    @Column(name = "autorLivro", nullable = false)
    private String autorLivro;

    @Column(name = "dataLivro", nullable = false)
    private LocalDateTime dataLivro;

    @Column(name = "precoLivro", scale = 2, nullable = false)
    private Double precoLivro;

    @Column(name = "tituloLivro", nullable = false)
    private String tituloLivro;

    public Livro(Long idLivro, String autorLivro, LocalDateTime dataLivro, Double precoLivro, String tituloLivro) {
        this.idLivro = idLivro;
        this.autorLivro = autorLivro;
        this.dataLivro = dataLivro;
        this.precoLivro = precoLivro;
        this.tituloLivro = tituloLivro;
    }

    public Livro() {
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public LocalDateTime getDataLivro() {
        return dataLivro;
    }

    public void setDataLivro(LocalDateTime dataLivro) {
        this.dataLivro = dataLivro;
    }

    public Double getPrecoLivro() {
        return precoLivro;
    }

    public void setPrecoLivro(Double precoLivro) {
        this.precoLivro = precoLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;

        return idLivro.equals(livro.idLivro) && autorLivro.equals(livro.autorLivro) && dataLivro.equals(livro.dataLivro) && precoLivro.equals(livro.precoLivro) && tituloLivro.equals(livro.tituloLivro);
    }

    @Override
    public int hashCode() {
        int result = idLivro.hashCode();
        result = 31 * result + autorLivro.hashCode();
        result = 31 * result + dataLivro.hashCode();
        result = 31 * result + precoLivro.hashCode();
        result = 31 * result + tituloLivro.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", autorLivro='" + autorLivro + '\'' +
                ", dataLivro=" + dataLivro +
                ", precoLivro=" + precoLivro +
                ", tituloLivro='" + tituloLivro + '\'' +
                '}';
    }
}
