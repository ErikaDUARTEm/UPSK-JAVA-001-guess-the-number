import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.internal.configuration.injection.scanner.MockScanner;
import org.junit.jupiter.api.BeforeEach;
import java.util.Scanner;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {
    @Mock
    private Scanner scannerMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

   @DisplayName("Nombre del jugador")
   @Test
   public void testName(){
        String name = "Aaron";
       HumanPlayer player = new HumanPlayer(name);
       String NamePlayer =  player.getName();
       assertEquals(name, NamePlayer);
       assertNotNull(NamePlayer);
   }

   @DisplayName("Suposicion del jugador")
   @Test
   public void testMakeGuess(){
      //Simulando el numero de entrada
       when(scannerMock.nextInt()).thenReturn(42);
       HumanPlayer humanPlayer = new HumanPlayer("Aaron");
       humanPlayer.setScanner(scannerMock); // Inyectar el mock del Scanner

       // Llamar al método makeGuess()
       int guess = humanPlayer.makeGuess();

       // Verificar que el resultado sea el esperado (42 en este caso)

       assertEquals(42, guess);
      }
}

