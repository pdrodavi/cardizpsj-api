package br.com.pdro.psj.cardizpsj.controller;

import br.com.pdro.psj.cardizpsj.model.entity.Entrada;
import br.com.pdro.psj.cardizpsj.service.DizimistaService;
import br.com.pdro.psj.cardizpsj.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static br.com.pdro.psj.cardizpsj.utils.Validate.isSearchByCode;

@RestController
@RequestMapping("/entries")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private DizimistaService dizimistaService;

    @GetMapping
    public ResponseEntity<List<Entrada>> getAll() {
        if (entradaService.findAll().isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(entradaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrada> getById(@PathVariable String id, @RequestParam(value = "searchBy", required = false, defaultValue = "") String searchBy) {
        if (isSearchByCode(searchBy)) return entradaService.findByCode(Long.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
        else return entradaService.findById(Long.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Entrada entrada) {
        if (dizimistaService.findByCode(entrada.getCodDizimista()).isEmpty()) {
            entrada.setDataPgto(LocalDate.now());
            entrada.setDataRef(LocalDateTime.now());
            Entrada saved = entradaService.save(entrada);
            if (saved != null) return ResponseEntity.status(HttpStatus.CREATED.value()).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrada> update(@PathVariable String id, @RequestBody Entrada entrada) {
        return entradaService.findById(Long.valueOf(id))
                .map(existingEntrada -> {
                    entrada.setId(existingEntrada.getId());
                    return ResponseEntity.ok(entradaService.save(entrada));
                })
                .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (entradaService.findById(Long.valueOf(id)).isPresent()) entradaService.deleteById(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }
}
