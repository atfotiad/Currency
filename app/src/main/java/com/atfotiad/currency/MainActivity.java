package com.atfotiad.currency;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String from;
    private String to;
    private String str;
    private Double totalDouble;
    private String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner1 = findViewById(R.id.spinner1);
        Button button = findViewById(R.id.button);
        final TextView textView = findViewById(R.id.result);
        final TextInputEditText textInputEditText = findViewById(R.id.amount);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currency,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = textInputEditText.getText().toString();
                double amount = Double.parseDouble(str);

                switch (from){
                    case "Dollar":
                        switch (to){
                            case "Euro":
                                totalDouble = amount * 0.87359973;
                                break;
                            case "Pound":
                                totalDouble = amount * 0.7889552575;
                                break;
                        }
                        break;
                    case "Pound":
                        switch (to){
                            case "Dollar":
                                totalDouble = amount * 1.268625;
                                break;
                            case "Euro":
                                totalDouble = amount * 1.10747 ;
                                break;
                        }
                        break;
                    case "Euro":
                        switch (to){
                            case "Dollar":
                                totalDouble = amount * 1.144689;
                                break;
                            case "Pound":
                                totalDouble = amount *0.903108405 ;
                                break;
                        }
                        break;

                }
                result = String.format("%.2f",totalDouble);
                switch (to){
                    case "Dollar":
                        textView.setText(result + " $");
                        break;
                    case "Pound":
                        textView.setText(result + " £");
                        break;
                    case "Euro":
                        textView.setText(result + " €");
                        break;
                }

            }
        });

    }
}
