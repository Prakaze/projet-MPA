package mpa;

import java.io.IOException;

import mpa.generation.MapTileGenerator;
import mpa.io.MapTileWriter;

/**
 * Main class
 * @author loicv
 *
 */
public class MapTileGenerationMain {

	public static void main(String[] args) {
		
		MapTileWriter mapTileWriter = new MapTileWriter("./output/", "png");
		MapTileGenerator mapTileGenerator = new MapTileGenerator();
		int imageAmount = 100;
		
		System.out.println("============ Starting generation of " + imageAmount + " images ============");
		
		for(int i = 0; i < imageAmount; i++) {
			System.out.println("generating map tile " + (i+1) + "/" + imageAmount);
			try {
				mapTileWriter.write(mapTileGenerator.generateMapTile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("============ Finished generating ============");
	}

}
