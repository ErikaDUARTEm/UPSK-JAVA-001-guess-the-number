import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random = new Random();
    private int lastHumanGuess = -1;
    private int targetNumber;
    public ComputerPlayer(String name, int targetNumber) {
        super(name);
        this.targetNumber = targetNumber;

    }

    // Método para establecer la última suposición del jugador humano
    public void setLastHumanGuess(int lastHumanGuess) {
        this.lastHumanGuess = lastHumanGuess;
    }

    @Override
    public int makeGuess() {
        int computerGuess= 0;

        // Si tenemos información sobre la última suposición del jugador humano, ajustamos la suposición de la computadora
            if (lastHumanGuess < targetNumber) {
                computerGuess += random.nextInt(100 - lastHumanGuess) + lastHumanGuess + 1;
            } else if (lastHumanGuess > targetNumber) {
                computerGuess += random.nextInt(lastHumanGuess) + 1;
            }

        addGuess(computerGuess);
        return computerGuess;
    }
}
