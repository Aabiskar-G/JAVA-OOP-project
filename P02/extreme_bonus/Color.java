
	
	/*public class rgb{
		
		
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_BLACK= "\u001B[0m";
		public static final String ANSI_WHITE = "\u001B[37m";
		public static final String ANSI_CYAN = "\u001B[36m";
		
		public int getRGB (String[] args){
			System.out.println(ANSI_PURPLE + "0x0AA0A0A" + ANSI_RESET);
			}
		
*/
	

	

public enum Color {
	PURPLE(0x0AA0A0A),
	BLACK(0xA0A0A0A),
	WHITE(0x0A0A0AA),
	CYAN(0xAAAA000);

	private int rgb;

	private Color(int rgb){
	this.rgb = rgb;
	}
	
	public int getRGB() {
	return rgb;
	}
	
	@Override
	public String toString(){
	return name() + "(" + String.format("%#08X", getRGB())  + ")";
	}
	
	public static Color getDefaultColor(){
	return Color.PURPLE;
	}
}

