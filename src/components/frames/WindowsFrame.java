package components.frames;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class WindowsFrame extends JFrame implements Frame {

    public WindowsFrame(String title) {
        new JFrame(title);
    }

    @Override
    public void addComponentsAndConstraints(Object component, String constraint) {
        add((Component) component, constraint);
    }

    @Override
    public void setNewLocationRelativeTo(Component component) {
		setLocationRelativeTo(component);
    }

    @Override
    public void setNewLayout(LayoutManager layout) {
        setLayout(layout);
    }

    @Override
    public void renderFrame() {
    }

    @Override
    public void addComponent(Object component) {
        add((Component) component);
    }

    @Override
    public Container getNewContentPane() {
        return getContentPane();
    }

    @Override
    public void setNewIconImage(Image image) {
        setIconImage(image);
    }

    @Override
    public void setNewSize(int width, int height) {
        setSize(width, height);
    }

    @Override
    public void setNewDefaultCloseOperation(int position) {
        setDefaultCloseOperation(position);
    }

    @Override 
    public void setNewVisible(boolean value) {
        WindowsFrame.this.setVisible(value);
    }
    
}
