package br.com.pdro.psj.cardizpsj.controller;

import br.com.pdro.psj.cardizpsj.model.entity.Entrada;
import br.com.pdro.psj.cardizpsj.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @GetMapping
    public List<Entrada> getAll() {
        return entradaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrada> getById(@PathVariable Long id) {
        return entradaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrada create(@RequestBody Entrada entrada) {
        return entradaService.save(entrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrada> update(@PathVariable Long id, @RequestBody Entrada entrada) {
        return entradaService.findById(id)
                .map(existingEntrada -> {
                    entrada.setId(existingEntrada.getId());
                    return ResponseEntity.ok(entradaService.save(entrada));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entradaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
