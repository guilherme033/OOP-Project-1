package com.example.poolabac1.Model;

public class Pedido {
    
    private int codigo;
    private double valor;
    private String descricao;
    private String cliente;
    private String data;

    public int getId() {
        return codigo;
    }

    public void setID(int id) {
        this.codigo = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }  

    public String getData() {
      return data;
    }

    public void setData(String data) {
        this.data = data;
    }  
}
