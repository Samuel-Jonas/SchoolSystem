package factories;

import javax.swing.table.TableModel;

import components.buttons.Button;
import components.buttons.WindowsButton;
import components.frames.Frame;
import components.frames.WindowsFrame;
import components.labels.Label;
import components.labels.WindowsLabel;
import components.panels.Panel;
import components.panels.WindowsPanel;
import components.tables.Table;
import components.tables.WindowsTable;
import components.text.TextField;
import components.text.WindowsText;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton(String name) {
        return new WindowsButton(name);
    }

    @Override
    public Panel createPanel() {
        return new WindowsPanel();
    }

    @Override
    public Frame createFrame(String title) {
        return new WindowsFrame(title);
    }

    @Override
    public Label createLabel(String title) {
        return new WindowsLabel(title);
    }

    @Override
    public TextField createTextField(int columns) {
        return new WindowsText(columns);
    }

    @Override
    public Table createTable(TableModel model) {
        return new WindowsTable(model);
    }
    
}
