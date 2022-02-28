public class Pet implements Boardable {

    private String name;
    private String ownerName;
    private String color;
    private String ownerEmail;
    protected int Gender;

    protected int monthBoardingStart;
    protected int dayBoardingStart;
    protected int yearBoardingStart;

    protected int monthBoardingEnd;
    protected int dayBoardingEnd;
    protected int yearBoardingEnd;

    public static final int MALE = 1;
    public static final int FEMALE = 1;
    public static final int SPAYED= 1;
    public static final int NEUTERED = 1;


    public Pet(String name, String ownerName, String ownerEmail, String color){
        this.name = name;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.color = color;
    }

    public String getPetName(){
        return name;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getColor() {
        return color;
    }


    public void setGender(int genderId) {
        Gender = genderId;
    }

    public int getGender() {
        return Gender;
    }

    public String getEmail() {
        return ownerEmail;
    }

    public String toString(){
        return String.format("");
    }


    public void setBoardStart(int month, int day, int year) {

    }

    public void setBoardEnd(int month, int day, int year) {

    }

    public boolean boarding(int month, int day, int year) {
        return false;
    }
}
