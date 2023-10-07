import java.util.Random;

public class ComputerPlayer extends Player {
    Random random = new Random();
    //Se inicializa la suposicion anterior del humanPlayer y la anterior del computer en -1; es decir, fuera del rango.
    private int lastHumanGuess = -1;
    private int lastComputerGuess = -1;
    private int targetNumber;
    //por medio del constructor accedo al nombre y numero a adivinar
    public ComputerPlayer(String name, int targetNumber) {
        super(name);
        this.targetNumber= targetNumber;

    }

    // Método para actualizar la última suposición del jugador
    public void setLastHumanGuess(int lastHumanGuess) {
        this.lastHumanGuess = lastHumanGuess;
    }
    //Metodo para actualizar la suposicion anterior del computerPlayer
    public void setLastComputerGuess(int lastComputerGuess){this.lastComputerGuess = lastComputerGuess;}
    //Metodo para traer la suposicion anterior del humanPlayer
    public int getLastHumanGuess(){return lastHumanGuess;}
    //Metodo para traer la suposicion anterior del computerPlayer
    public int getLastComputerGuess(){return lastComputerGuess;}
    //metodo que genera la suposicion del computerPlayer
    @Override
    public int makeGuess() {
        int computerGuess= -1;
        //Se evalua si la suposicion anterior del computer es igual a -1 es dcir si es la primera vez que va
        // a generar una suposicion o si el array de suposiciones anteriores contiene el numero nuevo a generar
        //genere un numero entre la suposicion anterior del human+1 y 100.
        if(lastComputerGuess == -1 || getGuesses().contains(computerGuess)){
            computerGuess = random.nextInt(lastComputerGuess+1, lastHumanGuess+1);
        } else {
                //Si el computer ya dijo su primer numero se evalua que el nuevo sea diferente al anterior
                if (computerGuess != lastComputerGuess) {
                    //Se evalua si la suposición del jugador es menor que el numero a adivinar
                    if (lastHumanGuess < targetNumber) {
                        // Se evalua si la suposición del computer es menor que el numero a adivinar
                        if (lastComputerGuess < targetNumber) {
                            computerGuess = random.nextInt(lastHumanGuess + 1, 100 + 1);
                         // SI la suposicion del computer es mayor que el numero a adivinar
                        } else {
                            computerGuess = random.nextInt(lastHumanGuess, lastComputerGuess);
                        }
                    } else { // si la suposición del jugador es mayor  que el numero a adivinar
                        if (lastComputerGuess > targetNumber) {
                            computerGuess = random.nextInt(targetNumber, lastHumanGuess);

                        } else {
                            computerGuess = random.nextInt(lastComputerGuess, lastHumanGuess + 1);
                        }
                    }
                } else { //si el numero del computer es igual al anterior de sebe generar otro numero entre uno mas q
                    //el anterior el q se debe adivinar
                    computerGuess = random.nextInt(lastComputerGuess + 1, targetNumber);
                }
        }
        //Este metodo envia el numero generado por el computer para introducirlo al array
        addGuess(computerGuess);
        return computerGuess;
    }
}
