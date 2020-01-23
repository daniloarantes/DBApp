package com.arantes.danilo.dbapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonCadastrar;
    private Button buttonVisualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        buttonVisualizar = (Button) findViewById(R.id.buttonVisualizar);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityCadastro.class);
                startActivity(intent);
            }
        });

        buttonVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityVisualiza.class);
                startActivity(intent);
            }
        });

    }
}
