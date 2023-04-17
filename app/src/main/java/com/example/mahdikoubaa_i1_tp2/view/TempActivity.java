package com.example.mahdikoubaa_i1_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mahdikoubaa_i1_tp2.R;
import com.example.mahdikoubaa_i1_tp2.controller.Controller;
import com.example.mahdikoubaa_i1_tp2.controller.ControllerTemp;

public class TempActivity extends AppCompatActivity {
    private EditText txtC;
    private Button btnConver;
    private TextView txtF;
    ControllerTemp controller=ControllerTemp.getInsatance();
    private void init(){
        txtC=(EditText)findViewById(R.id.txtC);//findViewById retourne un view donc il faut la convertir(cast) en edit text
        btnConver=(Button)findViewById(R.id.button_Temp);//pas utiliser dans cas listener implicite(utiliser pour explicite)
        txtF=(TextView) findViewById(R.id.txtF);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        init();//liaison entre les instance des java et les composants de xml: alors chaque changement de content va etre envoyer au context et vise versa
        btnConver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call your function here
                convertir();
            }
        });
    }
    private void convertir()
    {

        Double TempC = null;
        try
        {
//Récupération du texte du montant en TND avec getText()
            TempC = Double.parseDouble(txtC.getText().toString());
        }
        catch (Exception e){ } // Pour ne pas se planter

        //user action + update du model
        controller.createModel(TempC);

        /*Double euro, usd, gbp;
        euro = dinar / 3.3360;
        usd = dinar / 3.7830;
        gbp = dinar / 3.1130; pas dans MVC*/
        //Mise à jour des TextView lbEUR, lbUSD, lbGBP
        txtF.setText(Double.toString(controller.getNewTemp()));

    }
}