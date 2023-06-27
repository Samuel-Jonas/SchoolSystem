package factories;

import components.buttons.Button;
import components.frames.Frame;
import components.panels.Panel;

public interface GUIFactory {
    Button createButton();

    Panel createPanel();

    Frame createFrame(String title);
}
