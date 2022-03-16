/**
 * This is a boardable interface for pets
 *
 * @author Vidyoot Senthilvenkatesh
 * @version 3/16/2022
 */
public interface Boardable {
    void setBoardStart(int month, int day, int year);
    void setBoardEnd(int month, int day, int year);
    boolean boarding(int month, int day, int year);
}
