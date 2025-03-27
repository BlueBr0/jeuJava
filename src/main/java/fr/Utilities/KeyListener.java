package fr.Utilities;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyListener implements java.awt.event.KeyListener {


    private ArrayList<String> commandes = new ArrayList<String>();

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
                System.out.println("FLECHE HAUT");
                break;
            case 40:
                System.out.println("FLECHE BAS");
                break;
        }
    }
}
