package yago.br.crudandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BuscarUsuarioEspecifico extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_usuario_especifico);
    }

    public void voltar(View v){
        finish();
    }

    public void buscarUsuario(View v){

        EditText edtNome = (EditText) findViewById(R.id.buscaNomeCampo);

        String nome = edtNome.getText().toString();

        UsuarioDAO userDao = new UsuarioDAO(BuscarUsuarioEspecifico.this);

        this.user = userDao.getByName(nome);

        TextView tvNome = (TextView) findViewById(R.id.txtNome);
        TextView tvId = (TextView) findViewById(R.id.txtID);
        TextView tvCPF = (TextView) findViewById(R.id.txtCPF);
        TextView tvData = (TextView) findViewById(R.id.txtDataNascimento);

        tvNome.setText(user.getNome());
        tvId.setText(String.valueOf(user.getId()));
        tvCPF.setText(user.getCpf());
        tvData.setText(user.getDataNascimento());
    }
    public void apagarUser(View v){

        UsuarioDAO userDao = new UsuarioDAO(BuscarUsuarioEspecifico.this);
        userDao.deleteUser(user.getId());
        finish();

    }

    public void updateUser(View v){

        TextView actNome = (TextView) findViewById(R.id.upNome);
        TextView actSenha = (TextView) findViewById(R.id.upSenha);

        user.setNome(actNome.getText().toString());
        user.setSenha(actSenha.getText().toString());

        UsuarioDAO userDao = new UsuarioDAO(BuscarUsuarioEspecifico.this);

        userDao.updateUser(user.getId(), user.getNome(), user.getSenha());

    }
}

