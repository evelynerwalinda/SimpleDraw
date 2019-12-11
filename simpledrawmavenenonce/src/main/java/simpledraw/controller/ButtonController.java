/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simpledraw.view.DrawingPanel;
import simpledraw.view.MainFrame;

/**
 *
 * @author Eva
 */
public class ButtonController {

    public void action(MainFrame mf) {
        mf.getMySelectButton().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.getMyDrawingPanel().activateSelectionTool();
            }
        });
        
        mf.getMyLineButton().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.getMyDrawingPanel().activateLineTool();
            }
        });
        
        mf.getMyCircleButton().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.getMyDrawingPanel().activateCircleTool();
            }
        });
    }
}
