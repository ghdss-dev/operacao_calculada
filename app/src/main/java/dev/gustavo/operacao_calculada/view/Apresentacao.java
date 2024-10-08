package dev.gustavo.operacao_calculada.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dev.gustavo.operacao_calculada.R;
import dev.gustavo.operacao_calculada.view.fisica.Menu_Fisica;
import dev.gustavo.operacao_calculada.view.matematica.Menu_Matematica;
import dev.gustavo.operacao_calculada.view.quimica.Menu_Quimica;

public class Apresentacao extends AppCompatActivity {

    Button btn_matematica;

    Button btn_fisica;

    Button btn_quimica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);

        btn_matematica = findViewById(R.id.btn_matematica);

        btn_fisica = findViewById(R.id.btn_fisica);

        btn_quimica = findViewById(R.id.btn_quimica);

        btn_matematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent intent = new Intent(Apresentacao.this, Menu_Matematica.class);
                    startActivity(intent);

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
        });

        btn_fisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent intent = new Intent(Apresentacao.this, Menu_Fisica.class);
                    startActivity(intent);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });

        btn_quimica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent intent = new Intent(Apresentacao.this, Menu_Quimica.class);
                    startActivity(intent);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });

    }
}