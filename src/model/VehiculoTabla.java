package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Auto;

public class VehiculoTabla extends AbstractTableModel {
    private final List<Auto> autos;
    private final String[] columnNames = {"Marca", "Color", "Modelo", "Rodado", "Precio", "Tipo", "Patente", "Cantidad Puertas"};

    public VehiculoTabla(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public int getRowCount() {
        return autos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto auto = autos.get(rowIndex);
        switch (columnIndex) {
            case 0: return auto.getMarca();
            case 1: return auto.getColor();
            case 2: return auto.getModelo();
            case 3: return auto.getRodado();
            case 4: return auto.getPrecio();
            case 5: return auto.getTipo();
            case 6: return auto.getPatente();
            case 7: return auto.getCantidadPuertas();
            default: return null;
        }
    }
}
