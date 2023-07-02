package components.tables;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class WindowsTable extends JTable implements Table {

    public WindowsTable(TableModel table) {
        new JTable(table);
    }

    @Override
    public void setSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSize'");
    }
    
}
