package com.example.mahdikoubaa_i1_tp2.model;

public class ModelMI {
    private Double CM,INCH;
    public ModelMI(Double CM){
        this.CM=CM;
        convert();
    }//code de update(constructeur)
    private void convert() {
        //Formule de conversion
        INCH =(double) (CM * 0.393701);

    }
    public Double getINCH() {
        return INCH;
    }//notify controller
}
