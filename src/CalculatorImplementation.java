import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack;

    protected CalculatorImplementation() throws RemoteException {
        stack = new Stack<>();
    }

    @Override
    public synchronized void pushValue(int val) throws RemoteException {
        stack.push(val);
    }

    @Override
    public synchronized void pushOperation(String operator) throws RemoteException {
        if (stack.isEmpty()) {
            return;
        }
        int result = stack.pop();
        while (!stack.isEmpty()) {
            int value = stack.pop();
            switch (operator) {
                case "min":
                    result = Math.min(result, value);
                    break;
                case "max":
                    result = Math.max(result, value);
                    break;
                case "lcm":
                    result = lcm(result, value);
                    break;
                case "gcd":
                    result = gcd(result, value);
                    break;
            }
        }
        stack.push(result);
    }

    @Override
    public synchronized int pop() throws RemoteException {
        if (stack.isEmpty()) {
            throw new RemoteException("Stack is empty");
        }
        return stack.pop();
    }

    @Override
    public synchronized boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    @Override
    public synchronized int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pop();
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
