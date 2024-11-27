package com.company.enums;

public enum Priority {
    ALTA("alta"),
    MEDIA("média"),
    BAIXA("baixa");

    private final String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    // Método para verificar se a prioridade é válida
    public static Priority fromString(String priority) {
        for (Priority p : Priority.values()) {
            if (p.getPriority().equalsIgnoreCase(priority)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida: " + priority);
    }
}
