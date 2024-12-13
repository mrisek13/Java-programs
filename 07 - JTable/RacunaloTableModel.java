
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RacunaloTableModel extends AbstractTableModel {

    private List<Racunalo> racunala;

    private String[] columnNames = {"Rb.", "Naziv računala", "RAM GB", "Bitno", "Brzina GHz"};

    public RacunaloTableModel(List<Racunalo> racunala) {
        this.racunala = racunala;
    }
    
    @Override
    public int getRowCount() {
        return racunala.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racunalo racunalo = racunala.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1 + ".";
            case 1:
                return racunalo.getNaziv();
            case 2:
                return racunalo.getRam();
            case 3:
                return racunalo.getBit();
            case 4:
                return racunalo.getBrzina();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
