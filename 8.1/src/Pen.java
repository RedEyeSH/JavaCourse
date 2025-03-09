public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override public String toString() { return color; }
    }

    // your code here
    private Color color;
    private boolean isCapOn;

    public Pen() {
        this.color = Color.RED;
        this.isCapOn = true;
    }

    public Pen(Color color) {
        this.color = color;
        this.isCapOn = true;
    }

    public void capOff() {
        isCapOn = false;
    }

    public void capOn() {
        isCapOn = true;
    }

    public void changeColor(Color color) {
        if (isCapOn) {
            this.color = color;
        }
    }

    public String draw() {
        return isCapOn ? "" : "Drawing " + color;
    }
}