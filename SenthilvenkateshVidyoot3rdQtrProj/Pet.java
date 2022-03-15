import java.time.LocalDate;
import java.util.regex.Pattern;

public class Pet implements Boardable {

    private final String name;
    private final String ownerName;
    private final String color;
    private String ownerEmail;
    protected int Gender;

    private LocalDate boardingStartDate;
    private LocalDate boardingEndDate;

    private static final LocalDate MINDATE = LocalDate.of(2012, 1, 1);
    private static final LocalDate MAXDATE = LocalDate.of(2022, 12, 31);

    public static final String EMAIL_VALIDATION_PATTERN = "^(.+)@(\\S+)$";

    public Pet(String name, String ownerName, String ownerEmail, String color){
        this.name = name;
        this.ownerName = ownerName;
        setOwnerEmail(ownerEmail);
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
        return switch (Gender) {
            case 404 -> "Unspecified";
            case 0 -> "Male";
            case 1 -> "Female";
            case 2 -> "Neutered";
            case 3 -> "Spayed";
            default -> "unspecified";
        };
    }

    public String getEmail() {
        return ownerEmail;
    }

    @Override
    public String toString(){
        String finalString;
        finalString = String.format("%s owned by %s\nOwner's email: %s\nPet Color: %s\nGender: %s", getPetName(), getOwnerName(), getEmail(), getColor(), getGender());
        return finalString;
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

        if(boardingStartDate == null || !EndBoardingDate.isBefore(boardingStartDate)){
            if(!EndBoardingDate.isBefore(MINDATE) && !EndBoardingDate.isAfter(MAXDATE)) {
                boardingEndDate = EndBoardingDate;
                return;
            }
        }
    }

    public boolean boarding(int month, int day, int year) {

        if(month < 0 ||  month > 12 || day < 0 || day > 31) {
            throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
        }

        if(boardingStartDate == null || boardingEndDate == null) {
            return false;
        }

        LocalDate boardingDate = LocalDate.of(year, month, day);

        if((!boardingEndDate.isBefore(boardingStartDate))){
            if(boardingDate.isBefore(MINDATE) || boardingDate.isAfter(MAXDATE)) {
                throw new IllegalDateException("Illegal Date:", month + "/" + day + "/"+ year);
            }
        }

        if (boardingStartDate.compareTo(boardingDate) != 0){
            return false;
        }
        else {
            return true;
        }
    }

    public LocalDate getBoardingStartDate() {
        return boardingStartDate;
    }

    public String getBoardingEndDate() {
        return boardingEndDate.toString();
    }

    public void setOwnerEmail(String ownerEmail){
        if (Pattern.compile(EMAIL_VALIDATION_PATTERN).matcher(ownerEmail).matches()){
            this.ownerEmail = ownerEmail;
        }
        else {
            throw new IllegalEmailException("Illegal Email: " + ownerEmail);
        }
    }

    public String guiPrint(){
        return String.format("\u2192 %s is owned by %s. Started boarding on %s and ended boarding on %s. \n\n", getPetName().toUpperCase(), getOwnerName(), boardingStartDate, getBoardingEndDate());
    }

}
