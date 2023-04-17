package com.example.mahdikoubaa_i1_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.example.mahdikoubaa_i1_tp2.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView convertDevise, convertTemp;
    private void init(){
        convertDevise=(ImageView)findViewById(R.id.imgConv);//findViewById retourne un view donc il faut la convertir(cast) en edit text
        convertTemp=(ImageView)findViewById(R.id.imgTemp);//pas utiliser dans cas listener implicite(utiliser pour explicite)
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        ecouteClick();
    }
    private void navigateToActivity(Class nextActivity){
        Intent intent = new Intent(HomeActivity.this,nextActivity);
        startActivity(intent);
        //finish();
    }
    //init
    private void ecouteClick(){
        convertDevise.setOnClickListener((View.OnClickListener)this);
        convertTemp.setOnClickListener((View.OnClickListener)this);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.imgConv :
                navigateToActivity(MainActivity.class);
                break;
            case R.id.imgTemp :
                navigateToActivity(TempActivity.class);
                break;
        }
    }
}