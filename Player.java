abstract class Player {
    private String name;
    private int[] guesses;

    public Player(String name) {
        this.name = name;
        this.guesses = new int[0];
    }

    public String getName() {
        return name;
    }

    public int[] getGuesses() {
        return guesses;
    }

    public void addGuess(int guess) {
        int[] newGuesses = new int[guesses.length + 1];
        System.arraycopy(guesses, 0, newGuesses, 0, guesses.length);
        newGuesses[guesses.length] = guess;
        guesses = newGuesses;
    }

    public abstract int makeGuess();

    public void guessHistory() {
        System.out.println("Todas las suposiciones de  " + getName() + " fueron: " );
        for (int guess : getGuesses()) {
            System.out.print(guess + " ");
        }
        System.out.println(); // Agrega un salto de línea para separar los historiales
    }
}