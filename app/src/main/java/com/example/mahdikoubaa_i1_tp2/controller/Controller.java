package com.example.mahdikoubaa_i1_tp2.controller;

import com.example.mahdikoubaa_i1_tp2.model.Model;

public final class Controller {
    private static Model model;
    private static Controller insatance= null;

    //public Controller(){  pas de pattern singleton: pas unique isntance pour controlleur
    private Controller(){  // pattern singleton : unique
        super();//herite de classe object pour ne pas mettre acollade vide
    }//user action

    //pour verifier q'une seul instance doit etre presente (unique)
    public final static Controller getInsatance(){
        if(Controller.insatance == null){
            Controller.insatance=new Controller();
        }
        return Controller.insatance;
    }

    public void createModel(Double dinar){
        model=new Model(dinar);
    }//update model (+user action)
    public double getEuro(){
        return model.getEuro();
    }
    public double getGbp(){
        return model.getGbp();
    }
    public double getUsd(){
        return model.getUsd();
    }
}