package mpa.maths.sdfs;

import mpa.maths.Vector2D;

/**
 * SDF (or Signed Distance Function), used to draw shapes. Very useful in cases
 * where we want some shapes to have a global effect on the image.
 * @author loicv
 *
 */
public abstract class SDF {
	
	public abstract double getDistance(Vector2D position);
	
	/**
	 * 
	 * @param sdf
	 * @return an SDF corresponding to the OR operation between this SDF and another SDF
	 */
	public SDF or(SDF sdf) {
		return new OrSDF(this, sdf);
	}
	
	/**
	 * 
	 * @param sdf
	 * @return an SDF corresponding to the AND operation between this SDF and another SDF
	 */
	public SDF and(SDF sdf) {
		return new AndSDF(this, sdf);
	}
}
