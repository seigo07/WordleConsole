package stacs.wordle;

/**
 * Colors
 * @author Seigo
 */
public enum Colors {

    YELLOW("\u001b[43;1m"),
    GREEN("\u001b[42;1m"),
    GRAY("\u001b[40;1m"),
    WHITE("\033[0m"),
    ;

    private String code;

    /**
     * constructor
     * @param code
     */
    Colors(String code) {
        this.code = code;
    }

    /**
     * getter code
     * @return code
     */
    public String getCode() {
        return this.code;
    }

}
