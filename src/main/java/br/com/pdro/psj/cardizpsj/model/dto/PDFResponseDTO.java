package br.com.pdro.psj.cardizpsj.model.dto;

public class PDFResponseDTO {

    private String bytes;
    private String name;
    private String contentType;

    public PDFResponseDTO(String bytes, String name, String contentType) {
        this.bytes = bytes;
        this.name = name;
        this.contentType = contentType;
    }

    public PDFResponseDTO() {
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "PDFResponseDTO{" +
                "bytes='" + bytes + '\'' +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
