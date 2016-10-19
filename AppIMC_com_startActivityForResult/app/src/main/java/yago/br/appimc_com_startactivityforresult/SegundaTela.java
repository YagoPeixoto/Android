package yago.br.appimc_com_startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;


public class SegundaTela extends AppCompatActivity  {

    Double valorPeso, ValorAltura, imcCalculado;
    String nomeUsuario, telefoneUsuario, emailUsuario, pesoUsuario, alturaUsuario;
    String imcString;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Intent it = getIntent();
        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {

                nomeUsuario = params.getString("nomeUser");
                telefoneUsuario = params.getString("telefoneUser");
                emailUsuario = params.getString("emailUser");
                pesoUsuario = params.getString("pesoUser");
                alturaUsuario = params.getString("alturaUser");

                TextView nome = (TextView) findViewById(R.id.nome);
                TextView telefone = (TextView) findViewById(R.id.telefone);
                TextView email = (TextView) findViewById(R.id.email);
                TextView peso = (TextView) findViewById(R.id.peso);
                TextView altura = (TextView) findViewById(R.id.altura);

                nome.setText(nomeUsuario);
                telefone.setText(telefoneUsuario);
                email.setText(emailUsuario);
                peso.setText(pesoUsuario);
                altura.setText(alturaUsuario);

                valorPeso = Double.parseDouble(peso.getText().toString());
                ValorAltura = Double.parseDouble(altura.getText().toString());

                imcCalculado = valorPeso /(ValorAltura * ValorAltura);

                imcString = String.valueOf(imcCalculado);

            }
        }
    }
    public void calcularIMC(View v) {
        Intent it = new Intent();
        it.putExtra("imc", imcString);
        setResult(1,it);
        finish();
    }
}