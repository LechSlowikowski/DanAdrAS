package com.example.danadras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /********************************************************
     * nazwa funkcji: onCreate
     * parametry wejściowe: savedInstanceState - parametry uruchmieniowe
     * wartość zwracana: void
     * opis: metoda uruchamiająca aplikację
     * autor: 12345678901
     * ****************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /********************************************************
     * nazwa funkcji: zatwierdz
     * parametry wejściowe: view - widok który wywołał akcję onClick
     * wartość zwracana: brak
     * opis: obsługa wybrania przycisku
     * autor: 12345678901
     * ****************************************************/
    public void zatwierdz(View view) {
        String komunikatStr = "";
        EditText imie = (EditText) findViewById(R.id.imie);
        String imieStr = imie.getText().toString();

        EditText nazwisko = (EditText) findViewById(R.id.nazwisko);
        String nazwiskoStr = nazwisko.getText().toString();

        EditText miasto = (EditText) findViewById(R.id.miasto);
        String miastoStr = miasto.getText().toString();

        EditText telefon = (EditText) findViewById(R.id.telefon);
        String telefonStr = telefon.getText().toString();

        TextView komunikat = (TextView) findViewById(R.id.komunikat);

        if(imieStr.charAt(0) != imieStr.toUpperCase().charAt(0)){
            imieStr = imieStr.toUpperCase().charAt(0) + imieStr.substring(1);
            imie.setText(imieStr);
        }

        if(nazwiskoStr.charAt(0) != nazwiskoStr.toUpperCase().charAt(0)){
            nazwiskoStr =  nazwiskoStr.toUpperCase().charAt(0) + nazwiskoStr.substring(1);
            nazwisko.setText(nazwiskoStr);
        }

        if(!(miastoStr.equals("Gdańsk") || miastoStr.equals("Gdynia") || miastoStr.equals("Sopot"))){
            komunikatStr = "Nieprawidłowe miasto ";
        }

        if(telefonStr.length() > 9){
            komunikatStr += "Za długi numer telefonu";
        } else
        if(telefonStr.length() < 9){
            komunikatStr += "Za krótki numer telefonu";
        }

        if(komunikatStr.length()==0) komunikatStr = "Witaj " + imieStr + " " + nazwiskoStr;

        komunikat.setText(komunikatStr);
    }
}