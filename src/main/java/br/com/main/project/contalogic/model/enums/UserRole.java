package br.com.main.project.contalogic.model.enums;

public enum UserRole {

    OPERACIONAL("OPERACIONAL"),
    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}
