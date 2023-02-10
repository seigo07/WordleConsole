package stacs.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * WordleManager
 * Wordle game management class
 *
 * @author Seigo
 */
class WordleManager {

    private static final String WORDLIST_FILE_PATH = "wordle/src/main/resources/wordlist.txt";
    private static final String SUCCESS_MESSAGE = "Congratulations! Your score is ";
    private static final String FAILURE_MESSAGE = "Failure. The correct answer is ";
    private static final int LIMIT_NUMBER_OF_LETTERS = 5;
    private static final int LIMIT_NUMBER_OF_ATTEMPTS = 6;

    private String answer;
    private String outputText;
    private ArrayList<String> words;
    private LinkedHashMap<Character, Integer> letters;
    private int numberOfAttempts;

    /**
     * constructor
     */
    public WordleManager(String filePath) throws FileNotFoundException {
        words = loadWordlist(filePath);
        setAnswer();
        setLetters();
    }

    /**
     * Load text file from given path.
     * Read each word line by line and add it to String list.
     *
     * @return word list loaded from given path.
     */
    protected static ArrayList<String> loadWordlist(String wordlistPath) throws FileNotFoundException {
        Scanner s = new Scanner(new File(wordlistPath));
        ArrayList<String> wordlist = new ArrayList<>();
        while (s.hasNext()) {
            wordlist.add(s.next().toUpperCase());
        }
        s.close();
        return wordlist;
    }

    /**
     * setter answer
     * Get an answer from answers randomly (from index of Math.random() * answers.size())
     * Set it to answer.
     */
    private void setAnswer() {
        answer = words.get((int) (Math.random() * words.size()));
    }

    /**
     * Organize letters with each character and its numbers based on NUMBER_OF_LETTERS.
     */
    private void setLetters() {
        letters = new LinkedHashMap<>();
        int k;
        for (int i = 0; i < WordleManager.getLimitNumberOfLetters(); i++) {
            k = 1;
            for (int j = 0; j < WordleManager.getLimitNumberOfLetters(); j++) {
                if (i != j && answer.charAt(i) == answer.charAt(j))
                    k++;
            }
            letters.put(answer.charAt(i), k);
        }
    }

    /**
     * getter answer
     *
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * getter outputText
     *
     * @return outputText
     */
    public String getOutputText() {
        return outputText;
    }

    /**
     * getter words
     *
     * @return words
     */
    public ArrayList<String> getWords() {
        return words;
    }

    /**
     * getter letters
     *
     * @return letters
     */
    public LinkedHashMap<Character, Integer> getLetters() {
        return letters;
    }

    /**
     * getter numberOfAttempts
     *
     * @return numberOfAttempts
     */
    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    /**
     * getter NUMBER_OF_LETTERS
     *
     * @return NUMBER_OF_LETTERS
     */
    public static int getLimitNumberOfLetters() {
        return LIMIT_NUMBER_OF_LETTERS;
    }

    /**
     * getter NUMBER_OF_ATTEMPTS
     *
     * @return NUMBER_OF_ATTEMPTS
     */
    public static int getLimitNumberOfAttempts() {
        return LIMIT_NUMBER_OF_ATTEMPTS;
    }

    /**
     * getter WORDLIST_FILE_PATH
     *
     * @return WORDLIST_FILE_PATH
     */
    public static String getWordlistFilePath() {
        return WORDLIST_FILE_PATH;
    }

    /**
     * getter SUCCESS_MESSAGE
     *
     * @return SUCCESS_MESSAGE
     */
    public static String getSuccessMessage() {
        return SUCCESS_MESSAGE;
    }

    /**
     * getter FAILURE_MESSAGE
     *
     * @return FAILURE_MESSAGE
     */
    public static String getFailureMessage() {
        return FAILURE_MESSAGE;
    }

    /**
     * Check inputWord is equal to answer.
     *
     * @param inputWord
     * @return inputWord is equal to answer is true or false.
     */
    public boolean isAnswer(String inputWord) {
        return inputWord.equals(answer);
    }

    /**
     * setter outputText
     * Set SUCCESS_MESSAGE or FAILURE_MESSAGE to outputText based on isSuccess.
     *
     * @param isSuccess
     */
    public void setOutputText(boolean isSuccess) {
        outputText = isSuccess ? SUCCESS_MESSAGE + numberOfAttempts : FAILURE_MESSAGE + answer.toUpperCase();
    }

    /**
     * setter numberOfAttempts
     *
     * @param numberOfAttempts
     */
    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

}
