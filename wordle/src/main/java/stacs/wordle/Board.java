package stacs.wordle;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Board
 *
 * @author Seigo
 */
public class Board {

    private int row;
    private Panel[][] panels;
    private String input;

    /**
     * constructor
     */
    public Board() {
        setPanels();
        createBoard();
    }

    /**
     * getter row
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * getter panels
     *
     * @return panels
     */
    public Panel[][] getPanels() {
        return panels;
    }

    /**
     * getter Panel
     *
     * @param i, j
     * @return Panel
     */
    public Panel getPanel(int i, int j) {
        return panels[i][j];
    }

    /**
     * getter input
     *
     * @return input
     */
    public String getInput() {
        return input;
    }

    /**
     * Check input is valid
     *
     * @param words
     * @return input
     */
    public boolean isInputValid(ArrayList<String> words) {
        return words.contains(getInput());
    }

    /**
     * setter row
     * Set row += 1
     */
    public void incrementRow() {
        row++;
    }

    /**
     * setter input
     *
     * @param input
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * setter letter in panel in panels
     * Set letter in input to panel in panels
     */
    public void setPanelLetter() {
        for (int i = 0; i < WordleManager.getLimitNumberOfLetters(); i++) {
            getPanels()[getRow()][i].setLetter(getInput().charAt(i));
        }
    }

    /**
     * setter panels
     * Initialize panels with [LIMIT_NUMBER_OF_ATTEMPTS][LIMIT_NUMBER_OF_LETTERS] size.
     */
    private void setPanels() {
        panels = new Panel[WordleManager.getLimitNumberOfAttempts()][WordleManager.getLimitNumberOfLetters()];
        for (int i = 0; i < WordleManager.getLimitNumberOfAttempts(); i++) {
            for (int j = 0; j < WordleManager.getLimitNumberOfLetters(); j++) {
                Panel panel = new Panel();
                panels[i][j] = panel;
            }
        }
    }

    /**
     * Print panel with its color and letter in console.
     */
    public void createBoard() {
        for (int i = 0; i < WordleManager.getLimitNumberOfAttempts(); i++) {
            for (int j = 0; j < WordleManager.getLimitNumberOfLetters(); j++) {
                Panel panel = getPanel(i, j);
                System.out.printf(panel.getColor().getCode() + " %C " + Colors.WHITE.getCode() + " ", panel.getLetter());
            }
            System.out.println("\n");
        }
    }

    /**
     * setter color in panel in panels.
     * Set proper color to panel in panels based on the letter in input.
     */
    public void setPanelColor(WordleManager wm) {
        LinkedHashMap<Character, Integer> letters = new LinkedHashMap<>(wm.getLetters());
        String answer = wm.getAnswer();

        for (int i = 0; i < WordleManager.getLimitNumberOfLetters(); i++) {

            Panel panel = getPanels()[getRow()][i];
            char letter = panel.getLetter();

            if (isCorrectLetterInTheCorrectPlace(letter, answer.charAt(i), letters.get(letter))) {
                panel.setColor(Colors.GREEN);
                letters.put(letter, letters.get(letter) - 1);
            } else if (isCorrectLetterInTheWrongPlace(letter, answer, letters.get(letter))) {
                panel.setColor(Colors.YELLOW);
                letters.put(letter, letters.get(letter) - 1);
            }
        }
    }

    /**
     * Check isCorrectLetterInTheCorrect is valid
     *
     * @param letter, answerChar, letters
     * @return letter is correct and in right position is true or false
     */
    public boolean isCorrectLetterInTheCorrectPlace (char letter, char answerChar, Integer letters) {
        return letter == answerChar && letters >= 1;
    }

    /**
     * Check isCorrectLetterInTheWrongPlace is valid
     *
     * @param letter, answer, letters
     * @return letter is correct and in wrong position is true or false
     */
    public boolean isCorrectLetterInTheWrongPlace (char letter, String answer, Integer letters) {
        return answer.contains(String.valueOf(letter)) && letters >= 1;
    }

}
