package com.example.mahdikoubaa_i1_tp2.controller;
import com.example.mahdikoubaa_i1_tp2.model.ModelKG;

public class ControllerKG {

    // Déclaration d'une variable privée de type ModelKG
    private static ModelKG model;

    // Déclaration d'une variable privée de type ControllerKG
    private static ControllerKG instance = null;

    // Constructeur privé de la classe pour empêcher l'instanciation directe de celle-ci
    private ControllerKG() {
        super();
    }

    // Méthode statique pour obtenir une instance unique de la classe
    public final static ControllerKG getInsatance() {
        // Si l'instance n'a pas encore été créée
        if (ControllerKG.instance == null) {
            // On crée une nouvelle instance de la classe ControllerKG
            ControllerKG.instance = new ControllerKG();
        }
        // On retourne l'instance créée
        return ControllerKG.instance;
    }

    // Méthode pour créer un objet ModelKG avec la valeur a convertir
    public void createModel(Double KG) {
        // On crée une nouvelle instance de la classe ModelKG
        model = new ModelKG(KG);
    }

    // Méthode pour obtenir la valeur de l'attribut LB de l'objet ModelKG associé
    public double getLB() {
        // On renvoie la valeur de l'attribut LB de l'objet ModelKG associé
        return model.getLB();
    }
}

