package stacs.wordle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ColorsTest
 * @author Seigo
 */
class ColorsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Get a yellow color code.
     * @result Test whether YELLOW has "\u001b[43;1m" color code or not.
     */
    @Test
    public void shouldGetYellowCode()
    {
        Colors yellowColor = Colors.YELLOW;
        assertEquals("\u001b[43;1m", yellowColor.getCode());
    }

    /**
     * Get a green color code.
     * @result Test whether GREEN has "[42;1m" color code or not.
     */
    @Test
    public void shouldGetGreenCode()
    {
        Colors greenColor = Colors.GREEN;
        assertEquals("\u001b[42;1m", greenColor.getCode());
    }

    /**
     * Get a gray code.
     * @result Test whether GRAY has "\u001b[40;1m" color code or not.
     */
    @Test
    public void shouldGetGrayCode()
    {
        Colors grayColor = Colors.GRAY;
        assertEquals("\u001b[40;1m", grayColor.getCode());
    }

    /**
     * Get a white code.
     * @result Test whether WHITE has "\u001b[40;1m" color code or not.
     */
    @Test
    public void shouldGetWhiteCode()
    {
        Colors whiteColor = Colors.WHITE;
        assertEquals("\033[0m", whiteColor.getCode());
    }

}