package br.com.pdro.psj.cardizpsj.model.dto;

public class DizimistaRequestDTO {

    private Long code;
    private String name;

    public DizimistaRequestDTO(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public DizimistaRequestDTO() {
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
        return "DizimistaRequestDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
