package com.example.vinic.gas_piloto;

public class Pedido {
    private String status;
    private String id;

    public Pedido(String id,String status) {
        this.status = status;
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
