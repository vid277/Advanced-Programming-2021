public class Dog extends Pet{

    private String size;

    public Dog(String name, String ownerName, String ownerEmail, String color, String size) {
        super(name, ownerName, ownerEmail, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public String toString(){
        return String.format("");
    }

}
