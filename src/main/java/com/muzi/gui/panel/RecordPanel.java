package com.muzi.gui.panel;

import com.muzi.entity.Category;
import com.muzi.gui.listener.RecordListener;
import com.muzi.gui.model.CategoryComboBoxModel;
import com.muzi.service.CategoryService;
import com.muzi.util.ColorUtil;
import com.muzi.util.GUIUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RecordPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();

    JLabel lSpend = new JLabel("花费(￥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");

    public JTextField tfSpend = new JTextField("0");

//    下拉框用到了JComboBox，在创建这个下拉框的时候，
//    借助了类似于TableModel的形式，使用ComboBoxModel把数据分离开来，
//    这样做的目的是为了便于下拉框中分类信息的更新。
//    因为在后续的开发中，分类信息是从数据库中取出来的，很有可能发生变化。
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());

    JButton bSubmit = new JButton("记一笔");

    public RecordPanel(){
        GUIUtil.setColor(ColorUtil.grayColor,lSpend,lCategory,lComment,lDate);
        GUIUtil.setColor(ColorUtil.blueColor,bSubmit);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));

        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datepick);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);

        addListener();


    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }

    /**
     *  提供getSelectedCategory()用于获取当前选中的分类对象。
     * @return
     */
    public Category getSelectedCategory(){
        return (Category) cbCategory.getSelectedItem();
    }


    /**
     * updateData()更新数据，主要是更新下拉框中的分类信息，
     * 并且让各个输入框信息重置，以及让焦点停留在金额的输入框上
     */
    @Override
    public void updateData() {
        cbModel.cs = new CategoryService().list();
        cbCategory.updateUI();
        resetInput();
        tfSpend.grabFocus();
    }

    private void resetInput() {
        tfSpend.setText("0");
        tfComment.setText("");
        if(0!=cbModel.cs.size())
            cbCategory.setSelectedIndex(0);
        datepick.setDate(new Date());
    }

    @Override
    public void addListener() {
        RecordListener listener = new RecordListener();
        bSubmit.addActionListener(listener);
    }
}
