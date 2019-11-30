package simpledraw.model;

import simpledraw.model.Shape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import simpledraw.view.ShapeVisitor;

/**
 * A circle
 **/

public class Circle
	extends Shape {
	public Point myCenter;
	public int myRadius;

	/**
	 * Construct a Circle
	 * @param center        The center of the circle
	 * @param radius        The radius of the circle
	 **/
	public Circle(Point center, int radius) {
		myCenter = center;
		myRadius = radius;
	}

	/*@Override
	public void draw(Graphics2D g) {
		g.setColor(
			isSelected() ?
			Color.red :
			Color.black
			);
		g.drawOval(myCenter.x - myRadius,
			   myCenter.y - myRadius,
			   myRadius * 2,
			   myRadius * 2
			);
	}*/
        
        @Override
        public void accept(ShapeVisitor v, Graphics2D g){
            v.visit(this, g);
        }

	public void translateBy(int dx, int dy) {
		myCenter.translate(dx, dy);
	}

	public boolean isPickedBy(Point p) {
		return (Math.abs(myCenter.distance(p) - myRadius) <= 2);
	}        
}