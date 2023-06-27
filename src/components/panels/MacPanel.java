package components.panels;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridLayout;

public class MacPanel extends JPanel implements Panel {

    private static JPanel panel = new JPanel();

    @Override
    public void addComponent(Object component) {
        panel.add((Component) component);
    }

    @Override
    public void setLayout() {
        panel.setLayout(new GridLayout(6, 1));
    }
    
}
