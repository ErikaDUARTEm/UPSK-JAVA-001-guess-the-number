import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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
        ComputerPlayer computerPlayer = new ComputerPlayer(name, 50);


    }
}