import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {
   @Test
   public void testName(){
       HumanPlayer player = new HumanPlayer("Aaron");
       assertEquals("Aaron", player.getName());
   }
}