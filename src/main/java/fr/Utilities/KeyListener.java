package fr.Utilities;

import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class KeyListener implements java.awt.event.KeyListener {

    private static int historyIndex = -1;
    
    public ArrayList<String> commandes = new ArrayList<String>();

    JTextField entree;




    public void setEntree(JTextField entree) {
        this.entree = entree;
    }




    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key pressed : " + e.getKeyCode() + " ts=" + e.getWhen());
    }

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
