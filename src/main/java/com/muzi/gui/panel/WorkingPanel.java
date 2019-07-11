package com.muzi.gui.panel;
 
import javax.swing.JPanel;

/**
 * WorkingPanel是一个抽象类，其中声明了方法addListener()和updateData().
 *
 * 不同的面板类，都应该继承这个抽象类，进而必须提供addListener和updateData方法。
 */
public abstract class WorkingPanel  extends JPanel{
    public abstract void updateData();
    public abstract void addListener();
}