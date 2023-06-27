package components.frames;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;

import javax.swing.JFrame;

public class MacFrame extends JFrame implements Frame {

    public MacFrame(String title) {
        new JFrame(title);
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
    public void addComponentsAndConstraints(Object component, Object constraint) {
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
    public Container getContentPane() {
        return MacFrame.this.getContentPane();
    }

    @Override
    public void setIconImage(Image image) {
        MacFrame.this.setIconImage(image);
    }
}
