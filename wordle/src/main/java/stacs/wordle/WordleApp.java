package stacs.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;

public class WordleApp
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to CS5031 - Wordle");
    }

    // Unimplemented skeleton
    // You may refactor this method
    protected static ArrayList<String> loadWordlist(String wordlistPath) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File(wordlistPath));
        ArrayList<String> wordlist = new ArrayList<String>();
        while (s.hasNext()){
            wordlist.add(s.next());
        }
        s.close();

        return wordlist;
    }
}
