package com.kevali.doldimeter04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class alcActivity extends AppCompatActivity {
        EditText nrBier;
        EditText nrWein;
        EditText nrSchnaps;
        EditText kgGewicht;
       // EditText geschlecht;
        float mFaktor = (float) 0.68;
        float fFaktor = (float) 0.55;
        TextView totalPromille;

    String[] sexs = {"maennlich", "weiblich"};

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alc);
    }

    public void calcPromille(View v){
        totalPromille = (TextView) findViewById(R.id.promilleOutput);

        nrBier = (EditText) findViewById(R.id.bierInput);
        nrWein = (EditText) findViewById(R.id.weinInput);;
        nrSchnaps = (EditText) findViewById(R.id.schnapsInput);;
        kgGewicht = (EditText) findViewById(R.id.gewichtInput);;
        //geschlecht = (EditText) findViewById(R.id.geschlechtInput);;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, sexs);

        //Find TextView control
        AutoCompleteTextView geschlecht = (AutoCompleteTextView) findViewById(R.id.sex);
        //Set the number of characters the user must type before the drop down list is shown
        geschlecht.setThreshold(1);
        //Set the adapter
        geschlecht.setAdapter(adapter);

        float AnzahlBier = Float.parseFloat(nrBier.getText().toString());
        float AnzahlWein = Float.parseFloat(nrWein.getText().toString());
        float AnzahlSchnaps = Float.parseFloat(nrSchnaps.getText().toString());
        float promille = (float) 0;
        float gewicht = Float.parseFloat(kgGewicht.getText().toString());


        // Integer.parseInt(geschlecht.getText().toString());

        float gramm = AnzahlBier * (float) 12.7 + AnzahlWein * (float) 8.8 + AnzahlSchnaps * (float) 6.1;

        if (geschlecht.getText().toString().equals("maennlich")) {
            promille = gramm / (gewicht * mFaktor);
            totalPromille.setText(Float.toString(promille));
        } else if (geschlecht.getText().toString().equals("weiblich")) {
            promille = gramm / (gewicht * fFaktor);
            totalPromille.setText(Float.toString(promille));
        } else {
            totalPromille.setText(Integer.toString(666));
        }

        if (promille > 1.0f & promille < 1.9f){
            Intent intent = new Intent(this, besoffenActivity.class);
            startActivity(intent);
        }
        else if (promille > 1.9f)
        {
            Intent intent = new Intent(this, doldiActivity.class);
            startActivity(intent);
        }
    }

    /*public void calcPromille (View v){
        float AnzahlBier = Float.parseFloat(nrBier.getText().toString());
        float AnzahlWein = Float.parseFloat(nrWein.getText().toString());
        float AnzahlSchnaps = Float.parseFloat(nrSchnaps.getText().toString());
        float promille = (float) 0;
        float gewicht = Float.parseFloat(kgGewicht.getText().toString());
        int mf = Integer.parseInt(geschlecht.getText().toString());

        float gramm = AnzahlBier * (float) 12.7 + AnzahlWein * (float) 8.8 + AnzahlSchnaps * (float) 6.1;

        if (mf == 1) {
            promille = gramm / (gewicht * mFaktor);
            totalPromille.setText(Float.toString(promille));
        } else if (mf == 2) {
            promille = gramm / (gewicht * fFaktor);
            totalPromille.setText(Float.toString(promille));
        } else {
            totalPromille.setText(Integer.toString(666));
        }
    }*/
}
