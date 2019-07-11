package com.muzi.gui.panel;

import com.muzi.entity.Record;
import com.muzi.service.ReportService;
import com.muzi.util.ChartUtil;
import com.muzi.util.GUIUtil;

import javax.swing.*;
import java.awt.Image;
import java.awt.BorderLayout;
import java.util.List;

public class ReportPanel extends WorkingPanel {

    public static ReportPanel instance = new ReportPanel();

    JLabel l = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 400, 300);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void updateData() {
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }

    @Override
    public void addListener() {

    }
}
