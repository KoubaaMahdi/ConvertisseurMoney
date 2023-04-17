package com.example.mahdikoubaa_i1_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.mahdikoubaa_i1_tp2.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    private void navigateToActivity(Class nextActivity){
        Intent intent = new Intent(HomeActivity.this,nextActivity);
        startActivity(intent);
        finish();
    }
    //init
    private void ecouteClick(){
        convertDevise.setOnClickListner((view.OnClickLister).this);
        convertTemp.setOnClickListner((view.OnClickLister).this);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.imgConv :
                navigateToActivity(MainActivity.class);
                break;
            case R.id.imgTemp :
                navigateToActivity(MainActivity.class);
                break;
        }
    }
}