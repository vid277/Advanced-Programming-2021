public class Bird extends Pet{
    private boolean featherClipped;

    public Bird(String name, String ownerName, String ownerEmail, String color){
        super(name, ownerName, ownerEmail, color);
    }

    public void setClipped(){
        featherClipped = true;
    }

    public boolean clipped(){
        return featherClipped;
    }

    public String toString(){
        return "BIRD:\n" + super.toString();
    }

}
