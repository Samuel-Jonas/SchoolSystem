package factories;

import components.buttons.Button;
import components.buttons.MacButton;
import components.frames.Frame;
import components.frames.MacFrame;
import components.panels.MacPanel;
import components.panels.Panel;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Panel createPanel() {
        return new MacPanel();
    }

    @Override
    public Frame createFrame(String title) {
        return new MacFrame(title);
    }
    
}
