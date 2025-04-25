package fr.Utilities;

import java.util.Random;

public class Calcul {

    private int nombre1;
    private int nombre2;
    private char operation;
    private double resultat;

    private final Random random = new Random();
    private int niveau;

    public Calcul(int niveau) {
        this.niveau = niveau;
        genererNouvelleOperation();
    }

    public void genererNouvelleOperation() {
        nombre1 = random.nextInt(10) + 1; // 1 à 10
        nombre2 = random.nextInt(10) + 1;

        // Calcul de la probabilité en fonction du niveau
        int operationChance = random.nextInt(100); // Probabilité sur 100
        if (niveau > 5) {
            if (operationChance < 40) {  // 40% de chance pour une addition/soustraction
                operation = random.nextBoolean() ? '+' : '-';
            } else if (operationChance < 80) {  // 40% de chance pour une multiplication
                operation = '*';
            } else {  // 20% de chance pour une division
                operation = '/';
            }
        } else {
            if (operationChance < 70) {  // 70% de chance pour une addition/soustraction
                operation = random.nextBoolean() ? '+' : '-';
            } else {  // 30% de chance pour une multiplication
                operation = '*';
            }
        }

        // Calcul du résultat selon l'opération
        switch (operation) {
            case '+':
                resultat = nombre1 + nombre2;
                break;
            case '-':
                resultat = nombre1 - nombre2;
                break;
            case '*':
                resultat = nombre1 * nombre2;
                break;
            case '/':
                // Assurer que la division est entière et éviter une division par zéro
                if (nombre2 != 0) {
                    resultat = (double) nombre1 / nombre2;
                } else {
                    // Si nombre2 est zéro, régénérer l'opération
                    genererNouvelleOperation();
                }
                break;
        }
    }

    public String getOperationText() {
        return nombre1 + " " + operation + " " + nombre2 + " = ?";
    }

    public boolean verifierReponse(double reponse) {
        if (operation == '/') {
            return Math.abs(resultat - reponse) < 0.01; // Tolérance pour division
        } else {
            return resultat == reponse;
        }
    }

    public double getResultat() {
        return resultat;
    }

    public int getNombre1() {
        return nombre1;
    }

    public int getNombre2() {
        return nombre2;
    }

    public char getOperation() {
        return operation;
    }
}
