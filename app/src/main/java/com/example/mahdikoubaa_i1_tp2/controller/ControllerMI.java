package com.example.mahdikoubaa_i1_tp2.controller;
import com.example.mahdikoubaa_i1_tp2.model.ModelMI;

public class ControllerMI {
    private static ModelMI model;
    private static ControllerMI insatance= null;

    //public Controller(){  pas de pattern singleton: pas unique isntance pour controlleur
    private ControllerMI(){  // pattern singleton : unique
        super();//herite de classe object pour ne pas mettre acollade vide
    }//user action

    //pour verifier q'une seul instance doit etre presente (unique)
    public final static ControllerMI getInsatance(){
        if(ControllerMI.insatance == null){
            ControllerMI.insatance=new ControllerMI();
        }
        return ControllerMI.insatance;
    }

    public void createModel(Double CM){
        model=new ModelMI(CM);
    }//update model (+user action)
    public double getINCH(){return model.getINCH();
    }
}
