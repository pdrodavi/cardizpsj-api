package br.com.pdro.psj.cardizpsj.controller;

import br.com.pdro.psj.cardizpsj.model.dto.DizimistaResponseDTO;
import br.com.pdro.psj.cardizpsj.model.entity.Dizimista;
import br.com.pdro.psj.cardizpsj.service.DizimistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tithers")
public class DizimistaController {

    @Autowired
    private DizimistaService dizimistaService;

    @GetMapping
    public List<Dizimista> getAll() {
        return dizimistaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dizimista> getById(@PathVariable String id, @RequestParam(value = "searchBy", required = false, defaultValue = "") String searchBy) {

        if (searchBy.equals("code")) {
            return dizimistaService.findByCode(Long.valueOf(id))
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } else if (searchBy.isEmpty() || searchBy.isBlank()) {
            return dizimistaService.findById(Long.valueOf(id))
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public Dizimista create(@RequestBody Dizimista dizimista) {
        return dizimistaService.save(dizimista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dizimista> update(@PathVariable Long id, @RequestBody Dizimista dizimista) {
        return dizimistaService.findById(id)
                .map(existingDizimista -> {
                    dizimista.setId(existingDizimista.getId());
                    return ResponseEntity.ok(dizimistaService.save(dizimista));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dizimistaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
