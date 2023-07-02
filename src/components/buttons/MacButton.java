package components.buttons;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MacButton extends JButton implements Button {

    public MacButton(String name) {
        new JButton(name);
    }

    @Override
    public void setSize() {
        setSize(20, 30);
    }

    @Override
    public void setNewPreferredSize(Dimension dimension) {
        setPreferredSize(dimension);
    }

    @Override
    public void addNewActionListener(ActionListener actionListener) {
        addActionListener(actionListener);
    }
    
}
