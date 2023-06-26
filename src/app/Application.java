package app;

import components.buttons.Button;
import factories.GUIFactory;

public class Application {
    
    private Button button;

    public Application(GUIFactory factory) {
        button = factory.createButton();
    }

    public void setSize() {
        button.setSize();
    }
}
