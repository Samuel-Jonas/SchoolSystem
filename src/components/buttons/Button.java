package components.buttons;

import java.awt.Dimension;
import java.awt.event.ActionListener;

public interface Button {
    void setSize();

    void setNewPreferredSize(Dimension dimension);

    void addNewActionListener(ActionListener actionListener);
}
