package com.example.mahdikoubaa_i1_tp2.model;

public class ModelKG {
    private Double KG,LB;
    public ModelKG(Double KG){
        this.KG=KG;
        convert();
    }//code de update(constructeur)
    private void convert() {
        //Formule de conversion
        LB =(double) (KG * 2.20462);

    }
    public Double getLB() {
        return LB;
    }//notify controller
}
