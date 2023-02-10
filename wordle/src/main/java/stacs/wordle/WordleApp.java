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

    /**
     * Controller
     * Running game.
     *
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {

        Board board = new Board();
        WordleManager wordleManager = new WordleManager(WordleManager.getWordlistFilePath());

        for (int i = 0; i < board.getPanels().length; i++) {

            do {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter your answer: ");
                board.setInput(sc.next().toUpperCase());
                if (!board.isInputValid(wordleManager.getWords())) {
                    System.out.println("You entered an invalid word!");
                }
            } while (!board.isInputValid(wordleManager.getWords()));

            board.setPanelLetter();
            board.setPanelColor(wordleManager);
            board.createBoard();
            board.incrementRow();

            if (wordleManager.isAnswer(board.getInput())) {
                wordleManager.setNumberOfAttempts(board.getRow());
                wordleManager.setOutputText(true);
                break;
            }
            wordleManager.setOutputText(false);
        }

        System.out.println(wordleManager.getOutputText());

    }
}
