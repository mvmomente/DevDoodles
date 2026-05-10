package com.mvmomente.naopago.entity;

import java.util.UUID;

public class Conta {
    private String id;
    private String nome;
    private String senha;
    private double saldo;

    public Conta() {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this. saldo = 0;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
