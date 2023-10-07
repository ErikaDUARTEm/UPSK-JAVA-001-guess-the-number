import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    //Este método valida que el número que introduce el humano sea entre 1 y 100
    public static boolean isValidGuess(int humanGuess) {
        return humanGuess >= 1 && humanGuess <= 100;
    }
    //Método main que inicializa un programa en java
    public static void main(String[] args) {
        //Instancia de la clase random de java para generar numeros aleatorios
        Random random = new Random();
        //Se genera el numero random que se debe adivinar entre el 1 y 100.
        int targetNumber = random.nextInt(100) + 1;
        //Se instancia la clase scanner para capturar el numero que introduzca el jugador en el input
        Scanner addName = new Scanner(System.in);
        System.out.println(" ｡:ﾟ૮ ˶ˆ ﻌ ˆ˶ ა ﾟ:｡ Bienvenido al juego de adivinanza. ｡:ﾟ૮ ˶ˆ ﻌ ˆ˶ ა ﾟ:｡");
        System.out.println("Ingresa tu nombre: ");

        //nombre ingresado por el jugador
        String namePlayer = addName.nextLine();
        //Se instancias las clases humanPlayer y computerPlayer y se le pasan los parametros necesarios, nombre y en el caso del computer
        //se le pasa el numero a adivinar para poder acceder a el al momento de generar la suposición del computerPlayer
        Player humanPlayer = new HumanPlayer(namePlayer);
        Player computerPlayer = new ComputerPlayer("Computadora", targetNumber);

        System.out.println("Hola 「 ✦ " + humanPlayer.getName() + " ✦ 」 👩🏻 Debes elegir un número entre 1 y 100.");
        //Se crea una variable llamada count que se encarga de contar los turnos.
        int count = 0;
        //Se crea una variable de tipo booleana que inicialice el juego sin ganador.
        boolean winner = false;
        //Mediante el while creamos un bucle que funcione hasta que la variable ganador pase su valor a true, es decir,
        //cuando se adivine el numero.
        while (!winner) {
            //el contador se aumenta con cada inicio del bucle.
            count++;
            System.out.println("-------*ฅ^•ﻌ•^ฅ*-------ROUND " + count + "--------*ฅ^•ﻌ•^ฅ*-------- ");
            //Se trae el numero del humanPlayer
            int humanGuess = humanPlayer.makeGuess();

            System.out.println(humanPlayer.getName() + " supone que el número es: 👩🏻" + humanGuess);
            //Se valida que el número ingresado por el humanPlayer sea entre 1 y 100.
            if (isValidGuess(humanGuess)) {
                //se valida que la suposición de humanPlayer sea menor que el numero a adivinar
                if (humanGuess < targetNumber) {
                    //si es menor se envia un mensaje que el numero debe ser mayor.
                    System.out.println("El número que debes adivinar es mayor. ⬆ ");
                    //Se valida que la suposición del humanPlayer sea mayor que el numero a adivinar
                } else if (humanGuess > targetNumber) {
                    //si es mayor se envia un mensaje que el numero a adivinar es menor
                    System.out.println("El número que debes adivinar es menor. ⬇");
                } else {
                    //si el numero es igual que el que se debe adivinar se envia un mensaje diciendole que es el ganador
                    System.out.println("¡Felicidades, 👩🏻" + humanPlayer.getName() + " !");
                    System.out.println();
                    System.out.println("٩( ᐛ )و ٩( ᐖ )人( ᐛ ) Adivinaste el número. ٩( ᐛ )و ٩( ᐖ )人( ᐛ )");
                    System.out.println();
                    System.out.println("٩( ᐛ )و ٩( ᐖ )人( ᐛ )و ¡Ganaste! ٩( ᐖ )人( ᐛ )و ٩( ᐛ )و ");
                    System.out.println();
                    //Se cambia la variable winner a true porque ya hay un ganador y se debe parar el bucle
                    winner = true;
                    break;
                }
                // Se le pasa el numero seleccionado por el jugador a la computadora para q decida
                computerPlayer.setLastHumanGuess(humanGuess);
                //Se trae el numero de la computer
                int computerGuess = computerPlayer.makeGuess();
                //Se envia el numero generado por la computer para acceder a el y decidir el proximo numero
                computerPlayer.setLastComputerGuess(computerGuess);
                //Se enseña el numero elegido por el computer
                System.out.println("La computadora elige: \uD83E\uDD16 " + computerGuess);
                //Se evalua si el numero de computer es menor que el que se debe adivinar
                if (computerGuess < targetNumber) {
                    //si si es menor se muestra el mensaje que el numero a adivinar es mayor
                    System.out.println("El número que debes adivinar es mayor. ⬆");
                    //Se evalua si el numero de computer es mayor a el que se debe adivinar
                } else if (computerGuess > targetNumber) {
                    //si es mayor se muestra un mensaje que el numero a adivinar es menor
                    System.out.println("El número que debes adivinar es menor. ⬇");
                } else {
                    //SI el numero generado por computer es igual al que se debe adivinar se muestra el mensaje que
                    //gano computer y el jugador perdió
                    System.out.println("La computadora \uD83E\uDD16 adivinó el número.");
                    System.out.println();
                    System.out.println("(｡•́︿•̀｡) (╥﹏╥) ¡Perdiste! (╥﹏╥) (｡•́︿•̀｡)");
                    System.out.println();
                    //se pasa la variable a true porque hay un ganador
                    winner = true;
                    break;
                }

            //si el numero del humanPlayer esta fuera del rango de 1 al 100
            } else {
                //genera un mensaje de fuera de rango y se sale del juego
                System.out.println("Error: el número introducido está fuera del rango. Debe ser del 1 al 100");
                break;
            }
        }

        //Muestra la cantidad de intentos que se generaron para adivinart
        System.out.println("El número de intentos fueron: " + count);
        //Se muestra el array de suposiciones del humanPlayer y el array de el computer
        humanPlayer.guessHistory();
        computerPlayer.guessHistory();
    }

}
