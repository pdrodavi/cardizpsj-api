package br.com.pdro.psj.cardizpsj.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "dizimistas", schema = "psj")
public class Dizimista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cod;
    private String nome;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Dizimista{" +
                "id=" + id +
                ", cod=" + cod +
                ", nome='" + nome + '\'' +
                '}';
    }
}
