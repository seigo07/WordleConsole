package stacs.wordle;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * WordleApp
 * Start-up class for game.
 *
 * @author Seigo
 */
public class WordleApp {

    Board board;
    WordleManager wordleManager;

    /**
     * Controller
     * Running game.
     *
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {

        WordleApp wordleApp = new WordleApp(WordleManager.getWordlistFilePath());

        while (wordleApp.isPossibleToContinue()) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter a five letter word: ");

            if (!wordleApp.isInputValid(sc.next().toUpperCase())) {
                System.out.println("Please enter a valid word");
                continue;
            }

            wordleApp.updateBoard();

            if (wordleApp.isAnswer()) {
                wordleApp.completeGame();
                break;
            }
            wordleApp.wordleManager.setOutputText(false);
        }

        System.out.println(wordleApp.wordleManager.getOutputText());
    }

    /**
     * constructor
     */
    public WordleApp(String filePath) throws FileNotFoundException {
        board = new Board();
        wordleManager = new WordleManager(filePath);
    }

    /**
     * Check is it possible to continue the game
     *
     * @return board.getRow() reaches board.getPanels().length is true or false.
     */
    public boolean isPossibleToContinue() {
        return board.getRow() < board.getPanels().length;
    }

    /**
     * Check input is valid
     *
     * @param input
     * @return input is valid is true or false.
     */
    public boolean isInputValid(String input) {
        board.setInput(input);
        return board.isInputValid(wordleManager.getWords());
    }

    /**
     * Call board methods to update it.
     */
    public void updateBoard() {
        board.setPanelLetter();
        board.setPanelColor(wordleManager);
        board.createBoard();
        board.incrementRow();
    }

    /**
     * Check input is equal to answer.
     *
     * @return input is equal to answer is true or false.
     */
    public boolean isAnswer() {
        return wordleManager.isAnswer(board.getInput());
    }

    /**
     * Finish game by output score when the input is equal to the answer.
     */
    public void completeGame() {
        wordleManager.setNumberOfAttempts(board.getRow());
        wordleManager.setOutputText(true);
    }

}
