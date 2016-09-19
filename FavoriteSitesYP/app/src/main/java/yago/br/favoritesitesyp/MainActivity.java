package yago.br.favoritesitesyp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void site1(View v) {
        Uri url = Uri.parse("http://manualdohomemmoderno.com.br/");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }
    public void site2(View v) {
        Uri url = Uri.parse("http://www.elhombre.com.br/");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }
    public void site3(View v) {
        Uri url = Uri.parse("http://www.hipertrofia.org/blog/");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }
    public void site4(View v) {
        Uri url = Uri.parse("http://www.tecmundo.com.br/");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }
    public void site5(View v) {
        Uri url = Uri.parse("https://www.ifgoiano.edu.br/home/index.php/morrinhos");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }
    public void site6(View v) {
        Uri url = Uri.parse("http://olhardigital.uol.com.br/");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }
}
