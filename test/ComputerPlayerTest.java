import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class ComputerPlayerTest {
    String name = "Computadora";
    @Test
    public void testNameComputer(){

        ComputerPlayer player = new ComputerPlayer(name, 50);
        String NamePlayer =  player.getName();
        assertEquals(name, NamePlayer);
        assertNotNull(NamePlayer);
    }

    @Test
    public void testInitialization() {
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer", 47);
        assertEquals(-1, computerPlayer.getLastHumanGuess());
        assertEquals(-1, computerPlayer.getLastComputerGuess());
    }
    @Test
    public void testMakeGuess(){
        int targetNumber = 50;
        ComputerPlayer computerPlayer = new ComputerPlayer(name, targetNumber);

        int numberComputer = computerPlayer.getLastHumanGuess();
        assertNotNull(computerPlayer);
        assertTrue(numberComputer < targetNumber);
        assertFalse(numberComputer > targetNumber);
        assertNotEquals(numberComputer, targetNumber);

    }
}