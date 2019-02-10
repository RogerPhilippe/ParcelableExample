package br.com.philippesis.parcelableexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(intent.hasExtra("pessoa")) {
            Pessoa p = intent.getParcelableExtra("pessoa");
            p.calculaIdade();

            TextView txtIdade = findViewById(R.id.id_text_idade);
            txtIdade.setText(p.toString());

        }

    }
}
