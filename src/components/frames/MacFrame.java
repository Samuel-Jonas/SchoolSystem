package components.frames;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class MacFrame extends JFrame implements Frame {

    public MacFrame(String title) {
        new JFrame(title);
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
    public void addComponentsAndConstraints(Object component, String constraint) {
        add((Component) component, constraint);
    }

    @Override
    public void renderFrame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'renderFrame'");
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
    public void setNewDefaultCloseOperation(int operation) {
        setDefaultCloseOperation(operation);
    }

    @Override
    public void setNewSize(int width, int height) {
        setSize(width, height);
    }

    @Override
    public void setNewVisible(boolean value) {
        setVisible(value);
    }
}
