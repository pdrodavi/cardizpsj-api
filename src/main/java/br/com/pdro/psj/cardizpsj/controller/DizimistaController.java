package br.com.pdro.psj.cardizpsj.controller;

import br.com.pdro.psj.cardizpsj.model.entity.Dizimista;
import br.com.pdro.psj.cardizpsj.service.DizimistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.pdro.psj.cardizpsj.utils.Validate.isSearchByCode;

@RestController
@RequestMapping("/tithers")
public class DizimistaController {

    @Autowired
    private DizimistaService dizimistaService;

    @GetMapping
    public ResponseEntity<List<Dizimista>> getAll() {
        if (dizimistaService.findAll().isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dizimistaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dizimista> getById(@PathVariable String id, @RequestParam(value = "searchBy", required = false, defaultValue = "") String searchBy) {
        if (isSearchByCode(searchBy)) return dizimistaService.findByCode(Long.valueOf(id))
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.noContent().build());
        else return dizimistaService.findById(Long.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Dizimista dizimista) {
        dizimistaService.findByCode(dizimista.getCod())
                .map(existingDizimista -> ResponseEntity.badRequest().build());
        Dizimista saved = dizimistaService.save(dizimista);
        if (saved != null) return ResponseEntity.status(HttpStatus.CREATED.value()).build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dizimista> update(@PathVariable String id, @RequestBody Dizimista dizimista, @RequestParam(value = "searchBy", required = false, defaultValue = "") String searchBy) {
        if (isSearchByCode(searchBy)) return dizimistaService.findByCode(Long.valueOf(id))
                .map(existingDizimista -> {
                    dizimista.setId(existingDizimista.getId());
                    return ResponseEntity.ok(dizimistaService.save(dizimista));
                })
                .orElse(ResponseEntity.noContent().build());
        else return dizimistaService.findById(Long.valueOf(id))
                .map(existingDizimista -> {
                    dizimista.setId(existingDizimista.getId());
                    return ResponseEntity.ok(dizimistaService.save(dizimista));
                })
                .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id, @RequestParam(value = "searchBy", required = false, defaultValue = "") String searchBy) {
        if (isSearchByCode(searchBy) && dizimistaService.findByCode(Long.valueOf(id)).isPresent()) dizimistaService.deleteByCode(Long.valueOf(id));
        else if (!isSearchByCode(searchBy) && dizimistaService.findById(Long.valueOf(id)).isPresent()) dizimistaService.deleteById(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }
}
