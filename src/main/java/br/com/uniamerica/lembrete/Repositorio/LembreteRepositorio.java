package br.com.uniamerica.lembrete.Repositorio;

import br.com.uniamerica.lembrete.Entidade.Lembrete;
import br.com.uniamerica.lembrete.Entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LembreteRepositorio extends JpaRepository<Lembrete, Long> {
}
