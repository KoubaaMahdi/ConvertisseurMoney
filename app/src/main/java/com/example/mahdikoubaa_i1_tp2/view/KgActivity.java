package com.example.mahdikoubaa_i1_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mahdikoubaa_i1_tp2.R;
import com.example.mahdikoubaa_i1_tp2.controller.ControllerKG;

public class KgActivity extends AppCompatActivity {
    private EditText txtKG;
    private Button btnConver;
    private TextView txtLB;

    //instanciation du contrôleur pour le modèle Kg
    ControllerKG controller=ControllerKG.getInsatance();

    //méthode pour initialiser les composants de l'interface graphique
    private void init(){
        //liaison entre les instances des objets Java et les composants de l'interface graphique XML
        txtKG=(EditText)findViewById(R.id.txtKG);//findViewById retourne un View donc il faut la convertir (cast) en EditText
        btnConver=(Button)findViewById(R.id.button_Poid);
        txtLB=(TextView) findViewById(R.id.txtLB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kg);
        init();//appel de la méthode pour initialiser les composants de l'interface graphique
        btnConver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // appel de la méthode de conversion
                convertir();
            }
        });
    }

    //méthode de conversion pour passer des kilogrammes aux LB
    private void convertir()
    {
        Double PoidKG = null;
        try
        {
            //Récupération du texte de la masse en kilogrammes avec getText()
            PoidKG = Double.parseDouble(txtKG.getText().toString());
        }
        catch (Exception e){ } // Pour ne pas se planter

        //user action + update du modèle
        controller.createModel(PoidKG);

        //affichage du résultat de la conversion en LB
        txtLB.setText(Double.toString(controller.getLB()));
    }
}
