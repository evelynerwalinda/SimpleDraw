package simpledraw.view;

import simpledraw.controller.SelectionTool;
import simpledraw.controller.DrawingTool;
import simpledraw.model.Drawing;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import simpledraw.controller.CircleTool;
import simpledraw.controller.LineTool;
import simpledraw.model.Shape;

/**
 * A Panel that displays a Drawing, and maintains a current DrawingTool<BR>
 * Uses the "State" design pattern
 *
 * @author Rémi Bastide
 * @version 1.0
 * @see simpledraw.Drawing
 * @see simpledraw.DrawingTool
 */
public class DrawingPanel
        extends JPanel implements DrawingView {

    DrawingTool myCurrentTool;
    public Drawing myDrawing = new Drawing();
    public JLabel l = new JLabel();

    public DrawingPanel() {
        super();
        setBackground(java.awt.Color.white);
        myCurrentTool = new SelectionTool(this);
        activate(myCurrentTool);
        l.setText("press g to group, u to ungroup");
        add(l);
    }

    public void activateSelectionTool() {
        terminate(myCurrentTool);
        myCurrentTool = new SelectionTool(this);
        activate(myCurrentTool);
    }

    public void activateCircleTool() {
        terminate(myCurrentTool);
        myCurrentTool = new CircleTool(this);
        activate(myCurrentTool);
        myDrawing.clearSelection();
        repaint();
    }

    public void activateLineTool() {
        terminate(myCurrentTool);
        myCurrentTool = new LineTool(this);
        activate(myCurrentTool);
        myDrawing.clearSelection();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(qualityHints);
        //myDrawing.draw(g2);
        for (Shape s : myDrawing.myShapes) {
            s.accept(new ShapeDraw(), g2);            
        }
        
        myCurrentTool.accept(new ToolDraw(), g2);
        
        //myCurrentTool.draw(g2);
    }

    private void terminate(DrawingTool t) {
        removeKeyListener(t);
        removeMouseListener(t);
        removeMouseMotionListener(t);
    }

    private void activate(DrawingTool t) {
        addKeyListener(t);
        addMouseListener(t);
        addMouseMotionListener(t);
    }

    @Override
    public void notify(Drawing model) {
        repaint();
    }

    /*public void draw(Graphics2D g) {        
	for(Shape s : myDrawing.getShapes())
                s.draw(g);
	}*/
    public DrawingTool getTool() {
        return myCurrentTool;
    }
}
