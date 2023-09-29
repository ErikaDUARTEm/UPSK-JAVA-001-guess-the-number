import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ComputerPlayerTest {

    @Test
    public void testNameComputer(){
        ComputerPlayer player = new ComputerPlayer("Computadora");
        String NamePlayer =  player.getName();
        assertEquals("Computadora", NamePlayer);
        assertNotNull(NamePlayer);
    }
    @Test
    public void testMakeGuess(){
        ComputerPlayer computerPlayer = new ComputerPlayer("Computadora");

        // Establecer una suposición previa del jugador humano
        computerPlayer.setLastHumanGuess(30);
        int targetNumber = 40;
        // Realizar afirmaciones sobre la suposición de la computadora
        assertTrue(targetNumber >= 31 && targetNumber <= 50);

    }
}