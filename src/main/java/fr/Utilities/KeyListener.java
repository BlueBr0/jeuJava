package fr.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyListener implements java.awt.event.KeyListener {

    public void setEntree(JTextField entree) {
        this.entree = entree;
    }

    JTextField entree;

    private static int historyIndex = -1;

    public ArrayList<String> commandes = new ArrayList<String>();


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
                    if (historyIndex > 0) {
                        historyIndex--;
                        entree.setText(commandes.get(historyIndex));
                    }
                break;
            case 40:
                    if (historyIndex < commandes.size() - 1) {
                        historyIndex++;
                        entree.setText(commandes.get(historyIndex));
                    } else {
                        // Si on dépasse la dernière commande, on clear
                        historyIndex = commandes.size();
                        entree.setText("");
                    }
                break;
        }
    }
}
