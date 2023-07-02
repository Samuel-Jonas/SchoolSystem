package components.labels;

import javax.swing.JLabel;

public class MacLabel extends JLabel implements Label {

    public MacLabel(String title) {
        new JLabel(title);
    }

    @Override
    public void setSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSize'");
    }
    
}
