import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.scanner.MockScanner;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {
   @Test
   public void testName(){
       HumanPlayer player = new HumanPlayer("Aaron");
       assertEquals("Aaron", player.getName());
   }
   @Test
   public void testMakeGuess(){

   }
}