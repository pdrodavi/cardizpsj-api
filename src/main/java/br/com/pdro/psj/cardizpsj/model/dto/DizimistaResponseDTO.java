package br.com.pdro.psj.cardizpsj.model.dto;

public class DizimistaResponseDTO {

    private Long code;
    private String name;

    public DizimistaResponseDTO() {
    }

    public DizimistaResponseDTO(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DizimistaResponseDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
