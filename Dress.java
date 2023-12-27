public class Dress extends Clothing {
    private String length;
    private String style;
    private String color;

    public Dress(String length, String style, String color, int size, double price, int numInStock) {
        super(size, price, numInStock); // inherits from parent class - Clothing
        this.length = length;
        this.style = style;
        this.color = color;
    }

    // getters and setters

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
