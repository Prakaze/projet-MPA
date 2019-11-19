package mpa.maths.sdfs;

import mpa.maths.Vector2D;

public class EmptySDF extends SDF {

	@Override
	public double getDistance(Vector2D position) {
		return Double.MAX_VALUE;
	}
	
	@Override
	public SDF or(SDF sdf) {
		return sdf;
	}
	
	@Override
	public SDF and(SDF sdf) {
		return sdf;
	}
}
