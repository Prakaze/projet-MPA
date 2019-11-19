package mpa.model;

import mpa.maths.Vector2D;
import static mpa.model.Axis.HORIZONTAL;
import static mpa.model.Axis.VERTICAL;

/**
 * Simple cardinal direction
 * @author loicv
 *
 */
public enum Direction {
	
	NORTH("Nord", VERTICAL, true),
	EAST("Est", HORIZONTAL, false),
	SOUTH("Sud", VERTICAL, false),
	WEST("Ouest", HORIZONTAL, true);
	
	private String name;
	private Axis axis;
	private boolean isInverse;
	
	/**
	 * 
	 * @param axis
	 * @param inverseNormal
	 */
	private Direction(String name, Axis axis, boolean isInverse) {
		this.name = name;
		this.axis = axis;
		this.isInverse = isInverse;
	}
	
	/**
	 * 
	 * @return the axis of the direction
	 */
	public Axis getAxis() {
		return this.axis;
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return the normal vector of the direction (the vector pointing in the direction)
	 */
	public Vector2D getNormal() {
		return this.isInverse ? this.axis.getNormal().mult(-1) : this.axis.getNormal();
	}
}
