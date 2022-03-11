public class Cat extends Pet{
    private String hairLength;

    public Cat(String name, String ownerName, String ownerEmail, String color, String hairLength){
        super(name, ownerName, ownerEmail, color);
        this.hairLength = hairLength;
    }

    public String getHairLength(){
        return hairLength;
    }

    public String toString(){
        return "CAT:\n" + super.toString() + "\n Hair Length: " + getHairLength();
    }
}
