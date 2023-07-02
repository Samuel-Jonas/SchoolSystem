package components.panels;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.LayoutManager;

public class MacPanel extends JPanel implements Panel {

    public MacPanel () {
        new JPanel();
    }

    @Override
    public void addComponent(Object component) {
        add((Component) component);
    }

    @Override
    public void setNewLayout(LayoutManager layout) {
        setLayout(layout);
    }
    
}
