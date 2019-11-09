package mpa.io;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import mpa.model.MapTile;
import mpa.model.MapTileCategory;

/**
 * 
 * @author loicv
 *
 */
public class MapTileWriter {
	
	private String path;
	private String format;
	
	public MapTileWriter(String path, String format) {
		this.path = path;
		this.format = format;
		
		for(MapTileCategory category : MapTileCategory.values()) {
			File directory = new File(this.path + category.getName() + "/");
		    if(!directory.exists()) directory.mkdirs();
		}
	}
	
	/**
	 * Writes a map tile into a file.
	 * 
	 * The files are saves in a file system with this architecture:
	 * 	[path]
	 * 		L [category]
	 * 			L [UUID].[format]
	 * 
	 * For instance:
	 * 	./output
	 * 		L Nord-Nord
	 * 			L 7ec9f112-c6e8-4b1b-9e48-b2a9fca893fc.png
	 * 			L 7ec5631f-bfdb-4c07-8fb3-26a0ee5da6a9.png
	 * 			L ...
	 * 		L Nord-Est
	 * 			L 50bfb10c-2e3f-4646-8350-24099bb7a191.png
	 * 			L ...
	 * 		L ...
	 * 
	 * @param tile the tile to save
	 * @throws IOException
	 */
	public void write(MapTile tile) throws IOException {
		
		File file = new File(this.path + tile.getCategory().getName() + "/" + UUID.randomUUID() + "." + this.format);
        ImageIO.write(tile.getImage(), this.format, file);
	}
}
