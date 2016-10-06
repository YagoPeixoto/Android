package yago.br.appimc_com_startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;

public class TerceiraTela extends AppCompatActivity{
    String classeIMC;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);

        Intent intent = getIntent();
        if (intent != null) {
            String imcUsuario = intent.getStringExtra("imcUser");

            Double resultado = Double.parseDouble(imcUsuario.toString());

            DecimalFormat fmt = new DecimalFormat("0.00");
            String editado = fmt.format(resultado);

            if(resultado < 16) {
                classeIMC = "Magreza Grave";
            }
            if(resultado >= 16 && resultado < 17){
                classeIMC = "Magreza Moderada";
            }
            if(resultado >= 17 && resultado < 18.5){
                classeIMC = "Magreza Leve";
            }
            if(resultado >= 18.5 && resultado < 25){
                classeIMC = "Saudável";
            }
            if(resultado >= 25 && resultado < 30){
                classeIMC = "Sobrepeso";
            }
            if(resultado >= 30 && resultado < 35){
                classeIMC = "Obesidade Grau I";
            }
            if(resultado >= 35 && resultado < 40){
                classeIMC = "Obesidade Grau II (severa)";
            }
            if(resultado >= 40){
                classeIMC = "Obesidade Grau III (mórbida)";
            }

            TextView resultimc = (TextView) findViewById(R.id.resultimc);
            TextView classIMC = (TextView) findViewById(R.id.classIMC);

            resultimc.setText(String.format(editado));
            classIMC.setText(String.format(classeIMC));

        }
    }
    public void onClick(View view) {
        Intent it2 = new Intent(TerceiraTela.this,MainActivity.class);
        startActivity(it2);
        finish();
    }
}