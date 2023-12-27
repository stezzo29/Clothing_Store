public class Pant extends Clothing {

    private int inseam;
    private String color;
    private String style;

    public Pant(int inseam, String color, String style, int size, double price, int numInStock) {
        super(size, price, numInStock); // inherits from parent - Clothing
        this.inseam = inseam;
        this.color = color;
        this.style = style;
    }

    // getters and setters

    public int getInseam() {
        return inseam;
    }

    public void setInseam(int inseam) {
        this.inseam = inseam;
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
