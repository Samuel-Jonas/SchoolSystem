package components.labels;

import javax.swing.JLabel;

public class WindowsLabel extends JLabel implements Label {

    public WindowsLabel(String title) {
        new JLabel(title);
    }

    @Override
    public void setSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSize'");
    }
    
}
