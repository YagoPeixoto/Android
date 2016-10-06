package yago.br.appimc_com_startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public static final int CodigoIntent = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String nomeUsuario, telefoneUsuario, emailUsuario, pesoUsuario, alturaUsuario;

    public void enviarDados(View v) {

        EditText nome = (EditText) findViewById(R.id.nome);
        EditText telefone = (EditText) findViewById(R.id.telefone);
        EditText email = (EditText) findViewById(R.id.email);
        EditText peso = (EditText) findViewById(R.id.peso);
        EditText altura = (EditText) findViewById(R.id.altura);

        nomeUsuario = nome.getText().toString();
        telefoneUsuario = telefone.getText().toString();
        emailUsuario = email.getText().toString();
        pesoUsuario = peso.getText().toString();
        alturaUsuario = altura.getText().toString();


        Intent it = new Intent(MainActivity.this, SegundaTela.class);
        Bundle params = new Bundle();
        params.putString("nomeUser", nomeUsuario);
        params.putString("telefoneUser", telefoneUsuario);
        params.putString("emailUser", emailUsuario);
        params.putString("pesoUser", pesoUsuario);
        params.putString("alturaUser", alturaUsuario);

        it.putExtras(params);
        startActivityForResult(it, CodigoIntent);
    }


    protected void onActivityResult(int codigoIntent, int result, Intent it) {
        Bundle resultado = it.getExtras();
        String imc = resultado.getString("imc");

        Intent intent = new Intent(this, TerceiraTela.class);
        intent.putExtra("imcUser", imc);
        startActivity(intent);
    }
}