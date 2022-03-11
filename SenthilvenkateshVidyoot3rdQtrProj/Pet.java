import java.time.LocalDate;

public class Pet implements Boardable {

    private String name;
    private String ownerName;
    private String color;
    private String ownerEmail;
    protected int Gender;

    private LocalDate boardingStartDate;
    private LocalDate boardingEndDate;

    private static final LocalDate MINDATE = LocalDate.of(1950, 1, 1);
    private static final LocalDate MAXDATE = LocalDate.of(2022, 12, 31);
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED= 2;
    public static final int NEUTERED = 3;


    public Pet(String name, String ownerName, String ownerEmail, String color){
        this.name = name;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.color = color;
        Gender = 404;
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

    public String getGender() {
        switch(Gender) {
            case 404:
                return "Unspecified";
            case 0:
                return "Male";
            case 1:
                return "Female";
            case 4:
                return "Spayed";
            case 3:
                return "Neutered";
        }
        return "unspecified";
    }

    public String getEmail() {
        return ownerEmail;
    }

    public String toString(){
        return String.format("");
    }

    public void setBoardStart(int month, int day, int year) {
        if(month < 0 ||  month > 12 || day < 0 || day > 31) {
            throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
        }

        LocalDate StartBoardingDate = LocalDate.of(year, month, day);
        if((boardingEndDate == null || !StartBoardingDate.isAfter(boardingEndDate))){
            if(!StartBoardingDate.isBefore(MINDATE) && StartBoardingDate.isBefore(MAXDATE)) {
                boardingStartDate = StartBoardingDate;
            }
        }

    }

    public void setBoardEnd(int month, int day, int year) {
        if(month < 0 ||  month > 12 || day < 0 || day > 31) {
            throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
        }

        LocalDate EndBoardingDate = LocalDate.of(year, month, day);

        if((boardingStartDate == null || !boardingEndDate.isBefore(boardingStartDate))){
            if(!EndBoardingDate.isBefore(MINDATE) && EndBoardingDate.isBefore(MAXDATE)) {
                boardingStartDate = EndBoardingDate;
            }
        }
    }

    public boolean boarding(int month, int day, int year) {
        boolean isBoarded = false;

        if(month < 0 ||  month > 12 || day < 0 || day > 31) {
            throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
        }

        if(boardingStartDate == null || boardingEndDate == null) {
            return false;
        }

        LocalDate boardingDate = LocalDate.of(month, day, year);

        if (boardingStartDate == boardingEndDate){
            return false;
        }

        if((boardingStartDate == null || !boardingEndDate.isBefore(boardingStartDate))){
            if(boardingDate.isBefore(MINDATE) || boardingDate.isAfter(MAXDATE)) {
                throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
            }
        }

        if (boardingDate.compareTo(boardingStartDate) >= 0 && boardingStartDate.compareTo(boardingEndDate) <= 0) {
            isBoarded = true;
        }
        else{
            isBoarded = false;
        }

        return isBoarded;
    }
}
