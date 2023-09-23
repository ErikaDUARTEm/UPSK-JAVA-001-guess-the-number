import java.util.Scanner;

class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int makeGuess() {
        System.out.print(getName() + ", ingresa tu número: ");
        int guess = scanner.nextInt();
        addGuess(guess);
        return guess;
    }
}