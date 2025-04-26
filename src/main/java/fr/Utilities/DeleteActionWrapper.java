package fr.Utilities;

import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.Action;
import java.awt.event.ActionEvent;

/**
 * Classe enveloppant une action de suppression pour un champ de texte (JTextField).
 * Elle permet de conditionner l'exécution d'une action à la présence d'une sélection de texte dans le champ.
 */
public class DeleteActionWrapper extends AbstractAction {
    private final JTextField textField;
    private final Action action;

    /**
     * Construit un nouvel objet DeleteActionWrapper avec un champ de texte et une action spécifiés.
     *
     * @param textField Le champ de texte sur lequel l'action de suppression sera appliquée.
     * @param action L'action à exécuter lorsque du texte est sélectionné dans le champ.
     */
    public DeleteActionWrapper(JTextField textField, Action action){

        this.textField = textField;
        this.action = action;

    }

    /**
     * Exécute l'action spécifiée uniquement si du texte est sélectionné dans le champ de texte.
     *
     * @param e L'événement d'action qui a déclenché cette méthode.
     */
    @Override
    public void actionPerformed(ActionEvent e){

        if (textField.getSelectionEnd() > 0)
            action.actionPerformed(e);
    }

}