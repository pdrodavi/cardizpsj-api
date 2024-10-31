package br.com.pdro.psj.cardizpsj.service;

import br.com.pdro.psj.cardizpsj.model.entity.Dizimista;
import br.com.pdro.psj.cardizpsj.repository.DizimistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DizimistaService {

    @Autowired
    private DizimistaRepository dizimistaRepository;

    public List<Dizimista> findAll() {
        return dizimistaRepository.findAll();
    }

    public Optional<Dizimista> findById(Long id) {
        return dizimistaRepository.findById(id);
    }

    public Optional<Dizimista> findByCode(Long cod) {
        return dizimistaRepository.findByCod(cod);
    }

    public Dizimista save(Dizimista dizimista) {
        return dizimistaRepository.save(dizimista);
    }

    public void deleteById(Long id) {
        dizimistaRepository.deleteById(id);
    }

    public void deleteByCode(Long cod) {
        dizimistaRepository.deleteByCod(cod);
    }
}
