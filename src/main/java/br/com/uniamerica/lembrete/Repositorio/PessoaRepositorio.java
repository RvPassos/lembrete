package br.com.uniamerica.lembrete.Repositorio;

import br.com.uniamerica.lembrete.Entidade.Lembrete;
import br.com.uniamerica.lembrete.Entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

    //jpql
    @Query(value = "SELECT p FROM Pessoa p where p.nome = :nome")
    List<Pessoa> findByNome(@Param("nome") final String nome);

}
