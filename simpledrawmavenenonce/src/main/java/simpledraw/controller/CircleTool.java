package simpledraw.controller;

/**
 * The tool to create circles
 **/

import simpledraw.view.DrawingPanel;
import simpledraw.controller.DrawingTool;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import simpledraw.model.Circle;
import simpledraw.view.MiniPanel;
import simpledraw.view.ToolVisitor;

public class CircleTool
	extends DrawingTool {
	public boolean iAmActive = false;
	public Point myCenter;
	public int myRadius;        

	public CircleTool(DrawingPanel panel) {
		super(panel);
	}      

        @Override
	public void mousePressed(MouseEvent e) {
		if (!iAmActive) {
			// Center
			iAmActive = true;
			myCenter = e.getPoint();
			myRadius = 0;
			myPanel.setCursor(
				Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)
				);
			//myPanel.repaint(); 
                        myPanel.notify(myDrawing);
		} else {
			// Radius
			iAmActive = false;
			myDrawing.addShape(
				new Circle(myCenter, myRadius)
				);
			myPanel.setCursor(Cursor.getDefaultCursor());
			//myPanel.repaint();
                        myPanel.notify(myDrawing);
		}
	}

        @Override
	public void mouseMoved(MouseEvent e) {
		if (iAmActive) {
			myRadius = (int) (
				myCenter.distance(e.getPoint())
				);
			//myPanel.repaint();
                        myPanel.notify(myDrawing);
		}
	}
        @Override
	public void mouseDragged(MouseEvent e) {
            mouseMoved(e);
        }

        /*@Override
	public void draw(Graphics2D g) {
		if (iAmActive) {
			g.setColor(Color.red);
			g.drawOval(
				myCenter.x - myRadius,
				myCenter.y - myRadius,
				myRadius * 2,
				myRadius * 2
				);
		}
	}*/

    @Override
    public void accept(ToolVisitor v, Graphics2D g) {
        v.visit(this, g);
    }
    
    
}