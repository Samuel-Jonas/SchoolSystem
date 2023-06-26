package components.buttons;

import javax.swing.JButton;

public class WindowsButton implements Button {

    @Override
    public void setSize() {
        JButton button = new JButton("Windows button");

        button.setSize(10, 20);
    }
    
}
