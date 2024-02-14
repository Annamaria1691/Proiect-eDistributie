import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PersistentColorEditor extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && !isValidDouble(value.toString())) {
            cellComponent.setForeground(Color.RED);
        } else {
            cellComponent.setForeground(table.getForeground());
        }

        return cellComponent;
    }

    private boolean isValidDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}