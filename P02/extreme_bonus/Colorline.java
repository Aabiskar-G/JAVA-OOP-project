public class ColorLine {
    public static void main(String[] args) {
        System.out.println("Default Color: " + Color.getDefaultColor());

        for (Color color : Color.values()) {
            System.out.println(color);
        }
    }
}

