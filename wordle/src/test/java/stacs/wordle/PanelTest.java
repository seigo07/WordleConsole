package stacs.wordle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PanelTest
 *
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
     *
     * @result letter should be set ' ' after initialization in constructor.
     */
    @Test
    public void shouldGetInitialLetter() {
        Panel panel = new Panel();
        assertEquals(' ', panel.getLetter());
    }

    /**
     * Get a initial color.
     *
     * @result color should be set GRAY after initialization in constructor.
     */
    @Test
    public void shouldGetInitialColor() {
        Panel panel = new Panel();
        assertEquals(Colors.GRAY, panel.getColor());
    }

    /**
     * Set a letter.
     *
     * @result letter should be 'A' after setLetter being called with 'A'.
     */
    @Test
    public void shouldSetLetter() {
        Panel panel = new Panel();
        panel.setLetter('A');
        assertEquals('A', panel.getLetter());
    }

    /**
     * Set a color.
     *
     * @result color should be YELLOW after setColor being called with YELLOW.
     */
    @Test
    public void shouldSetColor() {
        Panel panel = new Panel();
        panel.setColor(Colors.YELLOW);
        assertEquals(Colors.YELLOW, panel.getColor());
    }

}