package factories;

import components.buttons.Button;
import components.buttons.WindowsButton;
import components.frames.Frame;
import components.frames.WindowsFrame;
import components.panels.Panel;
import components.panels.WindowsPanel;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Panel createPanel() {
        return new WindowsPanel();
    }

    @Override
    public Frame createFrame(String title) {
        return new WindowsFrame(title);
    }
    
}
