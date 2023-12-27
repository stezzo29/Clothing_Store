public class Clothing {
    private int size;
    private double price;
    private int numInStock;

    public Clothing(int size, double price, int numInStock) {
        this.size = size;
        this.price = price;
        this.numInStock = numInStock;
    }

    // getters and setters

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }
}


