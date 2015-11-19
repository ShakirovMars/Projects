package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModel implements TableModel {
	 
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private ArrayList<Product> products;

    public MyTableModel(ArrayList<Product> products) {
        this.products = products;
    }

    public void addTableModelListener1(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 4;
    }
    
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return "Имя";
        case 1:
            return "Производитель";
        case 2:
            return "Категория";
        
        case 3:
        	return "Вес";
        	}
        return "";
    }

    public int getRowCount() {
        return products.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
    	Product product = products.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return product.getName();
        case 1:
            return  product.getProizvoditel();
        case 2:
            return  product.getCategory();
        case 3:
        	return  product.getVes();
        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener1(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
