import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            CalculatorImplementation calc = new CalculatorImplementation();
            Naming.rebind("CalculatorService", calc);
            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            System.err.println("Calculator Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
