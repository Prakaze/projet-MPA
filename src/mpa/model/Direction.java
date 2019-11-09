package mpa.model;

/**
 * Simple cardinal direction
 * @author loicv
 *
 */
public enum Direction {
	NORTH("Nord"),
	EAST("Est"),
	SOUTH("Sud"),
	WEST("Ouest");
	
	private String name;
	
	/**
	 * Constructor with the name of the direction.
	 * THIS NAME SHOULD BE VALID AS A FILE NAME, DO NOT INCLUDE SPECIAL CHARACTERS
	 * @param name the name of the direction
	 */
	private Direction(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return the name of the direction
	 */
	public String getName() {
		return this.name;
	}
}
