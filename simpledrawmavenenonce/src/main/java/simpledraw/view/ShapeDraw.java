/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw.view;

import java.awt.Color;
import simpledraw.model.Circle;
import simpledraw.model.Line;
import simpledraw.model.ShapeGroup;
import java.awt.Graphics2D;
import simpledraw.model.Shape;

/**
 *
 * @author Eva
 */
public class ShapeDraw implements ShapeVisitor {

    @Override
    public void visit(Line line, Graphics2D g) {
        g.setColor(
                line.isSelected()
                ? Color.red
                : Color.black
        );
        g.drawLine(line.myStart.x, line.myStart.y, line.myEnd.x, line.myEnd.y);
    }

    @Override
    public void visit(Circle circle, Graphics2D g) {
        g.setColor(
                circle.isSelected()
                ? Color.red
                : Color.black
        );
        g.drawOval(circle.myCenter.x - circle.myRadius,
                circle.myCenter.y - circle.myRadius,
                circle.myRadius * 2,
                circle.myRadius * 2
        );
    }

    @Override
    public void visit(ShapeGroup group, Graphics2D g) {
        group.group.forEach((s) -> {
            s.accept(this, g);
        });
    }
}
