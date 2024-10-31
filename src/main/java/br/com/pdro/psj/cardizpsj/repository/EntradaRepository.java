package br.com.pdro.psj.cardizpsj.repository;

import br.com.pdro.psj.cardizpsj.model.entity.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
}
