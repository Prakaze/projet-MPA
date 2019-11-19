package mpa.maths.sdfs;

import mpa.maths.Vector2D;

/**
 * SDF corresponding to the OR operation on two other SDFs
 * @author loicv
 *
 */
public class OrSDF extends SDF {

	private SDF sdf1, sdf2;
	
	public OrSDF(SDF sdf1, SDF sdf2) {
		this.sdf1 = sdf1;
		this.sdf2 = sdf2;
	}

	@Override
	public double getDistance(Vector2D position) {
		return Math.min(sdf1.getDistance(position), sdf2.getDistance(position));
	}

}
