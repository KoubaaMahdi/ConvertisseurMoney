package com.example.mahdikoubaa_i1_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mahdikoubaa_i1_tp2.R;
import com.example.mahdikoubaa_i1_tp2.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private EditText txtTND; // Champ texte pour saisir le montant en TND
    private Button btnConvert; // Bouton de conversion
    private TextView lbEUR, lbUSD, lbGBP; // Labels pour afficher les valeurs converties
    Controller controller = Controller.getInsatance();
    // Instance du contrôleur MVC

    // Initialisation des composants de l'interface utilisateur
    private void init() {
        txtTND = (EditText) findViewById(R.id.txtTND);
        btnConvert = (Button) findViewById(R.id.button_id);
        lbEUR = (TextView) findViewById(R.id.txtEUR);
        lbUSD = (TextView) findViewById(R.id.txtUSD);
        lbGBP = (TextView) findViewById(R.id.txtGBP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(); // Initialisation des composants de l'interface utilisateur
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert(); // Appel de la fonction de conversion lorsqu'on clique sur le bouton
            }
        });
    }

    // Fonction de conversion
    public void convert() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        Double dinar = null;
        try {
            //Récupération du texte du montant en TND avec getText()
            dinar = Double.parseDouble(txtTND.getText().toString());
        } catch (Exception e) {
            // Pour éviter les erreurs lors de la saisie de texte
        }
        intent.putExtra("dinar",dinar.toString());
        // Mise à jour du modèle MVC avec le montant saisi
        startActivity(intent);
        // Mise à jour des TextView lbEUR, lbUSD, lbGBP avec les valeurs converties
        lbEUR.setText(Double.toString(controller.getEuro()));
        lbUSD.setText(Double.toString(controller.getUsd()));
        lbGBP.setText(Double.toString(controller.getGbp()));

        // La vue a été mise à jour, le contrôleur MVC doit notifier les observateurs
        // pour qu'ils mettent à jour leur propre affichage
    }
}
