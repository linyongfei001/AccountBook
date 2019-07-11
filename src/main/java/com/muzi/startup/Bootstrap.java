package com.muzi.startup;
 
import com.muzi.gui.frame.MainFrame;
import com.muzi.gui.panel.MainPanel;
import com.muzi.gui.panel.SpendPanel;
import com.muzi.util.GUIUtil;

import javax.swing.SwingUtilities;

 
public class Bootstrap {
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();
 
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}