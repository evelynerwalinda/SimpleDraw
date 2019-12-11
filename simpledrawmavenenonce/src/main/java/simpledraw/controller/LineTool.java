package simpledraw.controller;

import simpledraw.view.DrawingPanel;
import simpledraw.controller.DrawingTool;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import simpledraw.model.Line;
import simpledraw.view.ToolVisitor;

/**
 * The tool to create Lines
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.model.Line
 */

public class LineTool
	extends DrawingTool {
	public boolean iAmActive = false;
	public Point myInitialPoint;
	public Point myFinalPoint;

	public LineTool(DrawingPanel panel) {
		super(panel);
	}

        @Override
	public void mousePressed(MouseEvent e) {
		if (!iAmActive) {
			// First point
			iAmActive = true;
			myInitialPoint = e.getPoint();
			myFinalPoint = myInitialPoint;
			myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.
				MOVE_CURSOR));
                        myPanel.notify(myDrawing);
			//myPanel.repaint();
		} else {
			// Second point
			iAmActive = false;
			myDrawing.addShape(
				new Line(myInitialPoint, myFinalPoint)
				);
			myPanel.setCursor(Cursor.getDefaultCursor());
                        myPanel.notify(myDrawing);
			//myPanel.repaint();
		}
	}

        @Override
	public void mouseDragged(MouseEvent e) {
		if (iAmActive) {
			myFinalPoint = e.getPoint();
                        myPanel.notify(myDrawing);
			//myPanel.repaint();
		}
	}

        @Override
	public void mouseMoved(MouseEvent e) {
            mouseDragged(e);
        }
        
        /*@Override
	public void draw(Graphics2D g) {
		if (iAmActive) {
			g.setColor(Color.red);
			g.drawLine(
				myInitialPoint.x,
				myInitialPoint.y,
				myFinalPoint.x,
				myFinalPoint.y
				);
		}
	}*/
        
        @Override
        public void accept(ToolVisitor v, Graphics2D g){
            v.visit(this, g);
        }
}
