package stacs.wordle;

/**
 * Panel
 * @author Seigo
 */
public class Panel {

    private char letter;
    private Colors color;

    /**
     * constructor
     * @param
     */
    public Panel() {
        this.letter = ' ';
        this.color = Colors.GRAY;
    }

    /**
     * getter letter
     * @return letter
     */
    public char getLetter() {
        return letter;
    }

    /**
     * getter color
     * @return color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * setter letter
     * @param letter
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * setter color
     * @param color
     */
    public void setColor(Colors color) {
        this.color = color;
    }

}
