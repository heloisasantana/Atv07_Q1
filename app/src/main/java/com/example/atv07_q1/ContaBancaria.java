package com.example.atv07_q1;

public class ContaBancaria {
    protected String cliente;
    protected int num_conta;
    protected float saldo;

    public ContaBancaria(String cliente, int num_conta, float saldoInicial) {
        this.cliente = cliente;
        this.num_conta = num_conta;
        this.saldo = saldoInicial;
    }

    public boolean sacar(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(float valor) {
        saldo += valor;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getDados() {
        return "Cliente: " + cliente + "\nConta: " + num_conta + "\nSaldo: " + saldo;
    }
}

