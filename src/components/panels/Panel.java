package components.panels;

import java.awt.LayoutManager;

public interface Panel {
    void addComponent(Object component);

    void setNewLayout(LayoutManager layout);
}
