import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private int[] guesses;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getGuesses() {
        return this.guesses;
    }

    public void setGuesses(int[] guesses) {
        this.guesses = guesses;
    }
}