package com.muzi.gui.panel;

import com.muzi.entity.Category;
import com.muzi.gui.listener.CategoryListener;
import com.muzi.gui.model.CategoryTableModel;
import com.muzi.service.CategoryService;
import com.muzi.util.ColorUtil;
import com.muzi.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends WorkingPanel {

    static{
        GUIUtil.useLNF();
    }

    public static CategoryPanel instance = new CategoryPanel();

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
//    String columNames[] = new String[] { "分类名称", "消费次数" };

    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t = new JTable(ctm);

    public CategoryPanel(){
        GUIUtil.setColor(ColorUtil.blueColor,bAdd,bEdit,bDelete);
        JScrollPane sp = new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);


        this.setLayout(new BorderLayout());
        this.add(sp, BorderLayout.CENTER);
        this.add(pSubmit, BorderLayout.SOUTH);

        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }

    /**
     * 方便获取JTable上当前选中的Category对象
     * @return
     */
    public Category getSelectedCategory() {
        int index = t.getSelectedRow();
        return ctm.cs.get(index);
    }


    /**
     * 增加一个updateData方法，用于在增加，删除，和修改之后，更新表格中的信息，并默认选中第一行。
     * 除此之外，还进行判断，如果表格里没有数据，删除和修改按钮不可使用。
     */
    @Override
    public void updateData() {
        ctm.cs = new CategoryService().list();
        t.updateUI();
//        获取当前选择的数据后更新数据
        t.getSelectionModel().setSelectionInterval(0, 0);

        if(0==ctm.cs.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }
        else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    @Override
    public void addListener() {
        CategoryListener listener = new CategoryListener();
        bAdd.addActionListener(listener);
        bEdit.addActionListener(listener);
        bDelete.addActionListener(listener);
    }
}
