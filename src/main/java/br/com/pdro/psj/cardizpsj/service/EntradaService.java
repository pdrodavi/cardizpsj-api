package br.com.pdro.psj.cardizpsj.service;

import br.com.pdro.psj.cardizpsj.model.entity.Entrada;
import br.com.pdro.psj.cardizpsj.model.entity.Entradas;
import br.com.pdro.psj.cardizpsj.repository.EntradaRepository;
import br.com.pdro.psj.cardizpsj.repository.EntradasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;
    @Autowired
    private EntradasRepository entradasRepository;

    public List<Entrada> findAll() {
        return entradaRepository.findAll();
    }

    public Optional<Entrada> findById(Long id) {
        return entradaRepository.findById(id);
    }

    public Optional<List<Entrada>> findByCode(Long cod) {
        return entradaRepository.findByCodDizimista(cod);
    }

    public Optional<Entrada> findByPeriod(Long cod, String dtPgto) {
        return entradaRepository.findByPeriod(cod, dtPgto);
    }

    public Optional<List<Entradas>> findByAllPeriod(String interval) {
        return entradasRepository.findByAllPeriod(interval);
    }

    public Entrada save(Entrada entrada) {
        entrada.setDataPgto(LocalDate.now());
        entrada.setDataRef(LocalDateTime.now());
        return entradaRepository.save(entrada);
    }

    public void deleteById(Long id) {
        entradaRepository.deleteById(id);
    }
}
