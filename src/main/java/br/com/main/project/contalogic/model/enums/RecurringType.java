package br.com.main.project.contalogic.model.enums;

public enum RecurringType {

    ANUAL("ANUAL"),
    MENSAL("MENSAL"),
    TRIMESTRAL("TRIMESTRAL");

    private String recurring;

    RecurringType(String recurring) {
        this.recurring = recurring;
    }
}
