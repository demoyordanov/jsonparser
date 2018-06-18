package com.packag.yvyor.jsonparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    Button click;
    public  static TextView data;
    public static TextView weatherData;
    public static Spinner dropdown;
    public static Spinner dropdown2;
    public static String[] items;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.fetcheddata);
        weatherData = findViewById(R.id.weatherData);
        dropdown = findViewById(R.id.spinnerBase);
        dropdown2 = findViewById(R.id.spinnerTarget);
        items = new String[]{"EUR", "USD", "CNY", "JPY", "KRW", "HKD", "CHF"};

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData process = new fetchData();
                process.execute();
            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown2.setAdapter(adapter);

    }
}