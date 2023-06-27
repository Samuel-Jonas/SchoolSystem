package components.frames;

import java.awt.Container;
import java.awt.Image;

public interface Frame {

    void addComponentsAndConstraints(Object component, Object constraint);

    void addComponent(Object component);

    void renderFrame();

    void setLayout();

    Container getContentPane();

    void setIconImage(Image image);

    void setDefaultCloseOperation(int operation);

    void setVisible(boolean value);

    void setSize(int width, int height);
}
