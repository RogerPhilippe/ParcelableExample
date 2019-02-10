package br.com.philippesis.parcelableexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private int ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editNome = findViewById(R.id.id_edit);
        final CalendarView calendarView = findViewById(R.id.id_calendar);
        Button btnVerificar = findViewById(R.id.id_btn_verificar);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                ano = year;
            }
        });

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pessoa p = new Pessoa(editNome.getText().toString(), ano);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("pessoa", p);

                startActivity(intent);

            }
        });

    }
}
