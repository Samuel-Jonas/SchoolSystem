package components.buttons;

import javax.swing.JButton;

public class MacButton implements Button {

    @Override
    public void setSize() {
        JButton button = new JButton("macButton");

        button.setSize(20, 30);
    }
    
}
