package com.example.mahdikoubaa_i1_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mahdikoubaa_i1_tp2.R;
import com.example.mahdikoubaa_i1_tp2.controller.ControllerMI;

public class MiActivity extends AppCompatActivity {
    private EditText txtCM;
    private Button btnConver;
    private TextView txtINCH;
    ControllerMI controller=ControllerMI.getInsatance(); // Création d'une instance du ControllerMI
    private void init(){
        txtCM=(EditText)findViewById(R.id.txtCM);// findViewById retourne un view donc il faut la convertir (cast) en EditText
        btnConver=(Button)findViewById(R.id.button_MI);
        txtINCH=(TextView) findViewById(R.id.txtINCH);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi);
        init(); // Initialisation des composants graphiques
        btnConver.setOnClickListener(new View.OnClickListener() { // Ajout d'un listener sur le bouton de conversion
            @Override
            public void onClick(View v) {
                // Appel de la fonction de conversion
                convertir();
            }
        });
    }

    private void convertir()
    {
        Double DistCM = null;
        try
        {
            // Récupération de la valeur du champ de texte correspondant à la distance en cm
            DistCM = Double.parseDouble(txtCM.getText().toString());
        }
        catch (Exception e){ } // Pour ne pas se planter

        // Mise à jour du modèle avec la distance en cm
        controller.createModel(DistCM);

        // Affichage du résultat de la conversion dans le champ de texte correspondant à la distance en pouces
        txtINCH.setText(Double.toString(controller.getINCH()));
    }
}
