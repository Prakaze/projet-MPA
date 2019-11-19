package mpa.model;

import mpa.maths.Vector2D;

/**
 * 
 * @author loicv
 *
 */
public enum Axis {
	HORIZONTAL(1, 0),
	VERTICAL(0, 1);
	
	private Vector2D normal;
	
	/**
	 * 
	 * @param x the x coordinate of the normal vector
	 * @param y the y coordinate of the normal vector
	 */
	private Axis(int x, int y) {
		this.normal = new Vector2D(x, y);
	}
	
	/**
	 * 
	 * @return a copy of the normal vector
	 */
	public Vector2D getNormal() {
		return this.normal.copy();
	}
}
