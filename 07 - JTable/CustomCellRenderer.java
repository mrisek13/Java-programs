
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (isSelected) {
            c.setBackground(new Color(255, 255, 153));
            setForeground(Color.BLACK);
        } else {
            
            if (column == 0) {
                c.setBackground(new Color(200, 200, 200));
                setForeground(Color.BLACK);
            } else if (column == 2 || column == 4) {
                c.setBackground(Color.WHITE);
                setForeground(Color.RED);
            } else {
                c.setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            }
        }
        if (column == 1 || column == 3) {
            setHorizontalAlignment(SwingConstants.LEFT); // Lijevo poravnanje
        } else {
            setHorizontalAlignment(SwingConstants.CENTER); // Centriranje za ostale
        }
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        return c;
    }
}
