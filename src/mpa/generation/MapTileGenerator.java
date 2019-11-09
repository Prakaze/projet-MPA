package mpa.generation;

import java.awt.image.BufferedImage;

import mpa.model.MapTile;
import mpa.model.MapTileCategory;
import mpa.random.Random;

/**
 * 
 * @author loicv
 *
 */
public class MapTileGenerator {
	
	/**
	 * generates a map tile
	 * @return the generated map tile
	 */
	public MapTile generateMapTile() {
		int height = Random.nextInt(10, 150);
		int width = Random.nextInt(10, 150);
		return new MapTile(	new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR),
							MapTileCategory.getRandomMapTileCategory());
	}
}
