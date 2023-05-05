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
        txtC=(EditText)findViewById(R.id.txtC);// Récupération de la référence de l'objet EditText dans le layout XML
        btnConver=(Button)findViewById(R.id.button_Temp);// Récupération de la référence de l'objet Button dans le layout XML
        txtF=(TextView) findViewById(R.id.txtF);// Récupération de la référence de l'objet TextView dans le layout XML
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);//Définition du layout à utiliser pour cette activité
        init();//Liaison entre les instances de Java et les composants du layout XML
        btnConver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Appel de la méthode de conversion lors du clic sur le bouton
                convertir();
            }
        });
    }
    private void convertir()
    {

        Double TempC = null;
        try
        {
            // Récupération du texte de l'EditText txtC et conversion en Double
            TempC = Double.parseDouble(txtC.getText().toString());
        }
        catch (Exception e){ } // Pour ne pas planter en cas d'erreur

        // Mise à jour du modèle avec la température en Celsius
        controller.createModel(TempC);

        // Affichage de la température convertie en Fahrenheit dans le TextView txtF
        txtF.setText(Double.toString(controller.getNewTemp()));
    }
}
