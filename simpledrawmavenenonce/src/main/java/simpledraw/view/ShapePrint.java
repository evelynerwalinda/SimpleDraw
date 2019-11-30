/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw.view;

import java.awt.Graphics2D;
import simpledraw.model.Circle;
import simpledraw.model.Line;
import simpledraw.model.ShapeGroup;

/**
 *
 * @author Eva
 */
public class ShapePrint implements ShapeVisitor{

    @Override
    public void visit(Line line, Graphics2D g) {
        System.out.println("ligne ajoutée au dessin");
    }

    @Override
    public void visit(Circle circle, Graphics2D g) {
        System.out.println("cercle ajouté au dessin");
    }

    @Override
    public void visit(ShapeGroup group, Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
