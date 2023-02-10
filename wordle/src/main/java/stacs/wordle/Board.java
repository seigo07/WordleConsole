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

    public Board() {
        createPanels();
        createBoard();
    }

    public int getRow() {
        return row;
    }

    public Panel[][] getPanels() {
        return panels;
    }

    public Panel getPanel(int i, int j) {
        return panels[i][j];
    }

    public String getInput() {
        return input;
    }

    public boolean isInputValid(ArrayList<String> words) {
        return words.contains(getInput());
    }

    public void incrementRow() {
        this.row++;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setPanelLetter() {
        for (int i = 0; i < WordleManager.getLimitNumberOfLetters(); i++) {
            getPanels()[getRow()][i].setLetter(getInput().charAt(i));
        }
    }

    private void createPanels() {
        panels = new Panel[WordleManager.getLimitNumberOfAttempts()][WordleManager.getLimitNumberOfLetters()];
        for (int i = 0; i < WordleManager.getLimitNumberOfAttempts(); i++) {
            for (int j = 0; j < WordleManager.getLimitNumberOfLetters(); j++) {
                Panel panel = new Panel();
                panels[i][j] = panel;
            }
        }
    }

    public void createBoard() {
        for (int i = 0; i < WordleManager.getLimitNumberOfAttempts(); i++) {
            for (int j = 0; j < WordleManager.getLimitNumberOfLetters(); j++) {
                Panel panel = getPanel(i, j);
                System.out.printf(panel.getColor().getCode() + " %C " + Colors.WHITE.getCode() + " ", panel.getLetter());
            }
            System.out.println("\n");
        }
    }

    public void setPanelColor(WordleManager wm) {
        LinkedHashMap<Character, Integer> letters = new LinkedHashMap<>(wm.getLetters());
        String answer = wm.getAnswer();

        for (int i = 0; i < WordleManager.getLimitNumberOfLetters(); i++) {

            Panel panel = getPanels()[getRow()][i];
            char letter = panel.getLetter();

            if (letter == answer.charAt(i) && letters.get(letter) >= 1) {
                panel.setColor(Colors.GREEN);
                letters.put(letter, letters.get(letter) - 1);
            } else if (answer.contains(String.valueOf(letter)) && letters.get(letter) >= 1) {
                panel.setColor(Colors.YELLOW);
                letters.put(letter, letters.get(letter) - 1);
            }
        }
    }

}
