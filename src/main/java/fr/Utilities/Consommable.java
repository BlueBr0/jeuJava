package fr.Utilities;

public class Consommable {

    private String nomConsommale;
    private Rarete rarete;
    private String diminutif;

    public Consommable(String nom, Rarete rarete, String diminutif) {
        this.nomConsommale = nom;
        this.rarete = rarete;
        this.diminutif = diminutif;
    }

    public String getNomConsommale() {
        return nomConsommale;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public String getDiminutif() {
        return diminutif;
    }
}
