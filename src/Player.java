import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Player {
    private String name;
    private List<Integer> guesses;

    //Constructor de player que inicializa nombre y array para que sus clases extends las usen.
    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
    }
    public void setLastHumanGuess(int guess){};
    public void setLastComputerGuess(int guess){};
    //metodo para traer nombre
    public String getName() {
        return name;
    }

    //metodo para traer array de suposiciones
    public List<Integer> getGuesses() {
        return guesses;
    }
    //Metodo que agrega las suposiciones al array que se muestra al final de juego
    public void addGuess(int guess) {
        guesses.add(guess);
    }

    public abstract int makeGuess();
    //metodo que devuelve el array con todas las suposiciones.
    public void guessHistory() {
        System.out.println("Todas las suposiciones de  " + getName() + " fueron: " );
        for (int guess : getGuesses()) {
            System.out.print(guess + " ");
        }
        System.out.println(); // un salto de línea
    }
}