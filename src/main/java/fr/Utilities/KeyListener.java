package fr.Utilities;

import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Classe implémentant l'interface KeyListener pour gérer les événements de frappe au clavier dans un champ de texte.
 * Elle permet de naviguer dans l'historique des commandes saisies à l'aide des touches fléchées haut et bas.
 */
public class KeyListener implements java.awt.event.KeyListener {

    private static int historyIndex = -1;
    
    public ArrayList<String> commandes = new ArrayList<String>();

    JTextField entree;




    /**
     * Définit le champ de texte (JTextField) sur lequel les événements de frappe seront écoutés.
     *
     * @param entree Le champ de texte à associer à ce KeyListener.
     */
    public void setEntree(JTextField entree) {
        this.entree = entree;
    }




    /**
     * Méthode appelée lorsqu'une touche est tapée.
     * Cette implémentation ne fait rien.
     *
     * @param e L'événement de frappe.
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Méthode appelée lorsqu'une touche est pressée.
     * Cette implémentation ne fait rien.
     *
     * @param e L'événement de pression de touche.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key pressed : " + e.getKeyCode() + " ts=" + e.getWhen());
    }

    /**
     * Méthode appelée lorsqu'une touche est relâchée.
     * Gère la navigation dans l'historique des commandes à l'aide des touches fléchées haut (38) et bas (40).
     *
     * @param e L'événement de relâchement de touche.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Key pressed : " + e.getKeyCode() + " ts=" + e.getWhen());

        switch (e.getKeyCode()){
            case 38:
                if (historyIndex < commandes.size() - 1) {
                    historyIndex++;
                    entree.setText(commandes.get(historyIndex));
                } else {
                    // Si on dépasse la dernière commande, on clear
                    historyIndex = commandes.size();
                    entree.setText("");
                }
                break;
            case 40:

                if (historyIndex > 0) {
                    historyIndex--;
                    entree.setText(commandes.get(historyIndex));
                }
                break;
        }
    }
}
