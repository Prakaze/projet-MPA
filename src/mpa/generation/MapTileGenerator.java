package mpa.generation;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

import mpa.maths.Vector2D;
import mpa.maths.random.Random;
import mpa.maths.random.PseudoRandom;
import mpa.maths.sdfs.EmptySDF;
import mpa.maths.sdfs.LineSDF;
import mpa.maths.sdfs.LineSegmentSDF;
import mpa.maths.sdfs.SDF;
import mpa.model.Direction;
import mpa.model.MapTile;
import mpa.model.MapTileCategory;

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
		
		int seed = Random.nextInt(10000);
		
		int height = Random.nextInt(50, 150);
		int width = Random.nextInt(50, 150);
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		MapTileCategory category = MapTileCategory.getRandomMapTileCategory();
		
		SDF sdf = generateLines(category, width, height);
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				Vector2D position = new Vector2D(x, y);
				Color color;
				
				double distance = sdf.getDistance(position.copy());
				
				int value;
				
				//basic testing function for the noise textures
				if(distance < width+height)
					value = (int)(PseudoRandom.noiseTexture(position.copy().mult(1.0/height), seed) * 2.0*(30.0 + distance) + distance);
				else 
					value = (int)(PseudoRandom.noiseTexture(position.copy().mult(1.0/height), seed) * 255.0);
					
				double interpolationFactor = Math.max(Math.min(distance, .5), -.5) + .5; //for antialiasing
				value = (int)(interpolationFactor * (value) + (1.0-interpolationFactor) * (255));
				value = Math.min(Math.max(value, 0), 255);
				color = new Color(value, value, value);
				
				image.setRGB(x, y, color.getRGB());
			}
		}
		
		return new MapTile(image, category);
	}
	
	/**
	 * creates an SDF representing a path corresponding to the given category
	 * @param category
	 * @param width
	 * @param height
	 * @return
	 */
	private SDF generateLines(MapTileCategory category, int width, int height) {
		
		Collection<Vector2D> endPoints = new ArrayList<Vector2D>();
		double lineThickness = Random.nextDouble(1, 5);
		SDF sdf = new EmptySDF();
		
		for(Direction direction : Direction.values()) {
			if(category.goesInDirection(direction)) {
				double rand = Random.nextDouble(-.5, .5);
				Vector2D normal = direction.getNormal();
				Vector2D crossNormal = new Vector2D(normal.y, -normal.x).mult(rand);
				
				//this would take too long to explain ...
				Vector2D start = normal.copy().mult(.5).add(crossNormal).add(new Vector2D(.5, .5)).mult(new Vector2D(width, height));
				Vector2D end = normal.copy().mult(Random.nextDouble(.5)).add(crossNormal).add(new Vector2D(.5, .5)).mult(new Vector2D(width, height));
				
				endPoints.add(end);
				SDF lineSegmentSDF = new LineSegmentSDF(start, end, lineThickness);
				sdf = sdf.or(lineSegmentSDF);
			}
		}
		if(endPoints.size() >= 2) sdf = sdf.or(new LineSDF(endPoints, lineThickness));
		return sdf;
	}
}
