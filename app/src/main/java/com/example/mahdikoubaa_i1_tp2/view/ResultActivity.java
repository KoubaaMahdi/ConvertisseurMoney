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

public class ResultActivity extends AppCompatActivity {
    private TextView E1,E2,E3,E4,E5,E6;  // déclaration des TextViews pour afficher les résultats
    private double D1,D2,D3,D4,D5,D6;  // déclaration des variables pour stocker les montants en dinars
    Button btnReturn;  // déclaration d'un bouton pour retourner à l'activité précédente
    Controller controller = Controller.getInsatance();  // création d'une instance de la classe Controller
    Intent intent ;  // déclaration d'une instance de la classe Intent

    private void init() {  // initialisation des éléments de l'interface graphique
        E1 = (TextView) findViewById(R.id.DToE1);
        E2 = (TextView) findViewById(R.id.DToE2);
        E3 = (TextView) findViewById(R.id.DToE3);
        E4 = (TextView) findViewById(R.id.DToE4);
        E5 = (TextView) findViewById(R.id.DToE5);
        E6 = (TextView) findViewById(R.id.DToE6);
        D1=1;  // initialisation des montants en dinars
        D2=10;
        D3=50;
        D4=100;
        D5=200;
        String dinarString = intent.getStringExtra("dinar");  // récupération du montant en dinars à partir de l'intent
        if (dinarString != null) {
            D6 = Double.parseDouble(dinarString);  // conversion du montant en dinars en double
        }
        btnReturn = (Button) findViewById(R.id.btnReturn);  // initialisation du bouton retour
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        intent = getIntent();  // récupération de l'intent qui a démarré cette activité
        init();  // appel de la méthode d'initialisation
        Convert();  // appel de la méthode pour convertir les montants en dinars en euros
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Appeler finish() pour terminer l'activité en cours et retourner à l'activité précédente
                finish();
            }
        });
    }

    public void Convert(){  // méthode pour convertir les montants en dinars en euros
        controller.createModel(D1);  // création d'un modèle de conversion pour le montant D1
        E1.setText(Double.toString(D1)+"Dinars = "+Double.toString(controller.getEuro())+"euro\n"); // affichage du résultat de la conversion pour le montant D1
        controller.createModel(D2);  // création d'un modèle de conversion pour le montant D2
        E2.setText(Double.toString(D2)+"Dinars = "+Double.toString(controller.getEuro())+"euro\n"); // affichage du résultat de la conversion pour le montant D2
        controller.createModel(D3); // création d'un modèle de conversion pour le montant D3
        E3.setText(Double.toString(D3)+"Dinars = "+Double.toString(controller.getEuro())+"euro\n"); // affichage du résultat de la conversion pour le montant D3
        controller.createModel(D4); // création d'un modèle de conversion pour le montant D4
        E4.setText(Double.toString(D4)+"Dinars = "+Double.toString(controller.getEuro())+"euro\n"); // affichage du résultat de la conversion pour le montant D4
        controller.createModel(D5); // création d'un modèle de conversion pour le montant D5
        E5.setText(Double.toString(D5)+"Dinars = "+Double.toString(controller.getEuro())+"euro\n"); // affichage du résultat de la conversion pour le montant D5
        controller.createModel(D6); // création d'un modèle de conversion pour le montant D6
        E6.setText(Double.toString(D6)+"Dinars = "+Double.toString(controller.getEuro())+"euro\n"); // affichage du résultat de la conversion pour le montant D6
    }
}
