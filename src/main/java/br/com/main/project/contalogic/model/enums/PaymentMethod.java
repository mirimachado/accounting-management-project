package br.com.main.project.contalogic.model.enums;

public enum PaymentMethod {

    PIX("PIX"),
    BOLETO("BOLETO"),
    ESPECIE("ESPECIE");

    private String method;

    PaymentMethod(String method) {
        this.method = method;
    }
}
