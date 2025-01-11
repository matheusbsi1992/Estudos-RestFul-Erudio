package br.com.projeto.erudio.repository;

import br.com.projeto.erudio.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    @Modifying
    @Query("UPDATE Pessoa p " +
            "SET p.ativacaoPessoa = false " +
            "WHERE p.idPessoa = :idPessoa")
    void desativarPessoa(@Param("idPessoa") Long idPessoa);

    @Query("SELECT p " +
            "FROM Pessoa p " +
            "WHERE p.nomePessoa LIKE LOWER(CONCAT ('%',:nomePessoa,'%'))")
    Page<Pessoa> retornarPessoaPorNome(@Param("nomePessoa") String nomePessoa, Pageable pageable);


}