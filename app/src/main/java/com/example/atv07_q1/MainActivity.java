package com.example.atv07_q1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/*
 *@author:Heloísa Santana da Silva
 */


public class MainActivity extends AppCompatActivity {

    private EditText editTextValor;
    private TextView textViewResultado;
    private RadioGroup radioGroupTipoConta;

    private ContaPoupanca contaPoupanca;
    private ContaEspecial contaEspecial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor = findViewById(R.id.editTextValor);
        textViewResultado = findViewById(R.id.textViewResultado);
        radioGroupTipoConta = findViewById(R.id.radioGroupTipoConta);

        Button buttonSacar = findViewById(R.id.buttonSacar);
        Button buttonDepositar = findViewById(R.id.buttonDepositar);
        Button buttonCalcularRendimento = findViewById(R.id.buttonCalcularRendimento);
        Button buttonMostrarDados = findViewById(R.id.buttonMostrarDados);

        contaPoupanca = new ContaPoupanca("Cliente Poupança", 123, 1000, 15);
        contaEspecial = new ContaEspecial("Cliente Especial", 456, 1000, 500);

        buttonSacar.setOnClickListener(v -> realizarSaque());
        buttonDepositar.setOnClickListener(v -> realizarDeposito());
        buttonCalcularRendimento.setOnClickListener(v -> calcularRendimento());
        buttonMostrarDados.setOnClickListener(v -> mostrarDadosConta());
    }

    private void realizarSaque() {
        float valor = Float.parseFloat(editTextValor.getText().toString());
        boolean sucesso;

        if (isContaPoupancaSelecionada()) {
            sucesso = contaPoupanca.sacar(valor);
        } else {
            sucesso = contaEspecial.sacar(valor);
        }

        if (sucesso) {
            mostrarMensagem("Saque realizado com sucesso!");
        } else {
            mostrarMensagem("Saldo insuficiente!");
        }
    }

    private void realizarDeposito() {
        float valor = Float.parseFloat(editTextValor.getText().toString());

        if (isContaPoupancaSelecionada()) {
            contaPoupanca.depositar(valor);
        } else {
            contaEspecial.depositar(valor);
        }

        mostrarMensagem("Depósito realizado com sucesso!");
    }

    private void calcularRendimento() {
        if (isContaPoupancaSelecionada()) {
            contaPoupanca.calcularNovoSaldo(0.5f);
            mostrarMensagem("Rendimento calculado para Conta Poupança!");
        } else {
            mostrarMensagem("Conta Especial não possui rendimento.");
        }
    }

    private void mostrarDadosConta() {
        String dados;
        if (isContaPoupancaSelecionada()) {
            dados = contaPoupanca.getDados();
        } else {
            dados = contaEspecial.getDados();
        }
        textViewResultado.setText(dados);
    }

    private boolean isContaPoupancaSelecionada() {
        RadioButton radioContaPoupanca = findViewById(R.id.radioContaPoupanca);
        return radioContaPoupanca.isChecked();
    }

    private void mostrarMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
