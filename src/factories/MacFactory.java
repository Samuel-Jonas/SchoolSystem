package factories;

import components.buttons.Button;
import components.buttons.MacButton;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }
    
}
