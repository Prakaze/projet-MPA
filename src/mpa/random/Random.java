package mpa.random;

/**
 * Helper class to avoid re-writing random number generating code
 * @author loicv
 *
 */
public class Random {
	
	/**
	 * 
	 * @param maxValue the maximum
	 * @return a random int between 0 (included) and a maximum (excluded)
	 */
	public static int nextInt(int maxValue) {
		return (int)(Math.random() * maxValue);
	}
	
	/**
	 * 
	 * @param minValue the minimum
	 * @param maxValue the maximum
	 * @return a random int between a minimum (included) and a maximum (excluded)
	 */
	public static int nextInt(int minValue, int maxValue) {
		return minValue + (int)(Math.random() * (maxValue - minValue));
	}
}
