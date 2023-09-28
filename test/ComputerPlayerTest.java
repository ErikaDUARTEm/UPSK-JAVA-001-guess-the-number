import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {

    @Test
    public void testName(){

        ComputerPlayer player = new ComputerPlayer("Computadora");
        assertEquals("Computadora", player.getName());
    }
    @Test
    public void testMakeGuess(){
        ComputerPlayer computer = new ComputerPlayer("Computadora");
        computer.makeGuess();

    }
}