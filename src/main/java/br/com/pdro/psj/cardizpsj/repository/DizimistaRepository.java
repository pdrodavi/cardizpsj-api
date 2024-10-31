package br.com.pdro.psj.cardizpsj.repository;

import br.com.pdro.psj.cardizpsj.model.entity.Dizimista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DizimistaRepository extends JpaRepository<Dizimista, Long> {

    Optional<Dizimista> findByCod(Long cod);

}
