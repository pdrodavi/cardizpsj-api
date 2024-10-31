package br.com.pdro.psj.cardizpsj.controller;

import br.com.pdro.psj.cardizpsj.model.entity.Dizimista;
import br.com.pdro.psj.cardizpsj.service.DizimistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static br.com.pdro.psj.cardizpsj.utils.GenPDF.generatePDF;

@RestController
@RequestMapping("/carnets")
public class CarnesController {

    @Autowired
    private DizimistaService dizimistaService;

    @GetMapping
    public List<byte[]> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getById(@PathVariable String id, @RequestParam(value = "searchBy", required = false, defaultValue = "") String searchBy) {

        Dizimista dizimista = new Dizimista();

        if (searchBy.equals("code")) {
            if (dizimistaService.findByCode(Long.valueOf(id)).isPresent()) {
                Dizimista dizimista1 = dizimistaService.findByCode(Long.valueOf(id)).get();
                dizimista.setCod(dizimista1.getCod());
                dizimista.setNome(dizimista1.getNome());
            }
        }
//        if (searchBy.equals("code")) {
//            ResponseEntity<Dizimista> dizimistaResponseEntity = dizimistaService.findByCode(Long.valueOf(id))
//                    .map(ResponseEntity::ok)
//                    .orElse(ResponseEntity.notFound().build());
//            dizimista = dizimistaResponseEntity.getBody();
//        }

        else if (searchBy.isEmpty() || searchBy.isBlank()) {
            Optional<Dizimista> dizimistaServiceById = dizimistaService.findById(Long.valueOf(id));
            if (dizimistaServiceById.isPresent()) {
                dizimista.setCod(dizimistaServiceById.get().getCod());
                dizimista.setNome(dizimistaServiceById.get().getNome());
            }
        }

        byte[] generatedPDF = generatePDF(String.valueOf(dizimista.getCod()), dizimista.getNome());

        String nameFile = String.valueOf(dizimista.getCod()) + " - " + dizimista.getNome() + " - " + String.valueOf(LocalDate.now().getYear()) + ".pdf";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + nameFile + "\"")
                .body(generatedPDF);

    }
}
