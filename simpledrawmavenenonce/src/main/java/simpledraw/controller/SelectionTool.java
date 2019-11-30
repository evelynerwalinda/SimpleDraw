package simpledraw.controller;

import simpledraw.controller.DrawingTool;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import simpledraw.view.DrawingPanel;
import simpledraw.model.Shape;
import simpledraw.model.ShapeGroup;

/**
 * The tool to select, move and delete Shapes in the Drawing
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class SelectionTool
        extends DrawingTool {

    private Shape mySelectedShape = null;
    private Point myLastPoint;
    private ShapeGroup mySelectedGroup = null;

    public SelectionTool(DrawingPanel panel) {
        super(panel);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {
            if (mySelectedShape != null) {
                myDrawing.deleteShape(mySelectedShape);
                myPanel.repaint();
            }
        }

        if (e.getKeyChar() == 'g' || e.getKeyChar() == 'G') {
            if (mySelectedGroup == null) {
                mySelectedGroup = new ShapeGroup();
                myPanel.l.setForeground(Color.red);
                System.out.println("touche g appuyée");
            }
        }
        if (e.getKeyChar() == 'u' || e.getKeyChar() == 'U') {
            if (mySelectedGroup != null) {
                mySelectedGroup.setSelected(false);
                mySelectedGroup = null;
                myPanel.l.setForeground(Color.black);
                myPanel.repaint();
                System.out.println("touche u appuyée");
            }

        }
    }

    public void mousePressed(MouseEvent e) {
        Shape pickedShape = myDrawing.pickShapeAt(e.getPoint());
        myLastPoint = e.getPoint();

        if (mySelectedGroup != null) {
            if (pickedShape != null) {
                mySelectedGroup.addShape(pickedShape);
                System.out.println("forme ajoutée au groupe");
                mySelectedGroup.setSelected(true);
            }
        } else if (mySelectedShape != null) {
            mySelectedShape.setSelected(false);
        }
        mySelectedShape = pickedShape;
        if (mySelectedShape != null) {
            mySelectedShape.setSelected(true);
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
        myPanel.repaint();
    }

    public void mouseReleased(MouseEvent e) {
        mouseMoved(e);
    }

    public void mouseMoved(MouseEvent e) {
        Shape pickedShape = myPanel.myDrawing.pickShapeAt(e.getPoint());
        if (pickedShape != null) {
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            myPanel.setCursor(Cursor.getDefaultCursor());
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (mySelectedGroup != null) {
            mySelectedGroup.translateBy(
                    e.getX() - myLastPoint.x,
                    e.getY() - myLastPoint.y
            );
            myLastPoint = e.getPoint();
            myPanel.repaint();

        } else if (mySelectedShape != null) {
            mySelectedShape.translateBy(
                    e.getX() - myLastPoint.x,
                    e.getY() - myLastPoint.y
            );
            myLastPoint = e.getPoint();
            myPanel.repaint();
        }
    }

    @Override
    public void draw(Graphics2D g) {
    }

}
