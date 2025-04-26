package fr.Utilities;

import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.Action;
import java.awt.event.ActionEvent;

public class DeleteActionWrapper extends AbstractAction {
    private final JTextField textField;
    private final Action action;
    public DeleteActionWrapper(JTextField textField, Action action){

        this.textField = textField;
        this.action = action;

    }

    @Override
    public void actionPerformed(ActionEvent e){

        if (textField.getSelectionEnd() > 0)
            action.actionPerformed(e);
    }

}