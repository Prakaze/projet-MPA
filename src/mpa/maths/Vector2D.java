package mpa.maths;

/**
 * Utility class for 2D vector calculus
 * @author loicv
 *
 */
public class Vector2D {
	
	public double x, y;
	
	public Vector2D() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D copy() {
		return new Vector2D(this.x, this.y);
	}
	
	public Vector2D add(Vector2D other) {
		this.x += other.x;
		this.y += other.y;
		return this;
	}
	
	public Vector2D sub(Vector2D other) {
		this.x -= other.x;
		this.y -= other.y;
		return this;
	}
	
	public double distance(Vector2D other) {
		return Math.sqrt(distanceSquared(other));
	}
	
	public double distanceSquared(Vector2D other) {
		double distX = this.x - other.x;
		double distY = this.y - other.y;
		return distX + distY;
	}
	
	public double dot(Vector2D other) {
		return this.x * other.x + this.y * other.y;
	}
	
	public Vector2D mult(double d) {
		this.x *= d;
		this.y *= d;
		return this;
	}
	
	public Vector2D mult(Vector2D other) {
		this.x *= other.x;
		this.y *= other.y;
		return this;
	}
	
	public double length() {
		return Math.sqrt(this.lengthSquared());
	}
	
	public double lengthSquared() {
		return this.x*this.x + this.y*this.y;
	}
}
