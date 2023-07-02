package components.panels;

import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class WindowsPanel extends JPanel implements Panel {

    @Override
    public void addComponent(Object component) {
        add((Component) component);
    }

    @Override
    public void setNewLayout(LayoutManager layout) {
        setLayout(layout);
    }
    
}
