package app;

import factories.GUIFactory;
import view.HomeFrame;

public class Application {

    public Application(GUIFactory factory) {
        new HomeFrame(factory);
    }

    public void start() {
        
    }
}
