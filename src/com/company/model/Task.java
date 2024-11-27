package com.company.model;

import com.company.enums.Priority;
import com.company.enums.Status;

public class Task {

    private int id;
    private String title;
    private String description;
    private String maturity;
    private Priority priority;
    private Status status;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Task(int id, String title, String description, String maturity, Priority priority, Status status){
        this.id = id;
        this.title = title;
        this.description = description;
        this.maturity = maturity;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public String toString(){
        return String.format("ID: %d | Título: %s | Descrição: %s | Data de Vencimento: %s | Prioridade: %s | Status: %s",
                id, title, description, maturity, priority, status);
    }

}
