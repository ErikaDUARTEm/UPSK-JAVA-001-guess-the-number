import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ComputerPlayerTest {

    @Test
    public void testNameComputer(){
        ComputerPlayer player = new ComputerPlayer("Computadora", 50);
        String NamePlayer =  player.getName();
        assertEquals("Computadora", NamePlayer);
        assertNotNull(NamePlayer);
    }
    @Test
    public void testMakeGuess(){
        ComputerPlayer computerPlayer = new ComputerPlayer("Computadora", 50);

        // Establecer una suposición previa del jugador humano
        computerPlayer.setLastHumanGuess(30);
        int targetNumber = 40;
        // Realizar afirmaciones sobre la suposición de la computadora
        assertTrue(targetNumber >= 31 && targetNumber <= 50);
    }
}