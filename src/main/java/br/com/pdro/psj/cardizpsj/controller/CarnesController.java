package br.com.pdro.psj.cardizpsj.controller;

import br.com.pdro.psj.cardizpsj.model.dto.PDFResponseDTO;
import br.com.pdro.psj.cardizpsj.model.entity.Dizimista;
import br.com.pdro.psj.cardizpsj.service.DizimistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Base64;
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
    public ResponseEntity<PDFResponseDTO> getById(@PathVariable String id, @RequestParam(value = "searchBy", required = false, defaultValue = "") String searchBy) {

        Dizimista dizimista = new Dizimista();

        if (searchBy.equals("code")) {
            if (dizimistaService.findByCode(Long.valueOf(id)).isPresent()) {
                Dizimista dizimista1 = dizimistaService.findByCode(Long.valueOf(id)).get();
                dizimista.setCod(dizimista1.getCod());
                dizimista.setNome(dizimista1.getNome());
            }
        }

        else if (searchBy.isEmpty() || searchBy.isBlank()) {
            Optional<Dizimista> dizimistaServiceById = dizimistaService.findById(Long.valueOf(id));
            if (dizimistaServiceById.isPresent()) {
                dizimista.setCod(dizimistaServiceById.get().getCod());
                dizimista.setNome(dizimistaServiceById.get().getNome());
            }
        }

        byte[] generatedPDF = generatePDF(String.valueOf(dizimista.getCod()), dizimista.getNome());
        String base64String = Base64.getEncoder().encodeToString(generatedPDF);
        String nameFile = String.valueOf(dizimista.getCod()) + " - " + dizimista.getNome() + " - " + String.valueOf(LocalDate.now().getYear()) + ".pdf";

        return ResponseEntity.ok(new PDFResponseDTO(base64String, nameFile, MediaType.APPLICATION_PDF_VALUE));

//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + nameFile + "\"")
//                .body(generatedPDF);

    }
}
