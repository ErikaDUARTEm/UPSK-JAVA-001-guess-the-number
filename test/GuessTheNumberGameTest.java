import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;


public class GuessTheNumberGameTest {
   @Test
   void testRange1to100(){
       GuessTheNumberGame game = new GuessTheNumberGame();

       // Prueba con números válidos dentro del rango (de 1 a 100)
       assertTrue(game.isValidGuess(1));
       assertTrue(game.isValidGuess(50));
       assertTrue(game.isValidGuess(100));
   }
    @Test
    public void testInvalidRange() {
        GuessTheNumberGame game = new GuessTheNumberGame();

        // Prueba con números fuera del rango (menores a 1 y mayores a 100)
        assertFalse(game.isValidGuess(0));
        assertFalse(game.isValidGuess(101));
        assertFalse(game.isValidGuess(-5));
    }
}












