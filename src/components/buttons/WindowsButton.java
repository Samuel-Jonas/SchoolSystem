package components.buttons;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class WindowsButton extends JButton implements Button {

    public WindowsButton(String name) {
        new JButton(name);
    }

    @Override
    public void setSize() {
        setSize(10, 20);
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
