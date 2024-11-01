package br.com.pdro.psj.cardizpsj.repository;

import br.com.pdro.psj.cardizpsj.model.entity.Entrada;
import br.com.pdro.psj.cardizpsj.model.entity.Entradas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    Optional<List<Entrada>> findByCodDizimista(Long cod);
    @Query(value = "SELECT * FROM psj.entradas where cod_dizimista = :codDiz and data_pgto\\:\\:text like :dtPgto%", nativeQuery = true)
    Optional<Entrada> findByPeriod(@Param("codDiz") Long codDiz, @Param("dtPgto") String dtPgto);

//    @Query(value = "SELECT entradas.id, entradas.cod_dizimista, entradas.valor_pgto, entradas.data_pgto, entradas.data_ref, dizimistas.nome FROM psj.entradas inner join psj.dizimistas on entradas.cod_dizimista = dizimistas.cod and data_pgto\\:\\:text like :dtPgto%", nativeQuery = true)
//    Optional<List<Entradas>> findByAllPeriod(@Param("dtPgto") String dtPgto);
}
