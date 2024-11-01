package br.com.pdro.psj.cardizpsj.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "entradas", schema = "psj")
public class Entradas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cod_dizimista")
    private Long codDizimista;
    @Column(name = "valor_pgto")
    private Double valorPgto;
    @Column(name = "data_pgto")
    private LocalDate dataPgto;
    @Column(name = "data_ref")
    private LocalDateTime dataRef;
    @Column(name = "nome")
    private String nome;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodDizimista() {
        return codDizimista;
    }

    public void setCodDizimista(Long codDizimista) {
        this.codDizimista = codDizimista;
    }

    public Double getValorPgto() {
        return valorPgto;
    }

    public void setValorPgto(Double valorPgto) {
        this.valorPgto = valorPgto;
    }

    public LocalDate getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(LocalDate dataPgto) {
        this.dataPgto = dataPgto;
    }

    public LocalDateTime getDataRef() {
        return dataRef;
    }

    public void setDataRef(LocalDateTime dataRef) {
        this.dataRef = dataRef;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
