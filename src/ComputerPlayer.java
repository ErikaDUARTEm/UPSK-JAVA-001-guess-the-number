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
    public int getLastHumanGuess(){return lastHumanGuess;}
    public int getLastComputerGuess(){return lastComputerGuess;}
    @Override
    public int makeGuess() {
        int computerGuess= -1;
            //toma en cuenta su suposicion anterior

        if(lastHumanGuess < targetNumber){
            if(lastComputerGuess <  targetNumber) {
            computerGuess = random.nextInt(lastHumanGuess + 1, 100 + 1);
              }
        }else if(lastHumanGuess > targetNumber){
              if(lastComputerGuess > targetNumber) {
                  computerGuess = random.nextInt(1, lastHumanGuess);
              }
        }else{
            computerGuess = random.nextInt(1,100+1);
        }

        addGuess(computerGuess);
        return computerGuess;
    }
}
