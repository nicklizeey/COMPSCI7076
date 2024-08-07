import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calc = (Calculator) Naming.lookup("//localhost/CalculatorService");
            calc.pushValue(10);
            calc.pushValue(20);
            calc.pushOperation("max");
            int result = calc.pop();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Calculator Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
