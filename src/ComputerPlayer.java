import java.util.Random;

public class ComputerPlayer extends Player {
    Random random = new Random();
    private int lastHumanGuess = -1;
    private int lastComputerGuess = -1;
    private int targetNumber;

    public ComputerPlayer(String name, int targetNumber) {
        super(name);
        this.targetNumber= targetNumber;

    }

    // Método para establecer la última suposición del jugador
    public void setLastHumanGuess(int lastHumanGuess) {
        this.lastHumanGuess = lastHumanGuess;
    }
    public void setLastComputerGuess(int lastComputerGuess){this.lastComputerGuess = lastComputerGuess;}
    @Override
    public int makeGuess() {
        int computerGuess= -1;
            //toma en cuenta su suposicion anterior

        if((lastComputerGuess <  targetNumber) && (lastHumanGuess < targetNumber)){
            computerGuess = random.nextInt(lastHumanGuess + 1, 100+1); // Genera un número entre lastHumanGuess + 1 y 99
        }else if((lastComputerGuess > targetNumber) && (lastHumanGuess > targetNumber)){
            computerGuess = random.nextInt(1, lastHumanGuess); // Genera un número entre 1 y lastHumanGuess - 1
        }else{
            computerGuess = random.nextInt(1,100+1); // Genera un número entre 1 y 99
        }

        // Si tenemos información sobre la última suposición del jugador humano, ajustamos la suposición de la computadora

        addGuess(computerGuess);
        return computerGuess;
    }
}
