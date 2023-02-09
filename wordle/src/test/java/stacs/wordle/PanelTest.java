package stacs.wordle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PanelTest
 * @author Seigo
 */
class PanelTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Get a initial letter.
     * @result Test letter is set ' ' after initialization.
     */
    @Test
    public void shouldGetInitialLetter()
    {
        Panel panel = new Panel();
        assertEquals(' ', panel.getLetter());
    }

    /**
     * Get a initial color.
     * @result Test color is set GRAY after initialization.
     */
    @Test
    public void shouldGetInitialColor()
    {
        Panel panel = new Panel();
        assertEquals(Colors.GRAY, panel.getColor());
    }

    /**
     * Set a letter.
     * @result Letter should be 'A' after being called setLetter with 'A'.
     */
    @Test
    public void shouldSetLetter()
    {
        Panel panel = new Panel();
        panel.setLetter('A');
        assertEquals('A', panel.getLetter());
    }

    /**
     * Set a Color.
     * @result Color should be YELLOW after being called setColor with YELLOW.
     */
    @Test
    public void shouldSetColor()
    {
        Panel panel = new Panel();
        panel.setColor(Colors.YELLOW);
        assertEquals(Colors.YELLOW, panel.getColor());
    }

}