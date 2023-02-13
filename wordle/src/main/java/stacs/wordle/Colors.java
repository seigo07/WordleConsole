package stacs.wordle;

/**
 * Colors
 *
 * @author Seigo
 */
public enum Colors {

    /**
     * Represent yellow color
     */
    YELLOW("\u001b[43;1m"),
    /**
     * Represent green color
     */
    GREEN("\u001b[42;1m"),
    /**
     * Represent gray color
     */
    GRAY("\u001b[40;1m"),
    /**
     * Represent white color
     */
    WHITE("\033[0m"),
    ;

    private String code;

    /**
     * constructor
     *
     * @param code
     */
    Colors(String code) {
        this.code = code;
    }

    /**
     * getter code
     *
     * @return code
     */
    public String getCode() {
        return this.code;
    }

}
