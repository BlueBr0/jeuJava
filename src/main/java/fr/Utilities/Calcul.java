package fr.Utilities;

import java.util.Random;

/**
 * Classe représentant un calcul mathématique simple avec des opérations générées aléatoirement.
 * Elle permet de créer des opérations d'addition, de soustraction, de multiplication et de division
 * en fonction d'un niveau de difficulté.
 */
public class Calcul {

    private int nombre1;
    private int nombre2;
    private char operation;
    private double resultat;

    private final Random random = new Random();
    private int niveau;

    /**
     * Construit un nouvel objet Calcul avec un niveau de difficulté spécifié.
     * Génère une nouvelle opération mathématique en fonction de ce niveau.
     *
     * @param niveau Le niveau de difficulté, influençant la probabilité des types d'opérations.
     */
    public Calcul(int niveau) {
        this.niveau = niveau;
        genererNouvelleOperation();
    }

    /**
     * Génère une nouvelle opération mathématique aléatoire en fonction du niveau de difficulté.
     * Les opérations possibles sont l'addition, la soustraction, la multiplication et la division.
     * La probabilité de chaque type d'opération dépend du niveau de difficulté.
     */
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

    /**
     * Retourne une représentation textuelle de l'opération mathématique actuelle.
     *
     * @return Une chaîne de caractères représentant l'opération (ex: "5 + 3 = ?").
     */
    public String getOperationText() {
        return nombre1 + " " + operation + " " + nombre2 + " = ?";
    }

    /**
     * Vérifie si la réponse donnée par l'utilisateur est correcte pour l'opération actuelle.
     *
     * @param reponse La réponse donnée par l'utilisateur.
     * @return true si la réponse est correcte, false sinon.
     */
    public boolean verifierReponse(double reponse) {
        if (operation == '/') {
            return Math.abs(resultat - reponse) < 0.01; // Tolérance pour division
        } else {
            return resultat == reponse;
        }
    }

    /**
     * Retourne le résultat correct de l'opération mathématique actuelle.
     *
     * @return Le résultat de l'opération.
     */
    public double getResultat() {
        return resultat;
    }

    /**
     * Retourne le premier nombre de l'opération mathématique actuelle.
     *
     * @return Le premier nombre.
     */
    public int getNombre1() {
        return nombre1;
    }

    /**
     * Retourne le second nombre de l'opération mathématique actuelle.
     *
     * @return Le second nombre.
     */
    public int getNombre2() {
        return nombre2;
    }

    /**
     * Retourne l'opérateur de l'opération mathématique actuelle.
     *
     * @return L'opérateur (ex: '+', '-', '*', '/').
     */
    public char getOperation() {
        return operation;
    }
}
