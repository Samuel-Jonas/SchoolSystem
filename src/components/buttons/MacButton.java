package components.buttons;

import javax.swing.JButton;

public class MacButton extends JButton implements Button {

    private JButton button;

    public MacButton() {
        button = new JButton("Mac button");
    }

    @Override
    public void setSize() {
        button.setSize(20, 30);
    }
    
}
