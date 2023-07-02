package factories;

import javax.swing.table.TableModel;

import components.buttons.Button;
import components.frames.Frame;
import components.labels.Label;
import components.panels.Panel;
import components.tables.Table;
import components.text.TextField;

public interface GUIFactory {
    Button createButton(String name);

    Panel createPanel();

    Frame createFrame(String title);

    Label createLabel(String title);

    TextField createTextField(int size);

    Table createTable(TableModel tableModel);
}
