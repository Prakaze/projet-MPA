package mpa.model;

import java.util.HashMap;
import java.util.Map;

import mpa.maths.random.Random;

import static mpa.model.Direction.NORTH;
import static mpa.model.Direction.EAST;
import static mpa.model.Direction.SOUTH;
import static mpa.model.Direction.WEST;


/**
 * All the different classes for the map tiles.
 * @author loicv
 *
 */
public class MapTileCategory {

	public static MapTileCategory[] ALL_CATEGORIES;
	
	static {
		ALL_CATEGORIES = new MapTileCategory[16];
		for(int i = 0; i < ALL_CATEGORIES.length; i++) {
			ALL_CATEGORIES[i] = new MapTileCategory(
					((i>>0) & 1) == 1,
					((i>>1) & 1) == 1,
					((i>>2) & 1) == 1,
					((i>>3) & 1) == 1
					);
		}
	}
	
	public static MapTileCategory getRandomMapTileCategory() {
		return Random.nextElement(ALL_CATEGORIES);
	}
	
	private Map<Direction, Boolean> directions;
	
	/**
	 * 
	 * @param goesNorth
	 * @param goesEast
	 * @param goesSouth
	 * @param goesWest
	 */
	private MapTileCategory(boolean goesNorth, boolean goesEast, boolean goesSouth, boolean goesWest) {
		this.directions = new HashMap<Direction, Boolean>();
		this.directions.put(NORTH, goesNorth);
		this.directions.put(EAST, goesEast);
		this.directions.put(SOUTH, goesSouth);
		this.directions.put(WEST, goesWest);
	}
	
	
	/**
	 * 
	 * @param direction
	 * @return
	 */
	public boolean goesInDirection(Direction direction) {
		return this.directions.get(direction);
	}
	
	public String getName() {
		String name = "";
		for(Direction direction : Direction.values())
			if(this.goesInDirection(direction)) name += direction.getName();
		return name.equals("") ? "Empty" : name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for(Direction direction : Direction.values())
			result = prime * result + (this.goesInDirection(direction) ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapTileCategory other = (MapTileCategory) obj;
		if (hashCode() != other.hashCode())
			return false;
		return true;
	}
}
