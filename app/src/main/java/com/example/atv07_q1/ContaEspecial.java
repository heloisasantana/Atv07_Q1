package com.example.atv07_q1;

public class ContaEspecial extends ContaBancaria {
    private float limite;

    public ContaEspecial(String cliente, int num_conta, float saldoInicial, float limite) {
        super(cliente, num_conta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(float valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

