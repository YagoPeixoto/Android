package yago.br.aulaead;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ligarNum(View v) {
        Uri tel = Uri.parse("tel:64984278985");
        Intent it = new Intent(Intent.ACTION_CALL, tel);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(it);

    }

    public void abrirNavegador(View v) {
        Uri url = Uri.parse("https://github.com/YagoPeixoto");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }

    public void buscarContato(View v){
        Uri cont = Uri.parse("content://com.android.contacts/contacts/");
        Intent it = new Intent(Intent.ACTION_VIEW,cont);
        startActivity(it);
    }

    public void abrirMapa(View v) {
        Uri url = Uri.parse("https://www.google.com.br/maps/place/Instituto+Federal+Goiano+-+Campus+Morrinhos/@-17.8125682,-49.2061517,17z/data=!3m1!4b1!4m5!3m4!1s0x94a08d5147522729:0x6a8c62846c14a27d!8m2!3d-17.8125682!4d-49.2039576");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }

    public void fazerPesquisa(View v) {

        TextView pesquisa = (TextView) findViewById(R.id.fazerPesquisa);
        String url = "http://www.google.com/#q=";
        String query = pesquisa.getText().toString().replace(" ", "+").trim();
        String final_url = url + query;
        Uri uri = Uri.parse(final_url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));

    }

    public void abrirCamera(View v) {
        File picsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File imageFile = new File(picsDir, "biirrl.jpg");
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        it.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));
        startActivity(it);

    }
}
