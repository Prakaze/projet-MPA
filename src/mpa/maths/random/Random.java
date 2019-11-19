package mpa.maths.random;

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
	
	/**
	 * 
	 * @param maxValue the maximum
	 * @return a random double between 0 (included) and a maximum (excluded)
	 */
	public static double nextDouble(double maxValue) {
		return Math.random() * maxValue;
	}
	
	/**
	 * 
	 * @param minValue the minimum
	 * @param maxValue the maximum
	 * @return a random double between a minimum (included) and a maximum (excluded)
	 */
	public static double nextDouble(double minValue, double maxValue) {
		return minValue + Math.random() * (maxValue - minValue);
	}
	
	/**
	 * 
	 * @param array
	 * @return an element from the array
	 */
	public static <T> T nextElement(T[] array){
		return array[nextInt(array.length)];
	}
}
