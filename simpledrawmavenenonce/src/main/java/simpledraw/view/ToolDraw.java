/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw.view;

import java.awt.Color;
import java.awt.Graphics2D;
import simpledraw.controller.CircleTool;
import simpledraw.controller.LineTool;
import simpledraw.controller.SelectionTool;

/**
 *
 * @author Eva
 */
public class ToolDraw implements ToolVisitor{

    @Override
    public void visit(LineTool lt, Graphics2D g) {
        if (lt.iAmActive) {
			g.setColor(Color.red);
			g.drawLine(
				lt.myInitialPoint.x,
				lt.myInitialPoint.y,
				lt.myFinalPoint.x,
				lt.myFinalPoint.y
				);
		}
    }

    @Override
    public void visit(CircleTool ct, Graphics2D g) {
        if (ct.iAmActive) {
			g.setColor(Color.red);
			g.drawOval(
				ct.myCenter.x - ct.myRadius,
				ct.myCenter.y - ct.myRadius,
				ct.myRadius * 2,
				ct.myRadius * 2
				);
		}
    }

    @Override
    public void visit(SelectionTool st, Graphics2D g) {

    }
    
}
