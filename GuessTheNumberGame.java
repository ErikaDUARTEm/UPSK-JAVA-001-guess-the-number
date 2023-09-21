import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {

        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Genera un número aleatorio entre 1 y 100

        Scanner addName = new Scanner(System.in);
        System.out.println(" ｡:ﾟ૮ ˶ˆ ﻌ ˆ˶ ა ﾟ:｡ Bienvenido al juego de adivinanza. ｡:ﾟ૮ ˶ˆ ﻌ ˆ˶ ა ﾟ:｡");
        System.out.println("Ingresa tu nombre: ");
        String namePlayer = addName.nextLine();
        Player humanPlayer = new HumanPlayer(namePlayer);
        Player computerPlayer = new ComputerPlayer("Computadora");

        System.out.println("Hola 「 ✦ " + humanPlayer.getName() + " ✦ 」 👩🏻 Debes elegir un número entre 1 y 100.");

        int count = 0;
        boolean winner= false;

        while (!winner) {
            count++;
            System.out.println("-------*ฅ^•ﻌ•^ฅ*-------ROUND " + count + "--------*ฅ^•ﻌ•^ฅ*-------- ");

            int humanGuess = humanPlayer.makeGuess();
            int lastHumanGuess = humanGuess;
            System.out.println(humanPlayer.getName() + " supone que el número es: 👩🏻" + humanGuess);
            if(humanGuess >= 1 && humanGuess <= 100){
                if (humanGuess < targetNumber) {
                    System.out.println("El número que debes adivinar es mayor. ⬆ ");
                } else if (humanGuess > targetNumber) {
                    System.out.println("El número que debes adivinar es menor. ⬇");
                } else {
                    System.out.println("¡Felicidades, 👩🏻" + humanPlayer.getName() + " !");
                    System.out.println("\uD83C\uDDE6 \uD83C\uDDE9 \uD83C\uDDEE \uD83C\uDDFB \uD83C\uDDEE \uD83C\uDDF3 \uD83C\uDDE6 \uD83C\uDDF8 \uD83C\uDDF9 \uD83C\uDDEA el número.");
                    System.out.println("٩( ᐛ )و ٩( ᐖ )人( ᐛ )و ¡Ganaste! ٩( ᐖ )人( ᐛ )و ٩( ᐛ )و ");
                    winner = true;
                    break;
                }
                int computerGuess = computerPlayer.makeGuess();
                if(lastHumanGuess < targetNumber){
                    if(computerGuess < lastHumanGuess){
                        computerGuess = lastHumanGuess +1;
                    }
                }else if(lastHumanGuess > targetNumber){
                    if(computerGuess > lastHumanGuess){
                        computerGuess = lastHumanGuess -1;
                    }
                }


                System.out.println("La computadora elige: \uD83E\uDD16 " + computerGuess);
                if (computerGuess < targetNumber) {
                    System.out.println("El número que debes adivinar es mayor. ⬆");
                } else if (computerGuess > targetNumber) {
                    System.out.println("El número que debes adivinar es menor. ⬇");
                } else {
                    System.out.println("La computadora \uD83E\uDD16 adivinó el número.");
                    System.out.println("(｡•́︿•̀｡) (╥﹏╥) ¡Perdiste! (╥﹏╥) (｡•́︿•̀｡)");
                    winner = true;
                    break;
                }
            }else{
                System.out.println("Error: el número introducido esta fuera del rango. Debe ser del 1 al 100");
            }

        }

        // historial de suposiciones al final del juego
        humanPlayer.guessHistory();
        computerPlayer.guessHistory();
    }
}
