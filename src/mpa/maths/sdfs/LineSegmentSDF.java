package mpa.maths.sdfs;

import mpa.maths.Vector2D;

/**
 * SDF representing a line segment (a straight line between two points)
 * @author loicv
 *
 */
public class LineSegmentSDF extends SDF{
	
	public Vector2D firstPoint, secondPoint;
	
	public double thickness;
	
	public LineSegmentSDF(Vector2D firstPoint, Vector2D secondPoint, double thickness) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		this.thickness = thickness;
	}
	
	public double getDistance(Vector2D position) {
		
		if(this.firstPoint == null || this.secondPoint == null) return Double.MAX_VALUE;
		
		Vector2D pa = position.copy().sub(firstPoint), ba = secondPoint.copy().sub(firstPoint);
		double h = Math.max(Math.min(pa.dot(ba)/ba.dot(ba), 1.0), 0.0);
		return pa.sub(ba.mult(h)).length() - this.thickness;
	}
}
