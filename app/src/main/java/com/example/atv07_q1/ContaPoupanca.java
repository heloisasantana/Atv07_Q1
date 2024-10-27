package com.example.atv07_q1;

public class ContaPoupanca extends ContaBancaria {
    private int diaDeRendimento;

    public ContaPoupanca(String cliente, int num_conta, float saldoInicial, int diaDeRendimento) {
        super(cliente, num_conta, saldoInicial);
        this.diaDeRendimento = diaDeRendimento;
    }

    public void calcularNovoSaldo(float taxaRendimento) {
        saldo += saldo * (taxaRendimento / 100);
    }
}
