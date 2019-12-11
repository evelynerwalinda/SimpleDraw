/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import simpledraw.controller.CircleTool;
import simpledraw.controller.DrawingTool;
import simpledraw.model.Drawing;
import simpledraw.model.Shape;

/**
 *
 * @author Eva
 */
public class MiniPanel extends JPanel implements DrawingView {

    public JLabel txt = new JLabel();
    public Drawing model = new Drawing();
    public String classe;

    public MiniPanel() {
        setBackground(java.awt.Color.white);        
        //txt.setText();
        this.add(txt);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*for (Shape s : model.myShapes) {
                classe = s.getClass().toString();                
        }*/
        System.out.println("il y a "+ model.myShapes.size() + " formes");
        //txt.setText("Le dessin comporte " + classe);
    }

    @Override
    public void notify(Drawing model) {
        //repaint();
        txt.setText("Il y a " + model.myShapes.size() + " formes");
        System.out.println(model.myShapes.size());
    }

}
