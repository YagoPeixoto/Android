package yago.br.crudandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
    }

    public void cadastrar(View v){

        EditText campoNome = (EditText) findViewById(R.id.campoNome);
        EditText campoSenha = (EditText) findViewById(R.id.campoSenha);
        EditText campoCPF = (EditText) findViewById(R.id.campoCPF);
        EditText campoTelefone = (EditText) findViewById(R.id.campoTelefone);
        EditText campoData = (EditText) findViewById(R.id.campoData);

        String nome = campoNome.getText().toString();
        String senha = campoSenha.getText().toString();
        String cpf = campoCPF.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String data = campoData.getText().toString();

        Usuario usuario = new Usuario(nome, senha, cpf, telefone, data);

        UsuarioDAO userDao = new UsuarioDAO(CadastrarUsuario.this);

        int boo = userDao.inserirUser(usuario);

        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        if(boo == 1){
            String texto = "Sucesso ao cadastrar";
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
            finish();
        }else{
            String texto = "Falha no cadastro";
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }


    }




    public void fechar(View v){
        finish();
    }


}
