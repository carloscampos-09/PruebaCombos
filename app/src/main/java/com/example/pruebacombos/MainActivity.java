package com.example.pruebacombos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner lista;
    ArrayList<String> listaDatos;
    LinearLayout salida;
    Button terminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (Spinner) findViewById(R.id.lista);
        salida = (LinearLayout) findViewById(R.id.salidaDatos);
        terminar = (Button) findViewById(R.id.terminar);

        llenarDatos();

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listaDatos);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista.setAdapter(spinnerArrayAdapter);

        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                i = i -1;
                if(i == 1){
                    EditText edtText = new EditText(getApplicationContext());
                    edtText.setId(R.id.textoUno);
                    edtText.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,0f));
                    edtText.setInputType(InputType.TYPE_CLASS_TEXT);
                    edtText.setHint("Escriba Texto");
                    salida.addView(edtText);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salidaDatos();
            }
        });


    }

    private void salidaDatos() {
        EditText text = (EditText) findViewById(R.id.textoUno);
        System.out.println("La salida es:" + text.getText().toString());

    }

    private void llenarDatos() {
        listaDatos = new ArrayList<String>();
        listaDatos.add("Seleccione");
        listaDatos.add("No muestra");
        listaDatos.add("Si muestra");
    }
}
