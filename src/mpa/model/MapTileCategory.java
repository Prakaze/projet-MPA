package mpa.model;

import static mpa.model.Direction.NORTH;
import static mpa.model.Direction.EAST;
import static mpa.model.Direction.SOUTH;
import static mpa.model.Direction.WEST;

import mpa.random.Random;


/**
 * All the different classes for the map tiles.
 * The directions are given a priority starting from NORTH (highest) and going clockwise
 * to WEST (lowest), classes where the second direction has a higher priority than the
 * first don't exist to prevent duplicate like "NORTH_WEST" and "WEST_NORTH".
 * @author loicv
 *
 */
public enum MapTileCategory {
	
	NORTH_NORTH(NORTH, NORTH),
	NORTH_EAST(NORTH, EAST),
	NORTH_SOUTH(NORTH, SOUTH),
	NORTH_WEST(NORTH, WEST),
	
	EAST_EAST(EAST, EAST),
	EAST_SOUTH(EAST, SOUTH),
	EAST_WEST(EAST, WEST),
	
	SOUTH_SOUTH(SOUTH, SOUTH),
	SOUTH_WEST(SOUTH, WEST),

	WEST_WEST(WEST, WEST);
	
	private Direction firstDirection;
	private Direction secondDirection;
	
	private MapTileCategory(Direction firstDirection, Direction secondDirection) {
		this.firstDirection = firstDirection;
		this.secondDirection = secondDirection;
	}
	
	/**
	 * 
	 * @return the name of the class
	 */
	public String getName() {
		return this.firstDirection.getName() + "-" + this.secondDirection.getName();
	}
	
	/**
	 * 
	 * @return a random category
	 */
	public static MapTileCategory getRandomMapTileCategory() {
        return values()[Random.nextInt(values().length)];
    }
}
