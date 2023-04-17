package com.example.mahdikoubaa_i1_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mahdikoubaa_i1_tp2.R;
import com.example.mahdikoubaa_i1_tp2.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private EditText txtTND;
    private Button btnConvert;
    private TextView lbEUR,lbUSD,lbGBP;
    Controller controller=Controller.getInsatance();
    private void init(){
        txtTND=(EditText)findViewById(R.id.txtTND);//findViewById retourne un view donc il faut la convertir(cast) en edit text
        btnConvert=(Button)findViewById(R.id.button_id);//pas utiliser dans cas listener implicite(utiliser pour explicite)
        lbEUR=(TextView) findViewById(R.id.txtEUR);
        lbUSD=(TextView) findViewById(R.id.txtUSD);
        lbGBP=(TextView) findViewById(R.id.txtGBP);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();//liaison entre les instance des java et les composants de xml: alors chaque changement de content va etre envoyer au context et vise versa
    }
    private void convert()
    {

        Double dinar = null;
        try
        {
//Récupération du texte du montant en TND avec getText()
            dinar = Double.parseDouble(txtTND.getText().toString());
        }
        catch (Exception e){ } // Pour ne pas se planter

        //user action + update du model
        controller.createModel(dinar);

        /*Double euro, usd, gbp;
        euro = dinar / 3.3360;
        usd = dinar / 3.7830;
        gbp = dinar / 3.1130; pas dans MVC*/
        //Mise à jour des TextView lbEUR, lbUSD, lbGBP
        lbEUR.setText(Double.toString(controller.getEuro()));
        lbUSD.setText(Double.toString(controller.getUsd()));
        lbGBP.setText(Double.toString(controller.getGbp()));// notify view
    }
}