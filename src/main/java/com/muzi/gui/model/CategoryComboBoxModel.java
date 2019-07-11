package com.muzi.gui.model;

import com.muzi.entity.Category;
import com.muzi.service.CategoryService;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;


public class CategoryComboBoxModel implements ComboBoxModel<Category> {

    public List<Category> cs = new CategoryService().list();

    public Category c;

    /**
     * 造方法中初始化模拟数据。 这些数据不是从数据库中读出来的，是专门用于原型数据显示的。
     */
/*    public CategoryComboBoxModel(){
        cs.add("餐饮");
        cs.add("交通");
        cs.add("住宿");
        cs.add("话费");
        c = cs.get(0);
    }*/


    public CategoryComboBoxModel(){
        if(!cs.isEmpty())
            c=cs.get(0);
    }


    /**
     * 当界面上选中了某一个下拉框项，就会调用这个方法
     * @param anItem
     */
    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
    }

    /**
     * 获取被选中的数据
     * @return
     */
    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty())
            return c;
        else
            return null;

    }

    /**
     * 获取这个下拉框的大小，就是前面定义的字符串集合的大小
     * @return
     */
    @Override
    public int getSize() {
        return cs.size();
    }

    /**
     * 获取指定位置的数据
     * @param index
     * @return
     */
    @Override
    public Category getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
