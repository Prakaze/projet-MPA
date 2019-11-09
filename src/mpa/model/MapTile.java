package mpa.model;

import java.awt.image.BufferedImage;

/**
 * 
 * @author loicv
 *
 */
public class MapTile {
	
	private BufferedImage image;
	private MapTileCategory category;
	
	public MapTile(BufferedImage image, MapTileCategory category) {
		this.image = image;
		this.category = category;
	}
	
	/**
	 * 
	 * @return the image of the map tile
	 */
	public BufferedImage getImage() {
		return image;
	}
	
	/**
	 * 
	 * @return the category of the map tile
	 */
	public MapTileCategory getCategory() {
		return category;
	}
}
