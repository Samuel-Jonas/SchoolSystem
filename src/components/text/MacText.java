package components.text;

import javax.swing.JTextField;

public class MacText extends JTextField implements TextField {

    public MacText(int columns) {
        new JTextField(columns);
    }

    @Override
    public void setSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSize'");
    }

    @Override
    public String getNewText() {
        return getText();
    }

    @Override
    public void setNewText(String text) {
        setText(text);
    }
    
}
