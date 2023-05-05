package com.example.mahdikoubaa_i1_tp2.model;

public class ModelTemp {
    private Double TempF,TempC;
    public ModelTemp(Double TempC){
        this.TempC=TempC;
        convert();
    }//code de update(constructeur)
    private void convert() {
        //Formule de conversion
        TempF =(double) ((TempC * (9/(float)5)) + 32);

    }
    public Double getTempF() {
        return TempF;
    }//notify controller
}
