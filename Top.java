public class Top extends Clothing {
    
    private String sleeveLength;
    private String color;
    private String style;

    public Top(String sleeveLength, String color, String style, int size, double price, int numInStock) {
        super(size, price, numInStock); // inherits from parent - Clothing
        this.sleeveLength = sleeveLength;
        this.color = color;
        this.style = style;
    }

    // getters and setters

    public String getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(String sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
