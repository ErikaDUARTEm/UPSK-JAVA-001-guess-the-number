import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
        public static void main(String[] args) {

            Random random = new Random();
            int numeroAleatorio = random.nextInt(100) + 1; // Genera un número aleatorio entre 1 y 100
            Scanner sc = new Scanner(System.in);

            Player computerPlayer = new Player();
            computerPlayer.setName("Computadora");

            Player humanPlayer = new Player();
            humanPlayer.setName("Jugador");

            System.out.println("Bienvenido al juego de adivinanza. Debes elegir un número entre 1 y 100.");
            int count = 0;
            // usar variable de juego terminado con false y cambiar a true al ganar.
            // usar variable de ganador
            // revisar los objetivos de aprendizaje.
            while (true) {
                // Turno del jugador
                count++;
                System.out.println("-----------------ROUND " + count + "---------------- ");
                System.out.print("Es el turno de:  " + humanPlayer.getName() + ", ingresa tu número: ");

                int cantidad = sc.nextInt();
                int[] guesses = humanPlayer.getGuesses();

                if (guesses == null) {
                    guesses = new int[1];
                    guesses[0] = cantidad;
                } else {
                    int[] newGuesses = new int[guesses.length + 1];
                    System.arraycopy(guesses, 0, newGuesses, 0, guesses.length);
                    newGuesses[guesses.length] = cantidad;
                    guesses = newGuesses;
                }
                humanPlayer.setGuesses(guesses);

                if (cantidad < numeroAleatorio) {
                    System.out.println("El número es mayor. Intenta de nuevo.");

                } else if (cantidad > numeroAleatorio) {
                    System.out.println("El número es menor. Intenta de nuevo.");

                } else {
                    System.out.println("¡Felicidades, " + humanPlayer.getName() + "! Adivinaste el número. ¡Ganaste!");
                    int[] lista = humanPlayer.getGuesses();
                    for(int i = 0; i < lista.length; i++) {
                        System.out.println("Los números usados fueron: " + lista[i] );
                    }
                    break;
                    }


                // Turno de la computadora
                int computerGuess = random.nextInt(100) + 1;

                if (computerGuess < numeroAleatorio) {
                    System.out.println("-----------------ROUND" + count + "---------------- :" );
                    System.out.println("Es el turno de : "+ computerPlayer.getName() + "." + " La computadora elige: " + computerGuess + ". El número es mayor.");

                } else if (computerGuess > numeroAleatorio) {
                    System.out.println("Es el turno de : "+ computerPlayer.getName() + " La computadora elige: "  + computerGuess + ". El número es menor.");

                } else {
                    System.out.println("Turno de la computadora: La computadora adivinó el número. ¡Perdiste!");
                    int[] lista2 = computerPlayer.getGuesses();
                    for(int i = 0; i < lista2.length; i++) {
                        System.out.println("Los números usados fueron: " + lista2[i] );
                    }
                    break;
                }



            }

        }

}