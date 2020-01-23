package com.arantes.danilo.dbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCadastro extends AppCompatActivity implements View.OnClickListener {

    private EditText eTNome;
    private EditText eTEmail;
    private EditText eTTelefone;
    private Button buttonExcluir;
    private Button buttonCadastrar;
    private Button buttonCancelar;

    private final Usuario usuario = new Usuario(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        eTNome = (EditText) findViewById(R.id.eTNome);
        eTEmail = (EditText) findViewById(R.id.eTEmail);
        eTTelefone = (EditText) findViewById(R.id.eTTelefone);
        buttonExcluir = (Button) findViewById(R.id.buttonExcluir);
        buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        buttonCancelar = (Button) findViewById(R.id.buttonCancelar);

        buttonExcluir.setOnClickListener(this);
        buttonCadastrar.setOnClickListener(this);
        buttonCancelar.setOnClickListener(this);



        if(getIntent().getExtras() != null){
            setTitle(getString(R.string.titulo_editando));
            int codigo = getIntent().getExtras().getInt("consulta");
            usuario.pesquisaUsuario(codigo);

            eTNome.setText(usuario.getNome().toString());
            eTEmail.setText(usuario.getEmail().toString());
            eTTelefone.setText(usuario.getTelefone().toString());


        }else {
            setTitle(getString(R.string.titulo_incluindo));
        }

        buttonExcluir.setEnabled(true);
        if (usuario.getCodigo() == -1)
            buttonExcluir.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonExcluir: {
                usuario.Excluir();
                finish();
                break;
            }
            case R.id.buttonCadastrar : {
                boolean valido = true;
                usuario.setNome(eTNome.getText().toString());
                usuario.setEmail(eTEmail.getText().toString());
                usuario.setTelefone(eTTelefone.getText().toString());

                if(usuario.getNome().equals("")){
                    eTNome.setError(getString(R.string.obrigatorio));
                    valido = false;
                }
                if(usuario.getEmail().equals("")){
                    eTEmail.setError(getString(R.string.obrigatorio));
                    valido = false;
                }
                if(usuario.getTelefone().equals("")){
                    eTTelefone.setError(getString(R.string.obrigatorio));
                    valido = false;
                }

                if(valido){
                    usuario.Salvar();
                    finish();
                }
                break;
            }
            case R.id.buttonCancelar : {
                finish();
                break;
            }
        }

    }
}
