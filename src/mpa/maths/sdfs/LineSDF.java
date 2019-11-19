package mpa.maths.sdfs;

import java.util.Collection;
import java.util.Iterator;

import mpa.maths.Vector2D;

/**
 * SDF representing a multi-vertices line (linked line segments)
 * @author loicv
 *
 */
public class LineSDF extends SDF {
	
	private SDF segmentsSDF;
	
	public LineSDF(Collection<Vector2D> points, double thickness) {
		this.segmentsSDF = new EmptySDF();
		if(points.size() >= 2) {
			Iterator<Vector2D> iterator = points.iterator();
			Vector2D previous = iterator.next();
			while(iterator.hasNext()) {
				Vector2D current = iterator.next();
				SDF line = new LineSegmentSDF(previous, current, thickness);
				segmentsSDF = segmentsSDF.or(line);
				previous = current;
			}
		}
	}

	@Override
	public double getDistance(Vector2D position) {
		return this.segmentsSDF.getDistance(position);
	}

}
