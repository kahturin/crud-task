package com.company.enums;

public enum Status {
    A_FAZER("a fazer"),
    PENDENTE("pendente"),
    FEITO("feito");

    private final String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public static Status fromString(String status){
        for (Status s : Status.values()){
            if(s.getStatus().equalsIgnoreCase(status)){
                return s;
            }
        }
        throw new IllegalArgumentException("Status inválido " + status);
    }
}
