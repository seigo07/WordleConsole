package stacs.wordle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BoardTest
 *
 * @author Seigo
 */
class BoardTest {

    Board board;
    WordleManager wordleManager;

    /**
     * Initialize Board and WordleManager before tests.
     */
    @BeforeEach
    void setUp() throws FileNotFoundException {
        board = new Board();
        wordleManager = new WordleManager(WordleManagerTest.getWordlistTestFilePath());
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Set panels.
     *
     * @result panels should be two-dimensional array with [LIMIT_NUMBER_OF_ATTEMPTS][LIMIT_NUMBER_OF_LETTERS] size after initialization in constructor
     */
    @Test
    public void shouldCreatePanels() {
        assertTrue(
                board.getPanels().length == WordleManager.getLimitNumberOfAttempts()
                        && board.getPanels()[0].length == WordleManager.getLimitNumberOfLetters()
        );
    }

    /**
     * get a letter.
     *
     * @result each panel should have letter of ' ' after initialization in constructor
     */
    @Test
    public void shouldGetLetter() {
        assertEquals(' ', board.getPanel(0, 0).getLetter());
    }

    /**
     * Set each panel color.
     *
     * @result each panel in panels should have GRAY color after initialization in constructor
     */
    @Test
    public void hasGrayColor() {
        assertEquals(Colors.GRAY, board.getPanel(0, 0).getColor());
    }

    /**
     * Get a row.
     *
     * @result row should be equal to 1 after incrementRow being called.
     */
    @Test
    public void shouldGetRow() {
        board.incrementRow();
        assertEquals(1, board.getRow());
    }

    /**
     * Get a panels.
     *
     * @result panels should be not null.
     */
    @Test
    public void shouldGetPanels() {
        assertNotNull(board.getPanels());
    }

    /**
     * Get a panel.
     *
     * @result panels should be not null.
     */
    @Test
    public void shouldGetPanel() {
        Panel panel = board.getPanel(1, 2);
        assertNotNull(panel);
    }

    /**
     * Get an input.
     *
     * @result input should be equal to "MAVEN" after setInput being called with "MAVEN".
     */
    @Test
    public void shouldGetInput() {
        board.setInput("MAVEN");
        assertEquals("MAVEN", board.getInput());
    }

    /**
     * Test inputWord is valid.
     *
     * @result should be true after setInput being called with the valid word.
     */
    @Test
    public void isInputValid() {
        board.setInput("MAVEN");
        assertTrue(board.isInputValid(wordleManager.getWords()));
    }

    /**
     * Test inputWord is invalid.
     *
     * @result should be false after setInput being called with the valid word.
     */
    @Test
    public void isInputInvalid() {
        board.setInput("HOGE");
        assertFalse(board.isInputValid(wordleManager.getWords()));
    }

    /**
     * Set letter in panel.
     *
     * @result letter in each panel should be equal to each letter of "MAVEN"
     * after setPanelLetter and setInput with "MAVEN" being called.
     */
    @Test
    public void shouldSetPanelLetter() {
        board.setInput("MAVEN");
        board.setPanelLetter();
        assertTrue(
                board.getPanels()[0][0].getLetter() == 'M'
                        && board.getPanels()[0][1].getLetter() == 'A'
                        && board.getPanels()[0][2].getLetter() == 'V'
                        && board.getPanels()[0][3].getLetter() == 'E'
                        && board.getPanels()[0][4].getLetter() == 'N'
        );
    }

    /**
     * Set color in panel.
     *
     * @result color in each panel should be equal to appropriate color
     * after setInput with "MAVEN", setPanelLetter, and setPanelColor with WordleManager being called.
     */
    @Test
    public void shouldSetPanelColor() {
        board.setInput("MAVEN");
        board.setPanelLetter();
        board.setPanelColor(wordleManager);
        boolean[] trues = new boolean[3];
        if (wordleManager.getAnswer().equals("MAVEN")) {
            Panel panel = board.getPanels()[0][3];
            trues[0] = panel.getColor() == Colors.GREEN;
        } else if (wordleManager.getAnswer().equals("DEBUG")) {
            Panel panel = board.getPanels()[0][3];
            trues[1] = panel.getColor() == Colors.YELLOW;
        } else if (wordleManager.getAnswer().equals("CACHE")) {
            Panel panel = board.getPanels()[0][0];
            trues[2] = panel.getColor() == Colors.GRAY;
        }
        assertTrue(trues[0] || trues[1] || trues[2]);
    }

}