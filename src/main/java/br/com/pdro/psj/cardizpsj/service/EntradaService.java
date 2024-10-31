package br.com.pdro.psj.cardizpsj.service;

import br.com.pdro.psj.cardizpsj.model.entity.Entrada;
import br.com.pdro.psj.cardizpsj.repository.EntradaRepository;
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

    public List<Entrada> findAll() {
        return entradaRepository.findAll();
    }

    public Optional<Entrada> findById(Long id) {
        return entradaRepository.findById(id);
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
