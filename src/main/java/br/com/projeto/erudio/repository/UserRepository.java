package br.com.projeto.erudio.repository;

import br.com.projeto.erudio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u " +
            "FROM Usuario u " +
            "WHERE u.userName = :userName")
    Usuario findByUserName(@Param("userName") String userName);


}
