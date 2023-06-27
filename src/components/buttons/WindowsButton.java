package components.buttons;

import javax.swing.JButton;

public class WindowsButton extends JButton implements Button {

    private JButton button;

    public WindowsButton() {
        button = new JButton("Windows button");
    }

    @Override
    public void setSize() {
        button.setSize(10, 20);
    }
    
}
