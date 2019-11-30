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
public interface ShapeVisitor {

    public void visit(Line line, Graphics2D g);

    public void visit(Circle circle, Graphics2D g);

    public void visit(ShapeGroup group, Graphics2D g);
    
}
