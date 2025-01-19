package br.com.main.project.contalogic.model.enums;

public enum ExtensionType {

    PDF("PDF"),
    XLSX("XLSX"),
    DOCX("DOCX");

    private String extension;

    ExtensionType(String extension) {
        this.extension = extension;
    }
}
