import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {

        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Genera un número aleatorio entre 1 y 100

        Scanner addName = new Scanner(System.in);
        System.out.println("Bienvenido al juego de adivinanza.");
        System.out.println("Ingresa tu nombre: ");
        String namePlayer = addName.nextLine();
        Player humanPlayer = new HumanPlayer(namePlayer);
        Player computerPlayer = new ComputerPlayer("Computadora");

        System.out.println("Hola " + humanPlayer.getName() + " Debes elegir un número entre 1 y 100.");

        int count = 0;
        boolean winner= false;

        while (!winner) {
            count++;
            System.out.println("-----------------ROUND " + count + "---------------- ");

            int humanGuess = humanPlayer.makeGuess();
            int lastHumanGuess = humanGuess;
            System.out.println(humanPlayer.getName() + " supone que el número es: " + humanGuess);

            if (humanGuess < targetNumber) {
                System.out.println("El número que debes adivinar es mayor.");
            } else if (humanGuess > targetNumber) {
                System.out.println("El número que debes adivinar es menor.");
            } else {
                System.out.println("¡Felicidades, " + humanPlayer.getName() + "! Adivinaste el número. ¡Ganaste!");
                winner = true;
                break;
            }
            int computerGuess = computerPlayer.makeGuess();
            if(lastHumanGuess < targetNumber){
                computerGuess = lastHumanGuess +1;
            }else if(lastHumanGuess > targetNumber){
                computerGuess = lastHumanGuess -1;
            }


            System.out.println("La computadora elige: " + computerGuess);
            if (computerGuess < targetNumber) {
                System.out.println("El número que debes adivinar es mayor.");
            } else if (computerGuess > targetNumber) {
                System.out.println("El número que debes adivinar es menor.");
            } else {
                System.out.println("Turno de la computadora: La computadora adivinó el número. ¡Perdiste!");
                winner = true;
                break;
            }
        }

        // historial de suposiciones al final del juego
        humanPlayer.guessHistory();
        computerPlayer.guessHistory();
    }
}
