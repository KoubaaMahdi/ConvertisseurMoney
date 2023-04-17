package com.example.mahdikoubaa_i1_tp2.controller;
import com.example.mahdikoubaa_i1_tp2.model.ModelTemp;

public class ControllerTemp {
    private static ModelTemp model;
    private static ControllerTemp insatance= null;

    //public Controller(){  pas de pattern singleton: pas unique isntance pour controlleur
    private ControllerTemp(){  // pattern singleton : unique
        super();//herite de classe object pour ne pas mettre acollade vide
    }//user action

    //pour verifier q'une seul instance doit etre presente (unique)
    public final static ControllerTemp getInsatance(){
        if(ControllerTemp.insatance == null){
            ControllerTemp.insatance=new ControllerTemp();
        }
        return ControllerTemp.insatance;
    }

    public void createModel(Double Temp){
        model=new ModelTemp(Temp);
    }//update model (+user action)
    public double getNewTemp(){
        return model.getTempF();
    }
}
