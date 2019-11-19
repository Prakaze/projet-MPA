package mpa.maths.random;

import mpa.maths.Vector2D;

/**
 * temporary class to test seed based noise textures, not used for now
 * @author loicv
 *
 */
public class PseudoRandom {
	
	private static int OCTAVES = 5;
	
	/**
	 * 
	 * @param position
	 * @param seed
	 * @return
	 */
	public static double hash(Vector2D position, int seed) {
		double x = Math.sin(seed) + Math.sin(position.x);
		double y = Math.sin(seed) + Math.sin(position.y);
		double length = Math.sqrt(x*x*183225.1351+y*y*165254.1654);
		return length - (int)length;
	}
	
	/**
	 * 
	 * @param point the uv of the texture, looks the best when the coordinates go from 0 to 1
	 * @param seed
	 * @return
	 */
	public static double noiseTexture(Vector2D point, int seed) {
		
		//settings, here for now for testing purposes
		double smoothness = 1.7;
		double variations = 1.5; //subject to clipping when over 1
		
		point = point.copy();
		double result = 0.0;
		double sumInfluence = 0.0;
		double influence = 1.0;
		
		
		for(int i = 0; i < OCTAVES; i++) {
			
			int roundedX = (int)point.x;
			int roundedY = (int)point.y;
			
			Vector2D tl = new Vector2D(roundedX, roundedY);
			Vector2D tr = new Vector2D(roundedX+1, roundedY);
			Vector2D bl = new Vector2D(roundedX, roundedY+1);
			Vector2D br = new Vector2D(roundedX+1, roundedY+1);
			
			double interpolationX = point.x - roundedX;
			double interpolationY = point.y - roundedY;
			
			double t = hash(tr, seed) * interpolationX + hash(tl, seed) * (1.0-interpolationX);
			double b = hash(br, seed) * interpolationX + hash(bl, seed) * (1.0-interpolationX);
			
			result += influence * (b * interpolationY + t * (1.0 - interpolationY));
			sumInfluence += influence;
			influence /= smoothness;
			point.mult(2.0);
		}
		
		result /= sumInfluence;
		
		return .5 + (result-.5)*variations;
	}
}
