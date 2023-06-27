package components.frames;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;

import javax.swing.JFrame;

public class WindowsFrame extends JFrame implements Frame {

    public WindowsFrame(String title) {
        new JFrame(title);
    }

    @Override
    public void addComponentsAndConstraints(Object component, Object constraint) {
        add((Component) component, constraint);
    }

    @Override
    public void setLayout() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(512,512);
		setLocationRelativeTo(null);
		setVisible(true);
    }

    @Override
    public void renderFrame() {
        setLayout();
    }

    @Override
    public void addComponent(Object component) {
        add((Component) component);
    }

    @Override
    public Container getContentPane() {
        return WindowsFrame.this.getContentPane();
    }

    @Override
    public void setIconImage(Image image) {
        WindowsFrame.this.setIconImage(image);
    }

    @Override
    public void setSize(int width, int height) {
        WindowsFrame.this.setSize(width, height);
    }

    @Override
    public void setDefaultCloseOperation(int position) {
        WindowsFrame.this.setDefaultCloseOperation(position);
    }

    @Override 
    public void setVisible(boolean value) {
        WindowsFrame.this.setVisible(value);
    }
    
}
