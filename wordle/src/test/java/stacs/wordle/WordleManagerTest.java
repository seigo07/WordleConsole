package stacs.wordle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WordleManagerTest
 *
 * @author Seigo
 */
class WordleManagerTest {

    private static final String WORDLIST_TEST_FILE_PATH = "src/test/resources/wordlist-test.txt";
    WordleManager wordleManager;

    /**
     * Initialize WordleManager before tests.
     */
    @BeforeEach
    void setUp() throws FileNotFoundException {
        wordleManager = new WordleManager(WORDLIST_TEST_FILE_PATH);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Load a word list.
     *
     * @result test wordlist only contains 3 words, so wordlist should have the size of 3.
     */
    @Test
    public void shouldLoadWordlist() throws FileNotFoundException {
        ArrayList<String> wordlist = wordleManager.loadWordlist(WORDLIST_TEST_FILE_PATH);
        assertEquals(3, wordlist.size());
    }

    /**
     * Get a words.
     *
     * @result words should be set from WORDLIST_FILE_PATH after initialization in constructor.
     */
    @Test
    public void shouldGetWords() throws FileNotFoundException {
        ArrayList<String> words = wordleManager.loadWordlist(WORDLIST_TEST_FILE_PATH);
        assertEquals(words, wordleManager.getWords());
    }

    /**
     * Get an answer.
     *
     * @result answer should be set to one of the word randomly from WORDLIST_FILE_PATH after initialization in constructor.
     */
    @Test
    public void shouldGetAnswer() throws FileNotFoundException {
        assertTrue(
                wordleManager.getAnswer().equals("MAVEN")
                        || wordleManager.getAnswer().equals("DEBUG")
                        || wordleManager.getAnswer().equals("CACHE")
        );
    }

    /**
     * Get a letters.
     *
     * @result letters should include one of 'E' char after initialization in constructor
     * as all word in wordlist-test.txt include one of 'E'.
     */
    @Test
    public void shouldGetLetters() {
        char letter = 'E';
        assertEquals(1, wordleManager.getLetters().get(letter));
    }

    /**
     * Get an outputText.
     *
     * @result outputText should be equal to SUCCESS_MESSAGE + numberOfAttempts
     * after called setOutputText with true.
     */
    @Test
    public void shouldGetOutputTextSuccess() {
        wordleManager.setNumberOfAttempts(3);
        wordleManager.setOutputText(true);
        assertEquals(wordleManager.getSuccessMessage() + wordleManager.getNumberOfAttempts(), wordleManager.getOutputText());
    }

    /**
     * Get an outputText.
     *
     * @result outputText should be equal to FAILURE_MESSAGE + answer
     * after called setOutputText with false.
     */
    @Test
    public void shouldGetOutputTextFailure() {
        wordleManager.setOutputText(false);
        assertEquals(wordleManager.getFailureMessage() + wordleManager.getAnswer().toUpperCase(), wordleManager.getOutputText());
    }

    /**
     * Get a LIMIT_NUMBER_OF_LETTERS.
     *
     * @result LIMIT_NUMBER_OF_LETTERS should be equal to 5.
     */
    @Test
    public void shouldGetLimitNumberOfLetters() {
        assertEquals(5, WordleManager.getLimitNumberOfLetters());
    }

    /**
     * Get a LIMIT_NUMBER_OF_ATTEMPTS.
     *
     * @result LIMIT_NUMBER_OF_ATTEMPTS should be equal to 6.
     */
    @Test
    public void shouldGetLimitNumberOfAttempts() {
        assertEquals(6, WordleManager.getLimitNumberOfAttempts());
    }

    /**
     * Get a WORDLIST_FILE_PATH.
     *
     * @result WORDLIST_FILE_PATH should be equal to "src/main/resources/wordlist.txt".
     */
    @Test
    public void shouldGetWordListFilePath() {
        assertEquals("src/main/resources/wordlist.txt", WordleManager.getWordlistFilePath());
    }

    /**
     * Get a SUCCESS_MESSAGE.
     *
     * @result SUCCESS_MESSAGE should be equal to "Congratulations! Your score is ".
     */
    @Test
    public void shouldGetSuccessMessage() {
        assertEquals("Congratulations! Your score is ", WordleManager.getSuccessMessage());
    }

    /**
     * Get a FAILURE_MESSAGE.
     *
     * @result FAILURE_MESSAGE should be equal to "Failure. The correct answer is ".
     */
    @Test
    public void shouldGetFailureMessage() {
        assertEquals("Failure. The correct answer is ", WordleManager.getFailureMessage());
    }

    /**
     * Test inputWord is equal to one of the answer.
     *
     * @result should be true when isAnswer is called with the correct answer.
     */
    @Test
    public void isAnswerTrue() {
        String inputWord = wordleManager.getAnswer();
        assertTrue(wordleManager.isAnswer(inputWord));
    }

    /**
     * Test inputWord is not equal to one of the answer.
     *
     * @result should be false when isAnswer is called with the incorrect answer.
     */
    @Test
    public void isAnswerFalse() {
        String inputWord = "TESTS";
        assertFalse(wordleManager.isAnswer(inputWord));
    }

    /**
     * Get a numberOfAttempts.
     *
     * @result numberOfAttempts should be equal to 3
     * after called setNumberOfAttempts with 3.
     */
    @Test
    public void shouldGetNumberOfAttempts() {
        wordleManager.setNumberOfAttempts(3);
        assertEquals(3, wordleManager.getNumberOfAttempts());
    }

}