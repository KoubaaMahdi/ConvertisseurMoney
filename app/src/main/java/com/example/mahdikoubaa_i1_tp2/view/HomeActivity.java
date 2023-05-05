package com.example.mahdikoubaa_i1_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mahdikoubaa_i1_tp2.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    // Déclaration de variables pour stocker des ImageView
    private ImageView convertDevise, convertTemp, convertKG, convertMI;

    // Méthode pour initialiser les ImageView
    private void init(){
        // On associe chaque ImageView à son identifiant dans la vue
        //findViewById retourne un view donc il faut la convertir(cast) en edit text
        convertDevise = (ImageView)findViewById(R.id.imgConv);
        convertTemp = (ImageView)findViewById(R.id.imgTemp);
        convertKG = (ImageView)findViewById(R.id.imgKg);
        convertMI = (ImageView)findViewById(R.id.imgMi);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init(); // On initialise les ImageView
        ecouteClick(); // On met en place les écouteurs d'événements pour chaque ImageView
    }

    // Méthode pour naviguer vers une autre activité en passant la classe correspondante en paramètre
    private void navigateToActivity(Class nextActivity){
        Intent intent = new Intent(HomeActivity.this, nextActivity);
        startActivity(intent);
    }

    // Méthode pour mettre en place les écouteurs d'événements pour chaque ImageView
    private void ecouteClick(){
        convertDevise.setOnClickListener((View.OnClickListener)this);
        convertTemp.setOnClickListener((View.OnClickListener)this);
        convertKG.setOnClickListener((View.OnClickListener)this);
        convertMI.setOnClickListener((View.OnClickListener)this);
    }

    @Override
    public void onClick(View v){
        // On vérifie quelle ImageView a été cliquée en comparant son identifiant avec les identifiants des ImageView connus
        switch(v.getId()){
            case R.id.imgConv :
                // Si c'est celle de la conversion de devises, on navigue vers l'activité MainActivity
                navigateToActivity(MainActivity.class);
                break;
            case R.id.imgTemp :
                // Si c'est celle de la conversion de température, on navigue vers l'activité TempActivity
                navigateToActivity(TempActivity.class);
                break;
            case R.id.imgKg :
                // Si c'est celle de la conversion de poids, on navigue vers l'activité KgActivity
                navigateToActivity(KgActivity.class);
                break;
            case R.id.imgMi :
                // Si c'est celle de la conversion de distance, on navigue vers l'activité MiActivity
                navigateToActivity(MiActivity.class);
                break;
        }
    }
}
