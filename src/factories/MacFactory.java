package factories;

import javax.swing.table.TableModel;

import components.buttons.Button;
import components.buttons.MacButton;
import components.frames.Frame;
import components.frames.MacFrame;
import components.labels.Label;
import components.labels.MacLabel;
import components.panels.MacPanel;
import components.panels.Panel;
import components.tables.MacTable;
import components.tables.Table;
import components.text.MacText;
import components.text.TextField;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton(String name) {
        return new MacButton(name);
    }

    @Override
    public Panel createPanel() {
        return new MacPanel();
    }

    @Override
    public Frame createFrame(String title) {
        return new MacFrame(title);
    }

    @Override
    public Label createLabel(String title) {
        return new MacLabel(title);
    }

    @Override
    public TextField createTextField(int size) {
        return new MacText(size);
    }

    @Override
    public Table createTable(TableModel model) {
        return new MacTable(model);
    }
    
}
