import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Player {
    private String name;
    private List<Integer> guesses;

    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
    }
    public void setLastHumanGuess(int guess){};
    public void setLastComputerGuess(int guess){};
    public String getName() {
        return name;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public void addGuess(int guess) {
        guesses.add(guess);
    }

    public int setTargetNumber() {
        return 0;
    }

    public abstract int makeGuess();

    public void guessHistory() {
        System.out.println("Todas las suposiciones de  " + getName() + " fueron: " );
        for (int guess : getGuesses()) {
            System.out.print(guess + " ");
        }
        System.out.println(); // un salto de línea
    }
}