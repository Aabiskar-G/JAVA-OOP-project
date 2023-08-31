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


