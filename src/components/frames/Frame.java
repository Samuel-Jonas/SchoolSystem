package components.frames;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.LayoutManager;

public interface Frame {

    void addComponentsAndConstraints(Object component, String constraint);

    void addComponent(Object component);

    void renderFrame();

    void setNewLocationRelativeTo(Component component);

    void setNewLayout(LayoutManager layout);

    Container getNewContentPane();

    void setNewIconImage(Image image);

    void setNewDefaultCloseOperation(int operation);

    void setNewVisible(boolean value);

    void setNewSize(int width, int height);
}
