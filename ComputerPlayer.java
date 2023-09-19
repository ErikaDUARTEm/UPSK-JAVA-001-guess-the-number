import java.util.Random;

class ComputerPlayer extends Player {
    private Random random = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int makeGuess() {
        int computerGuess = random.nextInt(100) + 1;
        addGuess(computerGuess);
        return computerGuess;
    }
}