import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {

        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;

        Scanner addName = new Scanner(System.in);
        System.out.println(" ｡:ﾟ૮ ˶ˆ ﻌ ˆ˶ ა ﾟ:｡ Bienvenido al juego de adivinanza. ｡:ﾟ૮ ˶ˆ ﻌ ˆ˶ ა ﾟ:｡");
        System.out.println("Ingresa tu nombre: ");

        //nombre ingresado por el jugador
        String namePlayer = addName.nextLine();
        Player humanPlayer = new HumanPlayer(namePlayer);
        Player computerPlayer = new ComputerPlayer("Computadora");

        System.out.println("Hola 「 ✦ " + humanPlayer.getName() + " ✦ 」 👩🏻 Debes elegir un número entre 1 y 100.");

        int count = 0;
        boolean winner = false;

        while (!winner) {
            count++;
            System.out.println("-------*ฅ^•ﻌ•^ฅ*-------ROUND " + count + "--------*ฅ^•ﻌ•^ฅ*-------- ");

            int humanGuess = humanPlayer.makeGuess();

            System.out.println(humanPlayer.getName() + " supone que el número es: 👩🏻" + humanGuess);
            //Se valida que el número ingresado sea entre 1 y 100.
            if (humanGuess >= 1 && humanGuess <= 100) {
                if (humanGuess < targetNumber) {
                    System.out.println("El número que debes adivinar es mayor. ⬆ ");
                } else if (humanGuess > targetNumber) {
                    System.out.println("El número que debes adivinar es menor. ⬇");
                } else {
                    System.out.println("¡Felicidades, 👩🏻" + humanPlayer.getName() + " !");
                    System.out.println();
                    System.out.println("٩( ᐛ )و ٩( ᐖ )人( ᐛ ) Adivinaste el número. ٩( ᐛ )و ٩( ᐖ )人( ᐛ )");
                    System.out.println();
                    System.out.println("٩( ᐛ )و ٩( ᐖ )人( ᐛ )و ¡Ganaste! ٩( ᐖ )人( ᐛ )و ٩( ᐛ )و ");
                    System.out.println();
                    winner = true;
                    break;
                }
                // Se le pasa el numero seleccionado por el jugador a la computadora para q decida
                computerPlayer.setLastHumanGuess(humanGuess);
                int computerGuess = computerPlayer.makeGuess();

                System.out.println("La computadora elige: \uD83E\uDD16 " + computerGuess);

                if (computerGuess < targetNumber) {
                    System.out.println("El número que debes adivinar es mayor. ⬆");
                } else if (computerGuess > targetNumber) {
                    System.out.println("El número que debes adivinar es menor. ⬇");
                } else {
                    System.out.println("La computadora \uD83E\uDD16 adivinó el número.");
                    System.out.println();
                    System.out.println("(｡•́︿•̀｡) (╥﹏╥) ¡Perdiste! (╥﹏╥) (｡•́︿•̀｡)");
                    System.out.println();
                    winner = true;
                    break;
                }
            } else {
                System.out.println("Error: el número introducido está fuera del rango. Debe ser del 1 al 100");
            }
        }

        // historial de suposiciones al final del juego
        humanPlayer.guessHistory();
        computerPlayer.guessHistory();
    }
}
