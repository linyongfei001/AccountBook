package com.muzi.gui.model;

import com.muzi.entity.Category;
import com.muzi.service.CategoryService;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CategoryTableModel extends AbstractTableModel {

    String[] columnNames = new String[] { "分类名称", "消费次数"};

    // 使用从Service返回的List作为TableModel的数据

    public List<Category> cs = new CategoryService().list();

    public int getRowCount() {

        return cs.size();
    }

    public int getColumnCount() {

        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {

        return columnNames[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    // 先通过cs.get(rowIndex)获取行对应的Category对象
    // 然后根据columnIndex返回对应的属性
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category h = cs.get(rowIndex);
        if (0 == columnIndex)
            return h.name;
        if (1 == columnIndex)
            return h.recordNumber;

        return null;
    }

}