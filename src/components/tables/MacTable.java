package components.tables;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class MacTable extends JTable implements Table {

    public MacTable(TableModel table) {
        new JTable(table);
    }

    @Override
    public void setSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSize'");
    }
    
}
