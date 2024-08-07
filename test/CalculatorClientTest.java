import java.rmi.Naming;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorClientTest {
    @Test
    public void testSingleClient() throws Exception {
        Calculator calc = (Calculator) Naming.lookup("//localhost/CalculatorService");
        calc.pushValue(10);
        calc.pushValue(20);
        calc.pushOperation("max");
        int result = calc.pop();
        assertEquals(20, result);
    }

    @Test
    public void testMultipleClients() throws Exception {
        Calculator calc1 = (Calculator) Naming.lookup("//localhost/CalculatorService");
        Calculator calc2 = (Calculator) Naming.lookup("//localhost/CalculatorService");

        calc1.pushValue(10);
        calc2.pushValue(20);
        calc1.pushOperation("min");
        int result = calc1.pop();
        assertEquals(10, result);
    }
}
