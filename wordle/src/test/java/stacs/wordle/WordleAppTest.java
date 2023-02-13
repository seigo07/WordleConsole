package stacs.wordle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WordleAppTest
 *
 * @author Seigo
 */
public class WordleAppTest {

    WordleApp wordleApp;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        wordleApp = new WordleApp(WordleManagerTest.getWordlistTestFilePath());
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Initialize board.
     *
     * @result board instance should not be null after initialization in constructor.
     */
    @Test
    public void shouldNotBeNull() {
        assertNotEquals(null, wordleApp.board);
    }

    /**
     * Initialize board.
     *
     * @result test wordlist should have 3 words after initialization in constructor.
     */
    @Test
    public void shouldHaveWords() {
        assertEquals(3, wordleApp.wordleManager.getWords().size());
    }

    /**
     * Test is it possible to continue the game.
     *
     * @result should be true after incrementRow being called three times.
     */
    @Test
    public void isPossibleToContinueTrue() {
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        assertTrue(wordleApp.isPossibleToContinue());
    }

    /**
     * Test is it not possible to continue the game.
     *
     * @result should be false after incrementRow being called six times.
     */
    @Test
    public void isPossibleToContinueFalse() {
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        assertFalse(wordleApp.isPossibleToContinue());
    }

    /**
     * Test input is valid.
     *
     * @result should be true after setInput being called with valid input.
     */
    @Test
    public void isInputValidTrue() {
        assertTrue(wordleApp.isInputValid("DEBUG"));
    }

    /**
     * Test input is invalid.
     *
     * @result should be false after setInput being called with invalid input.
     */
    @Test
    public void isInputValidFalse() {
        assertFalse(wordleApp.isInputValid("DEBU"));
    }

    /**
     * Set letter in panel.
     *
     * @result letter in each panel should be equal to each letter of "MAVEN"
     * after setInput with "MAVEN" and updateBoard being called.
     */
    @Test
    public void shouldSetPanelLetter() {
        wordleApp.board.setInput("MAVEN");
        wordleApp.updateBoard();
        assertTrue(
                wordleApp.board.getPanels()[0][0].getLetter() == 'M'
                        && wordleApp.board.getPanels()[0][1].getLetter() == 'A'
                        && wordleApp.board.getPanels()[0][2].getLetter() == 'V'
                        && wordleApp.board.getPanels()[0][3].getLetter() == 'E'
                        && wordleApp.board.getPanels()[0][4].getLetter() == 'N'
        );
    }

    /**
     * Set color in panel.
     *
     * @result color in each panel should be equal to appropriate color
     * after setInput with "MAVEN" and updateBoard being called.
     */
    @Test
    public void shouldSetPanelColor() {
        wordleApp.board.setInput("MAVEN");
        wordleApp.updateBoard();
        boolean[] trues = new boolean[3];
        if (wordleApp.wordleManager.getAnswer().equals("MAVEN")) {
            Panel panel = wordleApp.board.getPanels()[0][3];
            trues[0] = panel.getColor() == Colors.GREEN;
        } else if (wordleApp.wordleManager.getAnswer().equals("DEBUG")) {
            Panel panel = wordleApp.board.getPanels()[0][3];
            trues[1] = panel.getColor() == Colors.YELLOW;
        } else if (wordleApp.wordleManager.getAnswer().equals("CACHE")) {
            Panel panel = wordleApp.board.getPanels()[0][0];
            trues[2] = panel.getColor() == Colors.GRAY;
        }
        assertTrue(trues[0] || trues[1] || trues[2]);
    }

    /**
     * Get a row.
     *
     * @result row should be equal to 1 after setInput with "MAVEN" and updateBoard being called.
     */
    @Test
    public void shouldIncrementRow() {
        wordleApp.board.setInput("MAVEN");
        wordleApp.updateBoard();
        assertEquals(1, wordleApp.board.getRow());
    }

    /**
     * Test input is equal to answer.
     *
     * @result should be true after setInput being called with input which is equal to the answer.
     */
    @Test
    public void isAnswerTrue() {
        if (wordleApp.wordleManager.getAnswer().equals("MAVEN")) {
            wordleApp.board.setInput("MAVEN");
            assertTrue(wordleApp.wordleManager.isAnswer(wordleApp.board.getInput()));
        } else if (wordleApp.wordleManager.getAnswer().equals("DEBUG")) {
            wordleApp.board.setInput("DEBUG");
            assertTrue(wordleApp.wordleManager.isAnswer(wordleApp.board.getInput()));
        } else if (wordleApp.wordleManager.getAnswer().equals("CACHE")) {
            wordleApp.board.setInput("CACHE");
            assertTrue(wordleApp.wordleManager.isAnswer(wordleApp.board.getInput()));
        }
    }

    /**
     * Test input is not equal to answer.
     *
     * @result should be false after setInput being called with input which is not equal to the answer.
     */
    @Test
    public void isAnswerFalse() {
        wordleApp.board.setInput("APPLE");
        assertFalse(wordleApp.wordleManager.isAnswer(wordleApp.board.getInput()));
    }

    /**
     * Test output log is correct after complete game.
     *
     * @result outputText should be equal to the text with score 3
     * after three-times incrementRow and completeGame being called.
     */
    @Test
    public void shouldOutputText() {
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        wordleApp.board.incrementRow();
        wordleApp.completeGame();
        assertEquals("Congratulations! Your score is 3", wordleApp.wordleManager.getOutputText());
    }

}
