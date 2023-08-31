public class TestLine{
	public static void main(String[] args) {
		Line line1 = new Line(1.23, 2.23, 3.34, 4.34, Color.PURPLE);
		Line line2 = new Line(2.23, 3.23, 5.34, 6.34, Color.BLACK;
		Line line3 = new Line(0.00, 0.00, 7.34, 8.34, Color.WHITE);
		Line line4 = new Line(4.23, 5.23, 7.34, 9.34, Color.CYAN);
		
		
		Line[] lines = {line1, line2,line3,line4};
		
		for (Line line : lines){
			System.out.println(line+ " has length " + line.length());
		}
	}
}
