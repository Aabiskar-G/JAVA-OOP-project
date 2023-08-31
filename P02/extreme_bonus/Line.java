public class Line{
	
	private double x1, y1, x2, y2;
	private Color color;
	
	public Line(double x1, double y1, double x2, double y2, Color color){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	@Override
	public String toString() {
		return color + " (" + x1 + ", " + y1 + "),-(" + x2 + ", " + y2 + ")";
	}

	public double length() {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}
